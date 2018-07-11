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
public class Turma extends IData{
    String nome;
    Escola escola;
    String serie;
    int ano;

    @Override
    public void populate(ResultSet set) throws SQLException {
        nome = set.getString("Nome");
        serie = set.getString("Serie");
        ano = set.getInt("Ano");
        escola.populate(set);
        
    }
    
}
