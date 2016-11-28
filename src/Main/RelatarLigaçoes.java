/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Rafael
 */
public class RelatarLigaçoes extends Application {
    private static Stage fechar;
    @Override
    public void start(Stage stage)throws Exception  {
        Parent root = FXMLLoader.load(getClass().getResource("/View/RelatarLigaçoes.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Relatar Ligações Clandestinas");
        stage.setScene(scene);
        stage.show();
        RelatarLigaçoes.fechar = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static Stage getStage() {
        return RelatarLigaçoes.fechar;
    }

    public void setStage(Stage s) {
        RelatarLigaçoes.fechar = s;
    }
}
