package sample.model;

import com.sun.istack.internal.Nullable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageChanger {
    private static Stage primaryStage;


    public StageChanger(Stage primaryStage){
        StageChanger.primaryStage = primaryStage;
    }

    public static void loadStage( String path,@Nullable String title) throws IOException {
        Parent root = FXMLLoader.load(StageChanger.class.getResource("../"+path));

        if(title!=null){
            primaryStage.setTitle(title);
        }
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
