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
import DAO.UsuarioDAO;
import Main.MenuAdmin;
import Main.TabelasAdmin;
import Model.Dicas;
import Model.Relatar_Desperdicio;
import Model.Relatar_Ligaçoes;
import Model.Relatar_Problema;
import Model.Usuario;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
public class TabelasAdminController implements Initializable {
    
    @FXML private Button btExcluir,btAlterar,btVoltar,btPDFDicas,btPDFDesperdicio,btPDFLigaçoes,btPDFUsuario,btPDFProblema;

    @FXML private ObservableList<Relatar_Desperdicio> Desperdicio_OBList;
    @FXML private ObservableList<Relatar_Ligaçoes> Ligacoes_OBList;
    @FXML private ObservableList<Relatar_Problema> Problema_OBList;
    @FXML private ObservableList<Usuario> Usuario_OBList;
    @FXML private ObservableList<Dicas> Dicas_OBList;
 
    
    @FXML private static Dicas Dicas_Selecionado;
    @FXML private static Usuario Usuario_Selecionado;
    @FXML private static Relatar_Problema Problema_Selecionado;
    @FXML private static Relatar_Ligaçoes Ligaçoes_Selecionado;
    @FXML private static Relatar_Desperdicio Desperdicio_Selecionado;

    @FXML TableView<Relatar_Desperdicio> Tabela_Desperdicio;
    @FXML TableColumn<Relatar_Desperdicio, String> Desperdicio_lugar;
    @FXML TableColumn<Relatar_Desperdicio, String> Desperdcio_descriçao;
    @FXML TableColumn<Relatar_Desperdicio, Integer> Desperdicio_id;
    @FXML TableColumn<Relatar_Desperdicio, String> Desperdicio_data;

    @FXML TableView<Relatar_Ligaçoes> Tabela_Ligaçoes;
    @FXML TableColumn<Relatar_Ligaçoes, String> Ligaçoes_lugar;
    @FXML TableColumn<Relatar_Ligaçoes, String> Ligaçoes_descriçao;
    @FXML TableColumn<Relatar_Ligaçoes, Integer> Ligaçoes_id;
    @FXML TableColumn<Relatar_Ligaçoes, String> Ligaçoes_data;

    @FXML TableView<Relatar_Problema> Tabela_Problema;
    @FXML TableColumn<Relatar_Problema, String> Problema_lugar;
    @FXML TableColumn<Relatar_Problema, String> Problema_descriçao;
    @FXML TableColumn<Relatar_Problema, Integer> Problema_id;
    @FXML TableColumn<Relatar_Problema, String> Problema_data;

    @FXML TableView<Dicas> Tabela_Dica;
    @FXML TableColumn<Dicas, String> Dica_email;
    @FXML TableColumn<Dicas, String> Dica_dica;
    @FXML TableColumn<Dicas, Integer> Dica_id;  
    
