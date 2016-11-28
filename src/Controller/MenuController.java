/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MDicas;
import Main.Graficos;
import Main.Menu;
import Main.RelatarDesperdicio;
import Main.RelatarLigaçoes;
import Main.RelatarProblema;
import Main.SCVA;
import Main.Tabelas;
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
 * @author Rafael
 */
public class MenuController implements Initializable {

    @FXML
    private Button idSair;
    @FXML
    private Button idRelatarProblema;
    @FXML
    private Button idDicas;
    @FXML
    private Button idRelatarLigaçoes;
    @FXML
    private Button idRelatarDesperdicio;

    @FXML
    private Button btGraficos;
    @FXML
    private Button btTabelas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idSair.setOnMouseClicked((MouseEvent e) -> {
            Sair();
        });
        idSair.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Sair();
            }
        });
        idRelatarProblema.setOnMouseClicked((MouseEvent e) -> {
            RelatarProblema();
        });
        idRelatarProblema.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                RelatarProblema();
            }
        });
        idDicas.setOnMouseClicked((MouseEvent e) -> {
            Dicas();
        });
        idDicas.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Dicas();
            }
        });
        idRelatarLigaçoes.setOnMouseClicked((MouseEvent e) -> {
            RelatarLigaçoes();
        });
        idRelatarLigaçoes.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                RelatarLigaçoes();
            }
        });
        idRelatarDesperdicio.setOnMouseClicked((MouseEvent e) -> {
            RelatarDesperdicio();
        });
        idRelatarDesperdicio.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                RelatarDesperdicio();
            }
        });
        btTabelas.setOnMouseClicked((MouseEvent e) -> {
            Tabelas();
        });
        btTabelas.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Tabelas();
            }
        });
        btGraficos.setOnMouseClicked((MouseEvent e) -> {
            Graficos();
        });
        btGraficos.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Graficos();
            }
        });
    }

    public void Sair() {
        Menu.getStage().close();
    }

    public void RelatarProblema() {
        RelatarProblema tela = new RelatarProblema();
        try {
            tela.start(new Stage());
            Menu.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RelatarLigaçoes() {
        RelatarLigaçoes tela = new RelatarLigaçoes();
        try {
            tela.start(new Stage());
            Menu.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RelatarDesperdicio() {
        RelatarDesperdicio tela = new RelatarDesperdicio();
        try {
            tela.start(new Stage());
            Menu.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Dicas() {
        MDicas tela = new MDicas();
        try {
            tela.start(new Stage());
            Menu.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Tabelas() {
        Tabelas tela = new Tabelas();
        try {
            tela.start(new Stage());
            Menu.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Graficos() {
        Graficos tela = new Graficos();
        try {
            tela.start(new Stage());
            Menu.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
