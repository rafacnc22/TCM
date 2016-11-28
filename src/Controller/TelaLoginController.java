/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Main.Menu;
import Main.MenuAdmin;
import Main.SCVA;
import Main.TelaLogin;
import Model.Usuario;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
public class TelaLoginController implements Initializable {

    @FXML
    private Button btEntrar, idVoltar;

    @FXML
    private PasswordField txSenha;

    @FXML
    private TextField txEmail;

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
        btEntrar.setOnMouseClicked((MouseEvent e) -> {
            Entrar();
        });
        btEntrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Entrar();
            }
        });
    }

    public void VoltarParaPaginaInicial() {
        SCVA tela = new SCVA();
        try {
            tela.start(new Stage());
            TelaLogin.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(PaginaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Entrar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            int cont = 0;
            List<Usuario> log = FXCollections.observableArrayList(dao.getList());
            if (txEmail.getText() != null || txSenha.getText() != null) {

                for (int x = 0; x < log.size(); x++) {
                    if (txEmail.getText().equals(log.get(x).getEmail()) && txSenha.getText().equals(log.get(x).getSenha())) {
                        Menu tela1 = new Menu();
                        try {
                            tela1.start(new Stage());
                            Sair();
                        } catch (Exception ex) {
                            Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cont = 1;
                    }
                }
            } else {
                Alert errol = new Alert(Alert.AlertType.ERROR);
                errol.setHeaderText("Campos Vazios ");
                errol.setContentText("Preencha os campos");
                errol.showAndWait();
            }
            if (txEmail.getText().equals("admin") && txSenha.getText().equals("123")) {
                MenuAdmin tela = new MenuAdmin();
                try {
                    System.out.println("Login admin concluido");
                    tela.start(new Stage());
                    System.out.println("Login admin concluido");
                } catch (Exception ex) {
                    Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Erro login admin");
                }
                cont = 1;
            }
            if (cont != 1) {
                Alert errol = new Alert(Alert.AlertType.ERROR);
                errol.setHeaderText("Usuário ou senha informados estão incorretos");
                errol.setContentText("Tente novamente");
                errol.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Sair() {
        TelaLogin.getStage().close();
    }
}
