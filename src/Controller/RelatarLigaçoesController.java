/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Relatar_DesperdicioDAO;
import DAO.Relatar_LigaçoesDAO;
import Main.Menu;
import Main.RelatarDesperdicio;
import Main.RelatarLigaçoes;
import Main.RelatarProblema;
import Main.TelaCadastrar;
import Model.Relatar_Desperdicio;
import Model.Relatar_Ligaçoes;
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
public class RelatarLigaçoesController implements Initializable {

    @FXML
    private TextArea txComoLigaçoes;

    @FXML
    private Button btRelatarLigaçoes;

    @FXML
    private DatePicker dateLigaçoes;

    @FXML
    private Button idVoltar;

    @FXML
    private TextField txOndeLigaçoes;

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
        btRelatarLigaçoes.setOnMouseClicked((MouseEvent e) -> {
            CadastrarLigaçoes();
        });
        btRelatarLigaçoes.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastrarLigaçoes();
            }
        });
    }

    public void VoltarParaMenu() {
        Menu tela = new Menu();
        try {
            tela.start(new Stage());
            RelatarLigaçoes.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(RelatarProblemaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Cancelar() {
        Alerta(Alert.AlertType.ERROR, "Relato Cancelado", "Relatar Desperdicio Cancelado");
        RelatarLigaçoes.getStage().close();
    }

    public void Alerta(Alert.AlertType tipo, String title, String texto) {
        Alert a = new Alert(tipo);
        a.setTitle(title);
        a.setHeaderText(texto);
        a.show();
    }

    public void CadastrarLigaçoes() {
        Relatar_Ligaçoes p = new Relatar_Ligaçoes();
        p.setComo_ocorreu(txComoLigaçoes.getText());
        p.setOnde_ocorreu(txOndeLigaçoes.getText());
        p.setData_que_ocorreu(dateLigaçoes.getValue());
        Relatar_LigaçoesDAO dao = new Relatar_LigaçoesDAO();
        dao.insereRelatar_LigaçoesDAO(p);
        VoltarParaMenu();
        RelatarLigaçoes.getStage().close();
        Alerta(Alert.AlertType.INFORMATION, "Relato Concluido", "Relato Concluido");
    }
}
