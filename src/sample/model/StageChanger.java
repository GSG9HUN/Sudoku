package sample.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.GameController;

import java.io.IOException;

public class StageChanger {
    private static Stage primaryStage;
    private static final Stage secondStage = new Stage();
    private static boolean loaded = false;


    public StageChanger(Stage primaryStage){
        StageChanger.primaryStage = primaryStage;
    }


    public static void loadStage(String path) throws IOException {
        loadStage(path,null);
    }

    public static void loadStage( String path, String title) throws IOException {
        Parent root = FXMLLoader.load(StageChanger.class.getResource("../"+path));

        if(title!=null){
            primaryStage.setTitle(title);
        }
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void openNumbers(String path,String title) throws IOException {

        if(!loaded){
            Parent root = FXMLLoader.load(StageChanger.class.getResource("../"+path));

            if(title!=null){
                secondStage.setTitle(title);
            }
            secondStage.setResizable(false);
            secondStage.setScene(new Scene(root));
            loaded=true;
        }
        secondStage.show();

    }


    public static void closeNumbers(String number){
        GameController.insertNumber(number);
        secondStage.close();
    }
}
