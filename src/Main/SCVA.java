/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rafael
 */
public class SCVA extends Application {
    private static Stage fechar;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/PaginaInicial.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("S.C.V.A. Sistema Contra Vazamento de Água");
        stage.setScene(scene);
        stage.show();
        SCVA.fechar = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static Stage getStage() {
        return SCVA.fechar;
    }

    public void setStage(Stage s) {
        SCVA.fechar = s;
    }
}
