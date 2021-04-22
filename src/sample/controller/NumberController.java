package sample.controller;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sample.model.StageChanger;

public class NumberController {

    public void selectedDigit(MouseEvent mouseEvent) {

        Button b = (Button) mouseEvent.getSource();
        int num = Integer.parseInt(b.getText());
        StageChanger.closeNumbers(num);
    }
}
