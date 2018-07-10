/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openreport.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Gabriel Aureo
 */
public class Aluno extends IData {
    public String cpf;
    public String nome;
    public String nascimento;
    public String matricula;
    
    @Override
    public void populate(ResultSet set) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        cpf = set.getString("CPF");
        nome = set.getString("Nome");
        nascimento = dateFormat.format(set.getDate("Nascimento"));
        
        matricula = set.getString("Matricula");
    }
    
}