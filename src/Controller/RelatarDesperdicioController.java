/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Relatar_DesperdicioDAO;
import Main.Menu;
import Main.RelatarDesperdicio;
import Model.Relatar_Desperdicio;
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
 * @author colegio
 */
public class RelatarDesperdicioController implements Initializable {

    @FXML
    private Button idVoltar;

    @FXML
    private Button btRelatar;

    @FXML
    private DatePicker DateDesperdicio;

    @FXML
    private TextArea txDescrevaDesperdicio;

    @FXML
    private TextField txOndeDesperdicio;

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
            CadastrarDesperdicio();
        });
        btRelatar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastrarDesperdicio();
            }
        });
    }

    public void VoltarParaMenu() {
        Menu tela = new Menu();
        try {
            tela.start(new Stage());
            RelatarDesperdicio.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(RelatarProblemaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Cancelar() {
        Alerta(Alert.AlertType.ERROR, "Relato Cancelado", "Relatar Desperdicio Cancelado");
        RelatarDesperdicio.getStage().close();
    }

    public void Alerta(Alert.AlertType tipo, String title, String texto) {
        Alert a = new Alert(tipo);
        a.setTitle(title);
        a.setHeaderText(texto);
        a.show();
    }

    public void CadastrarDesperdicio() {
        Relatar_Desperdicio p = new Relatar_Desperdicio();
        p.setComo_ocorreu(txDescrevaDesperdicio.getText());
        p.setOnde_ocorreu(txOndeDesperdicio.getText());
        p.setData_que_ocorreu(DateDesperdicio.getValue());
        Relatar_DesperdicioDAO dao = new Relatar_DesperdicioDAO();
        dao.insereRelatar_DesperdicioDAO(p);
        VoltarParaMenu();
        RelatarDesperdicio.getStage().close();
        Alerta(Alert.AlertType.INFORMATION, "Relato Concluido", "Relato Concluido");
    }
}
