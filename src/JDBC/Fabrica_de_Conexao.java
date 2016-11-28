/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class Fabrica_de_Conexao {

    public static Connection getConnection() {
        String usuario = "postgres";
        String senha = "denis987";
        String nomebanco = "S.C.V.A.";
        String endereço = "localhost";
        try {
            return DriverManager.getConnection("jdbc:postgresql://" + endereço + "/" + nomebanco, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro, Conexão falhou");
            throw new RuntimeException(e);
        }
    }
}
