/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.SCVA;
import Main.TelaCadastrar;
import Main.TelaLogin;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Rafael
 */
public class PaginaInicialController implements Initializable {

    @FXML
    private Button idCadastrar;
    @FXML
    private Button idLogin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCadastrar.setOnMouseClicked((MouseEvent e) -> {
            irParaTelaCadastro();
        });
        idCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                irParaTelaCadastro();
            }
        });
        idLogin.setOnMouseClicked((MouseEvent e) -> {
            irParaTelaLogin();
        });
        idLogin.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                irParaTelaLogin();
            }
        });
    }

    public void irParaTelaCadastro() {
        TelaCadastrar tela = new TelaCadastrar();
        try {
            tela.start(new Stage());
            SCVA.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(PaginaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void irParaTelaLogin() {
        TelaLogin tela = new TelaLogin();
        try {
            tela.start(new Stage());
            SCVA.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(PaginaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
