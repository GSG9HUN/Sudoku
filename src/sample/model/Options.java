package sample.model;

public class Options {
    private static String difficulties= "Easy";

    public static String getDifficulties() {
        return difficulties;
    }

    public static void setDifficulties(String difficulties) {
        Options.difficulties = difficulties;
    }
}
