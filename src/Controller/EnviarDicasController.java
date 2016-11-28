/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DicaDAO;
import Model.Dicas;
import Main.EnviarDicas;
import Main.MDicas;

import java.net.URL;
import Main.TelaCadastrar;
import Model.Usuario;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Stitch
 */
public class EnviarDicasController implements Initializable {

   @FXML
    private Button btMandarDica;

    @FXML
    private Button idVoltar;

    @FXML
    private TextArea txDica;

    @FXML
    private TextField txEmail;

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
        btMandarDica.setOnMouseClicked((MouseEvent e) -> {
            CadastrarDica();
        });
        btMandarDica.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastrarDica();
            }
        });
        btCancelar.setOnMouseClicked((MouseEvent e) -> {
            CancelarCadastroUsuario();
        });
        btCancelar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CancelarCadastroUsuario();
            }
        });

    }

    public void VoltarParaMenu() {
        MDicas tela = new MDicas();
        try {
            tela.start(new Stage());
            EnviarDicas.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(EnviarDicasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void CancelarCadastroUsuario() {
        TelaCadastrar.getStage().close();
        Alerta(Alert.AlertType.ERROR, "Mandar Dica Cancelado", "Mandar Dica Cancelado");
    }

    public void Alerta(Alert.AlertType tipo, String title, String texto) {
        Alert a = new Alert(tipo);
        a.setTitle(title);
        a.setHeaderText(texto);
        a.show();
    }
     public void CadastrarDica() {
        DicaDAO dao = new DicaDAO();
        int cont = 0;
        
                Dicas d = new Dicas();
                d.setDica(txDica.getText());
                d.setEmail(txEmail.getText());
                dao.insereDicaDAO(d);
                
                Alerta(Alert.AlertType.INFORMATION, "Cadastro Concluido", "Cadastro Concluido");
        }
    }

