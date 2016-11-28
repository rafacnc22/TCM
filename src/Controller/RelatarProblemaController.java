/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Relatar_ProblemaDAO;
import Main.Menu;
import Main.RelatarProblema;
import Main.TelaCadastrar;
import Model.Relatar_Problema;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rafael
 */
public class RelatarProblemaController implements Initializable {

    @FXML
    private TextField txOcorreuProblema;

    @FXML
    private Button idVoltar;

    @FXML
    private Button btRelatar;

    @FXML
    private TextArea txComoProblema;

    @FXML
    private DatePicker DatePlorblema;

    @FXML
    private Button btCancelar;

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
        btCancelar.setOnMouseClicked((MouseEvent e) -> {
            Cancelar();
        });
        btCancelar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Cancelar();
            }
        });
        btRelatar.setOnMouseClicked((MouseEvent e) -> {
            CadastrarProblema();
        });
        btRelatar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastrarProblema();
            }
        });
    }

    public void VoltarParaMenu() {
        Menu tela = new Menu();
        try {
            tela.start(new Stage());
            RelatarProblema.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(RelatarProblemaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Cancelar() {
        Alerta(Alert.AlertType.ERROR, "Relato Cancelado", "Relatar Problema Cancelado");
        RelatarProblema.getStage().close();
    }

    public void Alerta(Alert.AlertType tipo, String title, String texto) {
        Alert a = new Alert(tipo);
        a.setTitle(title);
        a.setHeaderText(texto);
        a.show();
    }

    public void CadastrarProblema() {
        Relatar_Problema p = new Relatar_Problema();
        p.setComo_ocorreu(txComoProblema.getText());
        p.setOnde_ocorreu(txOcorreuProblema.getText());
        p.setData_que_ocorreu(DatePlorblema.getValue());
        Relatar_ProblemaDAO dao = new Relatar_ProblemaDAO();
        dao.insereRelatar_ProblemaDAO(p);
        VoltarParaMenu();
        RelatarProblema.getStage().close();
        Alerta(Alert.AlertType.INFORMATION, "Relato Concluido", "Relato Concluido");
    }
}
