/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.Fabrica_de_Conexao;
import Model.Usuario;
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
public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = new Fabrica_de_Conexao().getConnection();
    }

    public void insereUsuarioDAO(Usuario u) {
        try {
            String sql = "INSERT INTO usuario (nome,email,senha) values(?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Deleta_Usuario(Usuario Func){
        String sql = "DELETE FROM usuario WHERE id=?";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, Func.getId());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public ObservableList<Usuario> getList() {
        ObservableList<Usuario> usuario = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM usuario";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                usuario.add(u);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
}
