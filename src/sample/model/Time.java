package sample.model;

import javafx.application.Platform;
import sample.controller.GameController;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
    private final Timer timer = new Timer();
    private int seconds=0;
    GameController gameController;
    private boolean timerStarted = false;

    public Time(GameController gameController){
        this.gameController = gameController;
    }


    public void timerStart(){

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    seconds++;
                    gameController.setTimer(seconds);
            });
        }},1000,1000);

    }

    public boolean isTimerStarted() {
        return timerStarted;
    }

    public void setTimerStarted(boolean timerStarted) {
        this.timerStarted = timerStarted;
    }
}
