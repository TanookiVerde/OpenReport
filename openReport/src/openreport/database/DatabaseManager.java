/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openreport.database;

import java.sql.*;
import com.mchange.v2.c3p0.*;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Aureo
 */
public class DatabaseManager {
    static String url = "jdbc:mysql://den1.mysql6.gear.host:3306/openreports";
    static String user = "openreports";
    static String password = "open1-";
    
    private static Connection con;
    private static ComboPooledDataSource cpds;
    
    private static ComboPooledDataSource initializeDataSource() throws PropertyVetoException{
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(url);
        cpds.setUser(user);
        cpds.setPassword(password);
        
        cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);
        
        return cpds;
    }
    
    public static Test callStatement(Test obj, String methodCall){
        CallableStatement cst = null;
        Connection con = connect();
        try {
            cst = con.prepareCall(methodCall);
            ResultSet rs = cst.executeQuery();
            obj.populate(rs);
           
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                cst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
        return obj;
    }
        
    public static Connection connect(){
        try {
            return cpds.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
    private static Connection getConnection() throws SQLException{
        if(con != null && !con.isClosed()){
            return con;
        }
        return connect();
    }
    
    

    public static void test(Connection c){
        try {
            Statement st = c.createStatement();
            ResultSet set = st.executeQuery("select * from professor");
            while(set.next()){
                String cpf = set.getString("CPF");
                String nome = set.getString("Nome");
                System.out.println(cpf + ' ' + nome);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void printResultSet(ResultSet set){
        try {
            ResultSetMetaData rsmd = set.getMetaData();
            int count = rsmd.getColumnCount();
            for(int i = 1; i <= count ; i++){
                    if (i > 1) System.out.print("\t| ");
                    System.out.print(rsmd.getColumnLabel(i));
                }
            System.out.println("");
            while(set.next()){
                for(int i = 1; i <= count ; i++){
                    if (i > 1) System.out.print("\t| ");
                    System.out.print(set.getString(i));
                }
                System.out.println("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String argv[]){
        try {
            //Connection c = DatabaseManager.connect();
            //test(c);
            cpds = initializeDataSource();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet rs = callStatement("call ALUNODISC(\"Historia\")");
        printResultSet(rs);
    }
    
    
}