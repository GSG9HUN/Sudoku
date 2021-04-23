package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import sample.model.Game;
import sample.model.StageChanger;

import java.io.IOException;
import java.util.ArrayList;



public class GameController {



    public Label timer;

    private static Game game;
    @FXML
    public ArrayList<ArrayList<Label>> labels;

    static Label pressedLabel;




    @FXML
    public  void initialize() {
            game = new Game();
            setGui();

    }

    private  void setGui() {
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                int num=game.getTableElement(i,j);
                if(num!=0){
                    labels.get(i).get(j).setText(Integer.toString(num));
                    labels.get(i).get(j).setDisable(true);
                }else{
                    labels.get(i).get(j).setTextFill(Color.BLUE);
                }
            }
        }
    }

    public static void insertNumber(String num){

        int row = getPressedLabelRow();
        int col = getPressedLabelCol();
        int number = Integer.parseInt(num);

        if (game.isSafe(row, col, number)) {
            pressedLabel.setTextFill(Color.GREEN);
            game.insertNumberInTable(row,col, number);
        } else {
            pressedLabel.setTextFill(Color.RED);
            game.insertNumberInTable(row,col, 0);
        }

        pressedLabel.setText(num);
        pressedLabel = null;
    }

    private static int getPressedLabelRow() {
        return (int) pressedLabel.getProperties().get("gridpane-row")-1;
    }

    private static int getPressedLabelCol() {
        return (int) pressedLabel.getProperties().get("gridpane-column")-1;

    }


    public void clickedLabel(MouseEvent mouseEvent) throws IOException {
        pressedLabel = (Label) mouseEvent.getSource();
        StageChanger.openNumbers("view/Numbers.fxml","Numbers");

    }

   public void solveYourself(MouseEvent mouseEvent) {

        game.printTable();
        if(game.solve(0,0))
        {
            game.printTable();
        }else{
            System.out.println("No solution!");
        }

    }

    public void ready(MouseEvent mouseEvent) {
        game.printTable();
    }


}
