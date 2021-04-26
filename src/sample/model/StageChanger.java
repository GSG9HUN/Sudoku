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
    private static final Stage solveStage = new Stage();
    private static boolean secondStageLoaded=false,solveStageLoaded=false;
    private static GameController gameController;

    public static void setGameController(GameController gameController) {
        StageChanger.gameController = gameController;
    }

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
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void loadSolveStage() throws IOException {
        if(!solveStageLoaded){
            Parent root = FXMLLoader.load(StageChanger.class.getResource("../view/solve.fxml"));
            solveStage.setResizable(false);
            solveStage.setScene(new Scene(root));
            solveStageLoaded=true;
        }
        solveStage.show();
    }

    public static void openNumbers(String path, String title) throws IOException {


        if(!secondStageLoaded){
            Parent root = FXMLLoader.load(StageChanger.class.getResource("../"+path));

            if(title!=null){
                secondStage.setTitle(title);
            }
            secondStage.setResizable(false);
            secondStage.setScene(new Scene(root));
            secondStageLoaded=true;
        }
        secondStage.show();

    }


    public static void closeNumbers(String number){
        gameController.insertNumber(number);
        secondStage.close();
    }

    public static void closeSolveStage() {
        solveStage.close();
    }

    public static void closeSolveStage(String result) {
        gameController.solve(result);
        solveStage.close();


    }
}
