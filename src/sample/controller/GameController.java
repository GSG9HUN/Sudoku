package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import sample.model.Game;
import sample.model.StageChanger;

import java.io.IOException;
import java.util.ArrayList;



public class GameController {



    public Label timer;

    private Game game;
    @FXML
    public ArrayList<ArrayList<Label>> labels;




    @FXML
    public  void initialize() {
        game = new Game();
        setGui();
    }

    private  void setGui() {

    labels.get(0).get(0).setDisable(true);

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                int num=game.getTableElement(i,j);
                if(num!=0){
                    labels.get(i).get(j).setText(Integer.toString(num));
                    labels.get(i).get(j).setDisable(true);
                }
            }
        }
    }


    public void clickedLabel(MouseEvent mouseEvent) throws IOException {

        StageChanger.openNumbers("view/Numbers.fxml","Numbers");

    }

    public void solveYourself(MouseEvent mouseEvent) {


    }

    public void ready(MouseEvent mouseEvent) {
    }

    public void selectedDigit(MouseEvent mouseEvent) {

        StageChanger.closeNumbers();
    }
}
