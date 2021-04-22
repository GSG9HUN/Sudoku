package sample.model;

import java.util.Random;

public class Game {

    int[][] table = new int[9][9];
    int clues;
    public Game(){
       init();
       createBoard();
       solve();
    }


    private void createBoard() {
        int cluesOnBoard=0;
        Random rand = new Random();

        while (cluesOnBoard!=clues){
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            int num = rand.nextInt(9)+1;
            if(isSafe(row,col,num)){
                table[row][col]=num;
                cluesOnBoard++;
            }
            }

        }



    private void init() {

        for(int i = 0; i<9; i++){
            for (int j=0; j<9;j++) {
                table[i][j]=0;
            }
        }

        switch (Options.getDifficulties()){
            case "Beginner": clues=40;
                break;
            case "Easy":clues=35;
                break;
            case "Medium": clues=30;
                break;
            case "Hard":clues=25;
                break;
            case "Expert":clues=20;
                break;
            case "Ultimate":clues=17;
            break;
        }
    }

    private void solve() {
    }

    private boolean isSafe(int row, int col, int num) {

        for(int i=0;i<9;i++){
            if(table[row][i]==num){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(table[i][col]==num){
                return false;
            }
        }

        int startRow =row-row%3 ;
        int startCol=col-col%3;
    for (int i=0;i<3;i++){
        for (int j=0;j<3;j++){
            if(table[i+startRow][j+startCol]==num) {
                return false;
            }
        }
    }

        return true;
    }

    public int getTableElement(int row, int col) {
        return table[row][col];
    }

}
