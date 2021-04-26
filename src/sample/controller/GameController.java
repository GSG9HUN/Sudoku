package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import sample.model.Game;
import sample.model.StageChanger;
import sample.model.Time;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;


public class GameController {


    @FXML
    private Label timer;
    private static Game game;
    @FXML
    private ArrayList<ArrayList<Label>> labels;
    Label pressedLabel;
    private Time time;




    @FXML
    public  void initialize() {
            game = new Game();
            setGui();
            time = new Time(this);
            StageChanger.setGameController(this);

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

    public void insertNumber(String num){

        int row = getPressedLabelRow();
        int col = getPressedLabelCol();
        int number = Integer.parseInt(num);

        if (game.isSafe(row, col, number, game.getTable())) {
            pressedLabel.setTextFill(Color.GREEN);
            game.insertNumberInTable(row,col, number);
        } else {
            pressedLabel.setTextFill(Color.RED);
            game.insertNumberInTable(row,col, 0);
        }

        pressedLabel.setText(num);
        pressedLabel = null;
    }

    private int getPressedLabelRow() {
        return (int) pressedLabel.getProperties().get("gridpane-row")-1;
    }

    private int getPressedLabelCol() {
        return (int) pressedLabel.getProperties().get("gridpane-column")-1;
    }


    public void clickedLabel(MouseEvent mouseEvent) throws IOException {
        if(!time.isTimerStarted()){
            time.timerStart();
            time.setTimerStarted(true);
        }
        pressedLabel = (Label) mouseEvent.getSource();
        StageChanger.openNumbers("view/Numbers.fxml","Numbers");

    }

   public void solveYourself(MouseEvent mouseEvent) throws IOException {
        StageChanger.loadSolveStage();

    }

    public void solve(String result) {
        switch (result){
            case "aktualis":
                if(game.solve(0,0,game.getTable())) {
                    insertNumbers("aktualis");
                }else{
                    System.out.println("No solution!");
                }
                break;
            case "kezdeti":
                if(game.solve(0,0,game.getNotModifiedTable())){
                    insertNumbers("kezdeti");
                    System.out.println("Have solution!");
                }else{
                    System.out.println("No solution!");
                }
                break;
        }
    }


    public void ready(MouseEvent mouseEvent) {
        if(game.checkIfBoardIsFullyAndCorrect()){
        }else {
            System.out.println("A tábla nem teljes vagy hibás;");
        }
    }


    private void insertNumbers(String string){
        for(int i=0;i<labels.size();i++){
            for(int j=0;j<labels.get(i).size();j++){
                if("aktualis".equals(string)){
                    System.out.println(labels.get(i).get(j).getTextFill());
                    if(!(labels.get(i).get(j).getTextFill() ==Color.BLACK)){
                        labels.get(i).get(j).setTextFill(Color.BLUE);
                    }
                    labels.get(i).get(j).setText(String.valueOf(game.getTable()[i][j]));
                }else {
                    if(!(labels.get(i).get(j).getTextFill() ==Color.BLACK)){
                        labels.get(i).get(j).setTextFill(Color.BLUE);
                    }
                    labels.get(i).get(j).setText(String.valueOf(game.getNotModifiedTable()[i][j]));
                }
            }
        }
    }


    public void setTimer(int time){
        timer.setText(time+" s.");

    }


}
