package sample.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import sample.model.Options;
import sample.model.StageChanger;

import java.io.IOException;


public class OptionsController {

    @FXML
    public CheckBox Hard;
    @FXML
    public CheckBox Easy;
    @FXML
    public CheckBox Medium;
    @FXML
    public CheckBox Beginner;
    @FXML
    public CheckBox Ultimate;
    @FXML
    public CheckBox Expert;

    @FXML
    public void Back(MouseEvent mouseEvent) throws IOException {
        StageChanger.loadStage("view/sample.fxml");
    }

    @FXML
    public void Save(MouseEvent mouseEvent) throws IOException {

        if (Beginner.isSelected()) {
           Options.setDifficulties("Beginner");
        } else if (Easy.isSelected()) {
            Options.setDifficulties("Easy");
        } else if (Medium.isSelected()) {
            Options.setDifficulties("Medium");
        } else if (Hard.isSelected()) {
            Options.setDifficulties("Hard");
        } else if (Expert.isSelected()) {
            Options.setDifficulties("Expert");
        } else if (Ultimate.isSelected()) {
            Options.setDifficulties("Ultimate");

        }

        Back(mouseEvent);
    }





    public void onlyOneCanChecked(ActionEvent actionEvent) {

        if (Beginner.equals(actionEvent.getTarget())) {
            Medium.setSelected(false);
            Hard.setSelected(false);
            Easy.setSelected(false);
            Expert.setSelected(false);
            Ultimate.setSelected(false);
        } else if (Easy.equals(actionEvent.getTarget())) {
            Medium.setSelected(false);
            Hard.setSelected(false);
            Beginner.setSelected(false);
            Expert.setSelected(false);
            Ultimate.setSelected(false);
        } else if (Medium.equals(actionEvent.getTarget())) {
            Hard.setSelected(false);
            Easy.setSelected(false);
            Beginner.setSelected(false);
            Expert.setSelected(false);
            Ultimate.setSelected(false);
        } else if (Hard.equals(actionEvent.getTarget())) {
            Medium.setSelected(false);
            Easy.setSelected(false);
            Beginner.setSelected(false);
            Expert.setSelected(false);
            Ultimate.setSelected(false);
        }else if(Expert.equals(actionEvent.getTarget())){
            Medium.setSelected(false);
            Easy.setSelected(false);
            Beginner.setSelected(false);
            Ultimate.setSelected(false);
            Hard.setSelected(false);
        }else if(Ultimate.equals(actionEvent.getTarget())){
            Medium.setSelected(false);
            Easy.setSelected(false);
            Beginner.setSelected(false);
            Expert.setSelected(false);
            Hard.setSelected(false);
        }
    }
}
