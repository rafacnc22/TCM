/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Main.SCVA;
import Main.TelaCadastrar;
import Model.Usuario;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
public class TelaCadastrarController implements Initializable {

    @FXML
    private TextField txConfirmarEmail;

    @FXML
    private TextField txEmail;

    @FXML
    private Button idVoltar;
    @FXML
    private Button btCadastrar;
    @FXML
    private Button btCancelar;

    @FXML
    private PasswordField txSenha;

    @FXML
    private PasswordField txConfirmarSenha;

    @FXML
    private TextField txNome;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idVoltar.setOnMouseClicked((MouseEvent e) -> {
            VoltarParaPaginaInicial();
        });
        idVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                VoltarParaPaginaInicial();
            }
        });
        btCadastrar.setOnMouseClicked((MouseEvent e) -> {
            CadastrarUsuario();
        });
        btCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastrarUsuario();
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
        // TODO
    }

    public void VoltarParaPaginaInicial() {
        SCVA tela = new SCVA();
        try {
            tela.start(new Stage());
            TelaCadastrar.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastrarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CadastrarUsuario() {
        UsuarioDAO dao = new UsuarioDAO();
        int cont = 0;
        List<Usuario> log = FXCollections.observableArrayList(dao.getList());
        for (int x = 0; x < log.size(); x++) {
            if (txEmail.getText().equals(log.get(x).getEmail()) && txSenha.getText().equals(log.get(x).getSenha())) {
                Alerta(Alert.AlertType.INFORMATION, "Email e senha já existente", "Email e senha já existente");
            } else if (txConfirmarSenha.getText().equals(txSenha.getText()) && txConfirmarEmail.getText().equals(txEmail.getText())) {
                Usuario p = new Usuario();
                p.setNome(txNome.getText());
                p.setSenha(txSenha.getText());
                p.setEmail(txEmail.getText());
                dao.insereUsuarioDAO(p);
                VoltarParaPaginaInicial();
                TelaCadastrar.getStage().close();
                Alerta(Alert.AlertType.INFORMATION, "Cadastro Concluido", "Cadastro Concluido");
            } else {
                Alerta(Alert.AlertType.ERROR, "Cadastro cancelado", "Confirmar senha ou confirmar email estão incorretos");
            }
        }
    }

    public void CancelarCadastroUsuario() {
        TelaCadastrar.getStage().close();
        Alerta(Alert.AlertType.ERROR, "Cadastro Cancelado", "Cadastro Cancelado");
    }

    public void Alerta(Alert.AlertType tipo, String title, String texto) {
        Alert a = new Alert(tipo);
        a.setTitle(title);
        a.setHeaderText(texto);
        a.show();
    }
}
