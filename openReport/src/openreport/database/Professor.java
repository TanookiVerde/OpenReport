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
 * @author Matheus Vinicius
 */
public class Professor extends IData{
    public String cpf;
    public String nome;
    public String nascimento;

    @Override
    public void populate(ResultSet set) throws SQLException {
        cpf = set.getString("Nome");
        nome = set.getString("CPF");
        nascimento = set.getString("Nascimento");
    }
    
    public String toString(){
        return nome + " , " + cpf + " , " + nascimento + "\n";
    }
    
}
