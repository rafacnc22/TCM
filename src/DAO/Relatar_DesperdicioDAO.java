/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.Fabrica_de_Conexao;
import Model.Relatar_Desperdicio;
import java.sql.Connection;
import java.sql.Date;
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
public class Relatar_DesperdicioDAO {
    private Connection conexao;

    public Relatar_DesperdicioDAO() {
        this.conexao = new Fabrica_de_Conexao().getConnection();
    }

    public void insereRelatar_DesperdicioDAO(Relatar_Desperdicio u) {
        try {
            String sql = "INSERT INTO relatar_desperdicio (onde_ocorreu,data_que_ocorreu,como_ocorreu,email) values(?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, u.getOnde_ocorreu());
            stmt.setDate(2,Date.valueOf(u.getData_que_ocorreu()));
            stmt.setString(3, u.getComo_ocorreu());
            stmt.setString(4, u.getEmail());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ObservableList<Relatar_Desperdicio> getRelatar_Desperdicio()
    {  
        try{
            ObservableList<Relatar_Desperdicio> Func = FXCollections.observableArrayList();
            PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM relatar_desperdicio");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Relatar_Desperdicio f = new Relatar_Desperdicio();
                f.setOnde_ocorreu(rs.getString("onde_ocorreu"));
                f.setId(rs.getInt("id"));
                f.setComo_ocorreu(rs.getString("como_ocorreu"));
                Date data_que_ocorreu = rs.getDate("data_que_ocorreu");
                f.setEmail(rs.getString("email"));
                f.setData_que_ocorreu(data_que_ocorreu.toLocalDate()); 
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
     public void Deleta_Desperdicio(Relatar_Desperdicio Func){
        String sql = "DELETE FROM relatar_desperdicio WHERE id=?";
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, Func.getId());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}