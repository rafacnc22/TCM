/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Relatar_DesperdicioDAO;
import DAO.Relatar_LigaçoesDAO;
import DAO.Relatar_ProblemaDAO;
import Main.Graficos;
import Main.Menu;
import Main.Tabelas;
import Model.Relatar_Desperdicio;
import Model.Relatar_Ligaçoes;
import Model.Relatar_Problema;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
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
public class GraficosController implements Initializable {
    @FXML private PieChart pieLigaçoes;
    @FXML private PieChart pieDesperdicio;
    @FXML private PieChart pieProblema;
    @FXML private Button btVoltar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Relatar_ProblemaDAO dao = new Relatar_ProblemaDAO();
        List<Relatar_Problema> problema = dao.getRelatar_Problema();
        for (int x = 0; x < problema.size(); x++) {
            pieProblema.getData().addAll(new PieChart.Data(problema.get(x).getOnde_ocorreu() + "(" + x + ")", x));
        }
        Relatar_DesperdicioDAO dao2 = new Relatar_DesperdicioDAO();
        ObservableList<Relatar_Desperdicio> problema2 = dao2.getRelatar_Desperdicio();
        for (int x = 0; x < problema2.size(); x++) {
            pieDesperdicio.getData().addAll(new PieChart.Data(problema.get(x).getOnde_ocorreu() + "(" + x + ")", x));
        }
        Relatar_LigaçoesDAO dao3 = new Relatar_LigaçoesDAO();
        List<Relatar_Ligaçoes> problema3 = dao3.getRelatar_Ligaçoes();
        for (int x = 0; x < problema3.size(); x++) {
            pieLigaçoes.getData().addAll(new PieChart.Data(problema.get(x).getOnde_ocorreu() + "(" + x + ")", x));
        }
        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            Voltar();
        });
        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                Voltar();
            }
        });
    }
    public void Voltar() {
        Menu tela = new Menu();
        try {
            tela.start(new Stage());
            Graficos.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
