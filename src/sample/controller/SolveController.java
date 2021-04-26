package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sample.model.StageChanger;

public class SolveController {
    @FXML
    Button kezdeti;
    @FXML
    Button aktualis;
    @FXML
    Button cancel;

    public void buttonClicked(MouseEvent mouseEvent) {
        Button b = (Button) mouseEvent.getSource();
        String text = b.getText();

        if(kezdeti.getText().equals(text)){
            StageChanger.closeSolveStage("kezdeti");
        }else if(aktualis.getText().equals(text)){
            StageChanger.closeSolveStage("aktualis");
        }else{
            StageChanger.closeSolveStage();
        }

    }
}
