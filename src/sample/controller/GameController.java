package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import sample.model.Game;
import sample.model.StageChanger;

import java.io.IOException;


public class GameController {

    @FXML
    Label   L11,L12,L13,L14,L15,L16,L17,L18,L19,
            L21,L22,L23,L24,L25,L26,L27,L28,L29,
            L31,L32,L33,L34,L35,L36,L37,L38,L39,
            L41,L42,L43,L44,L45,L46,L47,L48,L49,
            L51,L52,L53,L54,L55,L56,L57,L58,L59,
            L61,L62,L63,L64,L65,L66,L67,L68,L69,
            L71,L72,L73,L74,L75,L76,L77,L78,L79,
            L81,L82,L83,L84,L85,L86,L87,L88,L89,
            L91,L92,L93,L94,L95,L96,L97,L98,L99;


    public void clickedLabel(MouseEvent mouseEvent) throws IOException {

        System.out.println(mouseEvent.getTarget());
        L11.setMouseTransparent(false);
        L11.setDisable(true);
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
