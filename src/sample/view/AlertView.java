package sample.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;

public class AlertView {
    public Alert winAlert;
    public Alert emptyFieldAlert;
    public Alert noCorrectAlert;
    public Alert solvedByComputer;

    public AlertView(){
        winAlert = new Alert(Alert.AlertType.INFORMATION);
        emptyFieldAlert=new Alert(Alert.AlertType.ERROR);
        noCorrectAlert=new Alert(Alert.AlertType.ERROR);
        solvedByComputer=new Alert(Alert.AlertType.WARNING);
        init();
    }

    private void init() {
        winAlert.setHeaderText("Congratulation!");
        winAlert.setContentText("You are won!\n You are now return to main menu.");

        emptyFieldAlert.setHeaderText("Error");
        emptyFieldAlert.setContentText("The sudoku have empty field.\nYou have to completely filled the board.");

        noCorrectAlert.setHeaderText("Error");
        noCorrectAlert.setContentText("The board is incorrectly completed.");

        solvedByComputer.setHeaderText("Am I joke to you?");
        solvedByComputer.setContentText("Did you think you would win like that?");
    }


}
