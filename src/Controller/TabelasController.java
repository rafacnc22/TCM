/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DicaDAO;
import DAO.Relatar_DesperdicioDAO;
import DAO.Relatar_LigaçoesDAO;
import DAO.Relatar_ProblemaDAO;
import Main.Menu;
import Main.Tabelas;
import Model.Dicas;
import Model.Relatar_Desperdicio;
import Model.Relatar_Ligaçoes;
import Model.Relatar_Problema;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rafael
 */
public class TabelasController implements Initializable {

    @FXML private Button btVoltar;

    @FXML
    private ObservableList<Dicas> Dicas_OBList;
    @FXML
    private static Dicas Dicas_Selecionado;
    @FXML
    private ObservableList<Relatar_Problema> Problema_OBList;
    @FXML
    private static Relatar_Problema Problema_Selecionado;
    @FXML
    private ObservableList<Relatar_Ligaçoes> Ligacoes_OBList;
    @FXML
    private static Relatar_Ligaçoes Ligaçoes_Selecionado;
    @FXML
    private ObservableList<Relatar_Desperdicio> Desperdicio_OBList;
    @FXML
    private static Relatar_Desperdicio Desperdicio_Selecionado;

    @FXML
    TableView<Relatar_Desperdicio> Tabela_Desperdicio;
    @FXML
    TableColumn<Relatar_Desperdicio, String> Desperdicio_lugar;
    @FXML
    TableColumn<Relatar_Desperdicio, String> Desperdcio_descriçao;
    @FXML
    TableColumn<Relatar_Desperdicio, Integer> Desperdicio_id;
    @FXML
    TableColumn<Relatar_Desperdicio, String> Desperdicio_data;

    @FXML
    TableView<Relatar_Ligaçoes> Tabela_Ligaçoes;
    @FXML
    TableColumn<Relatar_Ligaçoes, String> Ligaçoes_lugar;
    @FXML
    TableColumn<Relatar_Ligaçoes, String> Ligaçoes_descriçao;
    @FXML
    TableColumn<Relatar_Ligaçoes, Integer> Ligaçoes_id;
    @FXML
    TableColumn<Relatar_Ligaçoes, String> Ligaçoes_data;

    @FXML
    TableView<Relatar_Problema> Tabela_Problema;
    @FXML
    TableColumn<Relatar_Problema, String> Problema_lugar;
    @FXML
    TableColumn<Relatar_Problema, String> Problema_descriçao;
    @FXML
    TableColumn<Relatar_Problema, Integer> Problema_id;
    @FXML
    TableColumn<Relatar_Problema, String> Problema_data;

    @FXML
    TableView<Dicas> Tabela_Dica;
    @FXML
    TableColumn<Dicas, String> Dica_email;
    @FXML
    TableColumn<Dicas, String> Dica_dica;
    @FXML
    TableColumn<Dicas, Integer> Dica_id;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preencher_Tabela_Desperdicio();
        Preencher_Tabela_Ligaçoes();
        Preencher_Tabela_Problema();
        Preencher_Tabela_Dica();
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            Voltar();
        });
        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Voltar();
            }
        });
        Tabela_Desperdicio.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TabelasController.Desperdicio_Selecionado = (Relatar_Desperdicio) newValue;
                } else {
                    TabelasController.Desperdicio_Selecionado = null;
                }
            }
        });
        Tabela_Ligaçoes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TabelasController.Ligaçoes_Selecionado = (Relatar_Ligaçoes) newValue;
                } else {
                    TabelasController.Ligaçoes_Selecionado = null;
                }
            }
        });
        Tabela_Problema.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TabelasController.Problema_Selecionado = (Relatar_Problema) newValue;
                } else {
                    TabelasController.Problema_Selecionado = null;
                }
            }
        });
        Tabela_Dica.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TabelasController.Dicas_Selecionado = (Dicas) newValue;
                } else {
                    TabelasController.Dicas_Selecionado = null;
                }
            }
        });
    }

    public void Preencher_Tabela_Desperdicio() {
        Desperdicio_lugar.setCellValueFactory(new PropertyValueFactory("onde_ocorreu"));
        Desperdcio_descriçao.setCellValueFactory(new PropertyValueFactory("como_ocorreu"));
        Desperdicio_id.setCellValueFactory(new PropertyValueFactory("id"));
        Desperdicio_data.setCellValueFactory(new PropertyValueFactory("data_que_ocorreu"));

        Relatar_DesperdicioDAO DAO = new Relatar_DesperdicioDAO();
        Desperdicio_OBList = DAO.getRelatar_Desperdicio();
        Tabela_Desperdicio.setItems(Desperdicio_OBList);
    }

    public void Preencher_Tabela_Ligaçoes() {
        Ligaçoes_lugar.setCellValueFactory(new PropertyValueFactory("onde_ocorreu"));
        Ligaçoes_descriçao.setCellValueFactory(new PropertyValueFactory("como_ocorreu"));
        Ligaçoes_id.setCellValueFactory(new PropertyValueFactory("id"));
        Ligaçoes_data.setCellValueFactory(new PropertyValueFactory("data_que_ocorreu"));

        Relatar_LigaçoesDAO DAO = new Relatar_LigaçoesDAO();
        Ligacoes_OBList = DAO.getRelatar_Ligaçoes();
        Tabela_Ligaçoes.setItems(Ligacoes_OBList);
    }

    public void Preencher_Tabela_Problema() {
        Problema_lugar.setCellValueFactory(new PropertyValueFactory("onde_ocorreu"));
        Problema_descriçao.setCellValueFactory(new PropertyValueFactory("como_ocorreu"));
        Problema_id.setCellValueFactory(new PropertyValueFactory("id"));
        Problema_data.setCellValueFactory(new PropertyValueFactory("data_que_ocorreu"));

        Relatar_ProblemaDAO DAO = new Relatar_ProblemaDAO();
        Problema_OBList = DAO.getRelatar_Problema();
        Tabela_Problema.setItems(Problema_OBList);
    }

    public void Preencher_Tabela_Dica() {
        try {
            Dica_email.setCellValueFactory(new PropertyValueFactory("email"));
            Dica_dica.setCellValueFactory(new PropertyValueFactory("dica"));
            Dica_id.setCellValueFactory(new PropertyValueFactory("id"));
            DicaDAO DAO = new DicaDAO();
            Dicas_OBList = DAO.getDica();
            Tabela_Dica.setItems(Dicas_OBList);
        } catch (Exception e) {
            System.out.println("ERro preencher tabela");
        }
    }

    public void Voltar() {
        Menu tela = new Menu();
        try {
            tela.start(new Stage());
            Tabelas.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
