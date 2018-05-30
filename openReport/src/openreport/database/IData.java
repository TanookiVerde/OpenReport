/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openreport.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Aureo
 */
public abstract class IData {
    public IData(){
        
    }
    public abstract void populate(ResultSet set) throws SQLException;
}