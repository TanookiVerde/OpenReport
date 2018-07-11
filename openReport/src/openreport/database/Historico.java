/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openreport.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Aureo
 */
public class Historico extends IData {
    public Aluno aluno;
    
    public class Nota{
        public String serie;
        public String disciplina;
        public float frequencia;
        public float media;
    }
    
    public ArrayList<Nota> notas;

    @Override
    public void populate(ResultSet set) throws SQLException {
        aluno = new Aluno();
        notas = new ArrayList<Nota>();
        aluno.populate(set);
        do{
            Nota nota = new Nota();
            
            nota.serie = set.getString("Serie");
            nota.disciplina = set.getString("Disciplina");
            nota.media = set.getFloat("Media");
            nota.frequencia = set.getFloat("Frequencia");
            
            notas.add(nota);
        }while(set.next());
    }
       
}