    @FXML TableView<Usuario> Tabela_Usuario;
    @FXML TableColumn<Usuario, String> Coluna_Nome;
    @FXML TableColumn<Usuario, String> Coluna_Email;
    @FXML TableColumn<Usuario, Integer> Coluna_ID;
    @FXML TableColumn<Usuario, String> Coluna_Senha;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preencher_Tabela_Desperdicio();
        Preencher_Tabela_Ligaçoes();
        Preencher_Tabela_Problema();
        Preencher_Tabela_Dica();
        Preencher_Tabela_Usuario();
        btExcluir.setOnMouseClicked((MouseEvent e) -> {
            Excluir();
        });
        btExcluir.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Excluir();
            }
        });
        btAlterar.setOnMouseClicked((MouseEvent e) -> {
           
        });
        btAlterar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                
            }
        });
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            Voltar();
        });
        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Voltar();
            }
        });
        btPDFDicas.setOnMouseClicked((MouseEvent e) -> {
            try {
                PDFDicas();
            } catch (DocumentException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btPDFDicas.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    PDFDicas();
                } catch (DocumentException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btPDFDesperdicio.setOnMouseClicked((MouseEvent e) -> {
            try {
                PDFDesperdicio();
            } catch (DocumentException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btPDFDesperdicio.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    PDFDesperdicio();
                } catch (DocumentException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btPDFLigaçoes.setOnMouseClicked((MouseEvent e) -> {
            try {
                PDFLigaçoes();
            } catch (DocumentException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btPDFLigaçoes.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    PDFLigaçoes();
                } catch (DocumentException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btPDFUsuario.setOnMouseClicked((MouseEvent e) -> {
            try {
                PDFUsuario();
            } catch (DocumentException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btPDFUsuario.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    PDFUsuario();
                } catch (DocumentException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btPDFProblema.setOnMouseClicked((MouseEvent e) -> {
            try {
                PDFProblema();
            } catch (DocumentException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btPDFProblema.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    PDFProblema();
                } catch (DocumentException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TabelasAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Tabela_Desperdicio.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TabelasAdminController.Desperdicio_Selecionado = (Relatar_Desperdicio) newValue;
                } else {
                    TabelasAdminController.Desperdicio_Selecionado = null;
                }
            }
        });
        Tabela_Ligaçoes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TabelasAdminController.Ligaçoes_Selecionado = (Relatar_Ligaçoes) newValue;
                } else {
                    TabelasAdminController.Ligaçoes_Selecionado = null;
                }
            }
        });
        Tabela_Problema.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TabelasAdminController.Problema_Selecionado = (Relatar_Problema) newValue;
                } else {
                    TabelasAdminController.Problema_Selecionado = null;
                }
            }
        });
        Tabela_Dica.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TabelasAdminController.Dicas_Selecionado = (Dicas) newValue;
                } else {
                    TabelasAdminController.Dicas_Selecionado = null;
                }
            }
        });
        Tabela_Usuario.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    TabelasAdminController.Usuario_Selecionado = (Usuario) newValue;
                } else {
                    TabelasAdminController.Usuario_Selecionado = null;
                }
            }
        });
        
    }
    public ObservableList <Relatar_Desperdicio> Preencher_Tabela_Desperdicio2() {
        Relatar_DesperdicioDAO DAO5 = new Relatar_DesperdicioDAO();
        return  FXCollections.observableArrayList(DAO5.getRelatar_Desperdicio());
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
    public ObservableList <Relatar_Ligaçoes> Preencher_Tabela_Ligaçoes2() {
        Relatar_LigaçoesDAO DAO4 = new Relatar_LigaçoesDAO();
        return  FXCollections.observableArrayList(DAO4.getRelatar_Ligaçoes());
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
    public ObservableList <Relatar_Problema> Preencher_Tabela_Problema2() {
        Relatar_ProblemaDAO DAO3 = new Relatar_ProblemaDAO();
        return  FXCollections.observableArrayList(DAO3.getRelatar_Problema());
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

    public ObservableList <Dicas> Preencher_Tabela_Dica2() {
        DicaDAO DAO1 = new DicaDAO();
        return  FXCollections.observableArrayList(DAO1.getDica());
    }
    public void Preencher_Tabela_Dica(){
    Dica_email.setCellValueFactory(new PropertyValueFactory("email"));
        Dica_dica.setCellValueFactory(new PropertyValueFactory("dica"));
        Dica_id.setCellValueFactory(new PropertyValueFactory("id"));
        DicaDAO DAO = new DicaDAO();
        Dicas_OBList = DAO.getDica();
        Tabela_Dica.setItems(Dicas_OBList);
    }
    public ObservableList <Usuario> Preencher_Tabela_Usuario2() {
        UsuarioDAO DAO2 = new UsuarioDAO();
        return  FXCollections.observableArrayList(DAO2.getList());
    }
    public void Preencher_Tabela_Usuario() {      
        Coluna_Nome.setCellValueFactory(new PropertyValueFactory("nome"));
        Coluna_Senha.setCellValueFactory(new PropertyValueFactory("senha"));
        Coluna_Email.setCellValueFactory(new PropertyValueFactory("email"));
        Coluna_ID.setCellValueFactory(new PropertyValueFactory("id"));
        UsuarioDAO DAO = new UsuarioDAO();
        Usuario_OBList = DAO.getList();
        Tabela_Usuario.setItems(Usuario_OBList);
    }

    public void Excluir() {
        if (TabelasAdminController.Problema_Selecionado != null){
                Relatar_ProblemaDAO DAO = new Relatar_ProblemaDAO();
                DAO.Deleta_Problema(TabelasAdminController.Problema_Selecionado);
                Alert a=new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Problema deletado com sucesso!");
                a.showAndWait();
                Preencher_Tabela_Problema();
        }else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Por favor, selecione uma Problema!");
                a.showAndWait();
        }if(TabelasAdminController.Ligaçoes_Selecionado != null){
                Relatar_LigaçoesDAO DAO = new Relatar_LigaçoesDAO();
                DAO.Deleta_Ligaçoes(TabelasAdminController.Ligaçoes_Selecionado);
                Alert a=new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Ligaçoes Clandestinas deletada com sucesso!");
                a.showAndWait();
                Preencher_Tabela_Problema();
        }else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Por favor, selecione uma Ligação Clandestina!");
                a.showAndWait();
        }if(TabelasAdminController.Desperdicio_Selecionado != null){
                Relatar_DesperdicioDAO DAO = new Relatar_DesperdicioDAO();
                DAO.Deleta_Desperdicio(TabelasAdminController.Desperdicio_Selecionado);
                Alert a=new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Desperdicio deletado com sucesso!");
                a.showAndWait();
                Preencher_Tabela_Problema();
        }else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Por favor, selecione uma Desperdicio!");
                a.showAndWait();
        }if(TabelasAdminController.Dicas_Selecionado != null){
                DicaDAO DAO = new DicaDAO();
                DAO.Deleta_Dicas(TabelasAdminController.Dicas_Selecionado);
                Alert a=new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Dica deletada com sucesso!");
                a.showAndWait();
                Preencher_Tabela_Dica();
        }else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Por favor, selecione uma Dica!");
                a.showAndWait();
        }if(TabelasAdminController.Usuario_Selecionado != null){
                UsuarioDAO DAO = new UsuarioDAO();
                DAO.Deleta_Usuario(TabelasAdminController.Usuario_Selecionado);
                Alert a=new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Usuario deletada com sucesso!");
                a.showAndWait();
                Preencher_Tabela_Usuario();
        }else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Por favor, selecione um Usuario!");
                a.showAndWait();
        }
    }  
    
    public void Voltar() {
        MenuAdmin tela = new MenuAdmin();
        try {
            tela.start(new Stage());
            TabelasAdmin.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void PDFDicas() throws DocumentException, FileNotFoundException{
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Public\\PDFDicas.pdf"));
        doc.open();
        
        ObservableList <Dicas> dicas = Preencher_Tabela_Dica2();
        for(int x = 0; x< dicas.size();x++){
            doc.add(new Paragraph("----------------------------------------"));
            doc.add(new Paragraph("Id : " +dicas.get(x).getId()));
            doc.add(new Paragraph("Email : " +dicas.get(x).getEmail()));
            doc.add(new Paragraph("Dica : " +dicas.get(x).getDica()));
            doc.add(new Paragraph("----------------------------------------"));
        }
        doc.close();
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setHeaderText("PDF Dicas Gerado Com sucesso na pasta C:/Users/Public");
        a.show();
    }
    public void PDFDesperdicio () throws DocumentException, FileNotFoundException{
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Public\\PDFDesperdicio.pdf"));
        doc.open();
        
        ObservableList <Relatar_Desperdicio> desperdicio = Preencher_Tabela_Desperdicio2();
        for(int x = 0; x< desperdicio.size();x++){
            doc.add(new Paragraph("----------------------------------------"));
            doc.add(new Paragraph("Id : " +desperdicio.get(x).getId()));
            doc.add(new Paragraph("Local : " +desperdicio.get(x).getOnde_ocorreu()));
            doc.add(new Paragraph("Data : " +desperdicio.get(x).getData_que_ocorreu()));
            doc.add(new Paragraph("Como Ocorreu : " +desperdicio.get(x).getComo_ocorreu()));
            doc.add(new Paragraph("----------------------------------------"));
        }
        doc.close();
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setHeaderText("PDF Desperdicios Gerado Com sucesso na pasta C:/Users/Public");
        a.show();
    }
    public void PDFLigaçoes () throws DocumentException, FileNotFoundException{
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Public\\PDFLigaçoes.pdf"));
        doc.open();
        
        ObservableList <Relatar_Ligaçoes> ligaçoes = Preencher_Tabela_Ligaçoes2();
        for(int x = 0; x< ligaçoes.size();x++){
            doc.add(new Paragraph("----------------------------------------"));
            doc.add(new Paragraph("Id : " +ligaçoes.get(x).getId()));
            doc.add(new Paragraph("Local : " +ligaçoes.get(x).getOnde_ocorreu()));
            doc.add(new Paragraph("Data : " +ligaçoes.get(x).getData_que_ocorreu()));
            doc.add(new Paragraph("Como Ocorreu : " +ligaçoes.get(x).getComo_ocorreu()));
            doc.add(new Paragraph("----------------------------------------"));
        }
        doc.close();
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setHeaderText("PDF Ligaçoes Gerado Com sucesso na pasta C:/Users/Public");
        a.show();
    }
    public void PDFUsuario ()throws DocumentException, FileNotFoundException{
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Public\\PDFUsuario.pdf"));
        doc.open();
        
        ObservableList <Usuario> usuario = Preencher_Tabela_Usuario2();
        for(int x = 0; x< usuario.size();x++){
            doc.add(new Paragraph("----------------------------------------"));
            doc.add(new Paragraph("Id : " +usuario.get(x).getId()));
            doc.add(new Paragraph("Nome : " +usuario.get(x).getNome()));
            doc.add(new Paragraph("Email : " +usuario.get(x).getEmail()));
            doc.add(new Paragraph("Senha : " +usuario.get(x).getSenha()));
            doc.add(new Paragraph("----------------------------------------"));
        }
        doc.close();
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setHeaderText("PDF Usuario Gerado Com sucesso na pasta C:/Users/Public");
        a.show();
    }
    public void PDFProblema ()throws DocumentException, FileNotFoundException{
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Public\\PDFProblema.pdf"));
        doc.open();
        
        ObservableList <Relatar_Problema> problema = Preencher_Tabela_Problema2();
        for(int x = 0; x< problema.size();x++){
            doc.add(new Paragraph("----------------------------------------"));
            doc.add(new Paragraph("Id : " +problema.get(x).getId()));
            doc.add(new Paragraph("Local : " +problema.get(x).getOnde_ocorreu()));
            doc.add(new Paragraph("Data : " +problema.get(x).getData_que_ocorreu()));
            doc.add(new Paragraph("Como Ocorreu : " +problema.get(x).getComo_ocorreu()));
            doc.add(new Paragraph("Tipo : " +problema.get(x).getTipo()));
            doc.add(new Paragraph("----------------------------------------"));
        }
        doc.close();
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setHeaderText("PDF Problema Gerado Com sucesso na pasta C:/Users/Public");
        a.show();
    }
}
