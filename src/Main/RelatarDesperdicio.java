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
import static javafx.application.Application.launch;

/**
 *
 * @author Rafael
 */
public class RelatarDesperdicio extends Application {
    private static Stage fechar;
    @Override
    public void start(Stage stage)throws Exception  {
        Parent root = FXMLLoader.load(getClass().getResource("/View/RelatarDesperdicio.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Relatar Desperdicio");
        stage.setScene(scene);
        stage.show();
        RelatarDesperdicio.fechar = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static Stage getStage() {
        return RelatarDesperdicio.fechar;
    }

    public void setStage(Stage s) {
        RelatarDesperdicio.fechar = s;
    }
}
