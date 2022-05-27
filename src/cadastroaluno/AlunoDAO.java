/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroaluno;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class AlunoDAO extends Conexao{
    
    public String cadastrarAluno(Aluno aluno)
    {
        try
        {
            String sentenca;
            sentenca = "INSERT INTO ALUNO VALUES (NULL,'"+
                    aluno.getNome()+"'.'" +aluno.getSexo()+
                    "','"+aluno.getEmail() +"')";
            return this.atualizarBanco(sentenca);
            
        }   
        catch(Exception e)
        {
            return e.getMessage();
        }
    }
    
    public String atualizarAluno(Aluno aluno)
    {
        try
        {
            String sentenca;
            sentenca = "UPDATE INTO ALUNO SET NOME '" + aluno.getNome()+
                    "',SEXO = '" +aluno.getSexo()+
                    "',EMAIL = '" +aluno.getEmail() + "WHERE MATRICULA = " +
                    aluno.getMatricula();
            return this.atualizarBanco(sentenca);
            
        }   
        catch(Exception e)
        {
            return e.getMessage();
        }
    }
    
    public String excluirAluno(String matricula)
    {
        try
        {
            String sentenca;
            sentenca = "DELETE FROM ALUNO WHERE MATRICULA = " + matricula;
            return this.atualizarBanco(sentenca);
            
        }   
        catch(Exception e)
        {
            return e.getMessage();
        }
    }
    
    public ArrayList listarAlunos()
    {
        try
        {
            ArrayList alunos = new ArrayList();
            String sentenca = "SELECT * FROM ALUNO ORDER BY NOME";
            ResultSet rs = this.getResultSet(sentenca);
            while(rs.next())
            {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getInt("MATRICULA"));
                aluno.setNome(rs.getString("NOME"));
                aluno.setSexo(rs.getString("SEXO"));
                aluno.setEmail(rs.getString("EMAIL"));
                alunos.add(aluno);
            }
            return alunos;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
            
    
    
}
