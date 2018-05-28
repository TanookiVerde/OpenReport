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
public class Aluno extends IData {
    String cpf;
    String nome;

    @Override
    public void populate(ResultSet set) throws SQLException {
        cpf = set.getString("Nome");
        nome = set.getString("CPF");
    }
    
    public String toString(){
        return nome + " , " + cpf + "\n";
    }
    
}
