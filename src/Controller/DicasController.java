/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MDicas;
import Main.EnviarDicas;
import Main.Menu;
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
 * FXML Controller class
 *
 * @author Stitch
 */
public class DicasController implements Initializable {

    @FXML
    private Button idVoltar;
    @FXML
    private Button idPostarD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        idVoltar.setOnMouseClicked((MouseEvent e) -> {
            VoltarParaMenu();
        });
        idVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                VoltarParaMenu();
            }
        });
        idPostarD.setOnMouseClicked((MouseEvent e) -> {
            EnviarDicas();
        });
        idPostarD.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                EnviarDicas();
            }
        });
        

    }

    public void VoltarParaMenu() {
        Menu tela = new Menu();
        try {
            tela.start(new Stage());
            MDicas.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(DicasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EnviarDicas() {
        EnviarDicas tela = new EnviarDicas();
        try {
            tela.start(new Stage());
            MDicas.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(DicasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
