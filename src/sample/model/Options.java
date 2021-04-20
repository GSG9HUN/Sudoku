package sample.model;

public class Options {

    private static String difficulty = new String("Easy");


    public static String getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(String difficulty) {
        Options.difficulty = difficulty;
    }
}
