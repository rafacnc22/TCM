/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.Fabrica_de_Conexao;
import Model.Dicas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Rafael
 */
public class DicaDAO {
     private Connection conexao;

    public DicaDAO() {
        this.conexao =  Fabrica_de_Conexao.getConnection();
    }

    public void insereDicaDAO(Dicas d) {
        try {
            String sql = "INSERT INTO dicas (email, dica) values(?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, d.getEmail());
            stmt.setString(2, d.getDica());
            stmt.execute();
            stmt.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Erro dao dicas");
            ex.printStackTrace();
            Logger.getLogger(DicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public void Deleta_Dicas(Dicas Func){
        String sql = "DELETE FROM diacas WHERE id=?";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, Func.getId());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public ObservableList<Dicas> getDica() {
         try{
            ObservableList<Dicas> Func = FXCollections.observableArrayList();
            PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM dicas");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Dicas f = new Dicas();
                f.setEmail(rs.getString("email"));
                f.setId(rs.getInt("id"));
                f.setDica(rs.getString("dica"));  
                Func.add(f);
            }
            stmt.executeQuery();
            rs.close();
            stmt.close();
            conexao.close();
            return Func;
            
        }catch(SQLException e){
                throw new RuntimeException(e);  
        }
    }
}
