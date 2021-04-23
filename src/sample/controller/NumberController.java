package sample.controller;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sample.model.StageChanger;

public class NumberController {


    public void selectedDigit(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String number= button.getText();
        StageChanger.closeNumbers(number);
    }



}
