/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openreport;

import java.sql.*;
import com.mchange.v2.c3p0.*;
import java.beans.PropertyVetoException;

/**
 *
 * @author Gabriel Aureo
 */
public class DBManager {
    static String url = "jdbc:mysql://den1.mysql6.gear.host:3306/openreports";
    static String user = "openreports";
    static String password = "open1-";
    
    private static Connection con;
    
    private DBManager(){};
    
    public static ComboPooledDataSource getDataSource() throws PropertyVetoException{
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
        
    public static Connection connect(){
        try {
            return con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
    public static Connection getConnection() throws SQLException{
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
            JDBCTutorialUtilities.printSQLException(ex);
        }
    }
    
    public static void main(String argv[]){
        Connection c = DBManager.connect();  
        test(c);
              
    }
    
    
}
