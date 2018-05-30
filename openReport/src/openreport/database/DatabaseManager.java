/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openreport.database;

import java.sql.*;
import com.mchange.v2.c3p0.*;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
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
    
    public static <T extends IData> ArrayList<T> callStatement(Class<T> dummy, String methodCall) {
        CallableStatement cst = null;
        Connection con = connect();
        ArrayList<T> array = new ArrayList<T>();
        try {
            cst = con.prepareCall(methodCall);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                T obj = dummy.newInstance();
                obj.populate(rs);
                array.add(obj);
            }           
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                cst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
        return array;
    }
        
    private static Connection connect(){
        try {
            return cpds.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
    public static void main(String argv[]){
        ArrayList<Aluno> array = new ArrayList<Aluno>();
        Aluno aluno = new Aluno();
        try {
            //Connection c = DatabaseManager.connect();
            //test(c);
            cpds = initializeDataSource();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        array = (ArrayList<Aluno>)callStatement(aluno.getClass(), "call ALUNODISC(\"Historia\")");
        System.out.print(array.toString());
    }
    
    
}