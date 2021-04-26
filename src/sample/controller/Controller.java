package sample.controller;
import javafx.fxml.FXML;
import sample.model.StageChanger;

import java.io.IOException;

public class Controller {
    StageChanger stageChanger ;




    @FXML
    private void Start() throws IOException {
        StageChanger.loadStage("view/table.fxml");
    }



    @FXML
    private void Exit(){
        System.exit(0);
    }

    @FXML
    private void Options() throws IOException {
        StageChanger.loadStage("view/options.fxml");

    }
    public StageChanger getStageChanger() {
        return stageChanger;
    }

    public void setStageChanger(StageChanger stageChanger) {
        this.stageChanger = stageChanger;
    }
}