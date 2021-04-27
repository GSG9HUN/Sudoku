package sample.model;

import java.util.*;

public class Game {


    int[][] table = new int[9][9];
    int[][] notModifiedTable= new int[9][9];
    int clues;
    boolean solvedByComputer = false;
    ArrayList<Integer> numbers = new ArrayList<>();


    public Game() {
        init();
        createBoard();
        deleteFields();
        copy();

    }
    private void copy() {
        for (int i=0;i<9;i++){
            System.arraycopy(table[i],0,notModifiedTable[i],0,9);
        }
    }
    private void deleteFields() {
        int deletedFields = 0;
        Random rand = new Random();
        while (deletedFields != 81-clues) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (table[row][col] != 0) {
                table[row][col] = 0;
                deletedFields++;
            }
        }

    }
    private void createBoard() {
        generate(0,0);
        pickTwoRandomRows();
        pickTwoRandomCols();
        pickTwoRandomGroupsRowSide();
        pickTwoRandomGroupsColSide();

    }
    public void insertNumberInTable(int row, int col, int num) {
        table[row][col] = num;
    }

    private void pickTwoRandomGroupsRowSide() {
        Random rand = new Random();
        int startGroup = 0;
        int endGroup = 3;
        int group1 = rand.nextInt(endGroup - startGroup) + startGroup;
        int group2;
        do {
            group2 = rand.nextInt(endGroup - startGroup) + startGroup;
        } while (group1 == group2);

        changeGroupsByRow(group1,group2);

    }
    private void changeGroupsByRow(int group1, int group2) {
    int startRowGroup1 = group1*3;
    int startRowGroup2 = group2*3;
    int tempNumber;
    for(int i=0; i<3;i++){
        for(int j =0;j<9;j++){
            tempNumber=table[startRowGroup1][j];
            table[startRowGroup1][j]=table[startRowGroup2][j];
            table[startRowGroup2][j]=tempNumber;
        }
        startRowGroup1++;
        startRowGroup2++;
    }
    }
    private void pickTwoRandomGroupsColSide() {
        Random rand = new Random();
        int startGroup = 0;
        int endGroup = 3;
        int group1 = rand.nextInt(endGroup - startGroup) + startGroup;
        int group2;
        do {
            group2 = rand.nextInt(endGroup - startGroup) + startGroup;
        } while (group1 == group2);

        changeGroupsByCol(group1,group2);

    }
    private void changeGroupsByCol(int group1, int group2) {
        int startColGroup1 = group1*3;
        int startColGroup2 = group2*3;
        int tempNumber;
        for(int i=0; i<3;i++){
            for(int j =0;j<9;j++){
                tempNumber=table[startColGroup1][j];
                table[startColGroup1][j]=table[startColGroup2][j];
                table[startColGroup2][j]=tempNumber;
            }
            startColGroup1++;
            startColGroup2++;
        }
    }
    private void pickTwoRandomRows() {
        Random random = new Random();
        int startRows = 0;
        int endRows = 2;
        for (int i = 0; i < 3; i++) {
            int row1 = random.nextInt(endRows - startRows + 1) + startRows;
            int row2;
            do {
                row2 = random.nextInt(endRows - startRows + 1) + startRows;
            } while (row1 == row2);
            startRows += 3;
            endRows += 3;
            changeRows(row1, row2);


        }

    }
    private void changeCols(int col1, int col2) {
        int number;
        for (int i = 0; i < 9; i++) {
            number = table[i][col1];
            table[i][col1] = table[i][col2];
            table[i][col2] = number;

        }
    }
    private void changeRows(int row1, int row2) {
        int number;
        for (int i = 0; i < 9; i++) {
            number = table[row1][i];
            table[row1][i] = table[row2][i];
            table[row2][i] = number;

        }
    }
    private void init() {

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        Collections.shuffle(numbers);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                table[i][j] = 0;
            }
        }


        switch (Options.getDifficulties()) {
            case "Beginner":
                clues =  40;
                break;
            case "Easy":
                clues =  35;
                break;
            case "Medium":
                clues =  30;
                break;
            case "Hard":
                clues =  25;
                break;
            case "Expert":
                clues =  20;
                break;
            case "Ultimate":
                clues = 17;
                break;
        }
    }
    private void printTable(int[][] table) {

        System.out.println("-------------------------");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0 || j == 3 || j == 6) {
                    System.out.print("| ");
                }
                if (table[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(table[i][j] + " ");
                }

                if (j == 8) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i == 2 || i == 5) {
                System.out.println("-------------------------");
            }

        }
        System.out.println("-------------------------");
    }
    private void pickTwoRandomCols() {
        Random random = new Random();
        int startCols = 0;
        int endCols = 2;
        for (int i = 0; i < 3; i++) {
            int col1 = random.nextInt(endCols-startCols+1)+startCols ;
            int col2;
            do {
                col2 = random.nextInt(endCols-startCols+1)+startCols ;
            } while (col1 == col2);
            startCols+=3;
            endCols+=3;
            changeCols(col1, col2);

        }

    }

    public boolean generate(int row, int col) {
        Collections.shuffle(numbers);
        if (row == table.length - 1 && col == table[row].length) {
            return true;
        }

        if (col == table[row].length) {
            row++;
            col = 0;
        }

        if (table[row][col] != 0)
            return generate(row, col + 1);

        for (Integer number : numbers) {
            if (isSafe(row, col, number,table)) {
                table[row][col] = number;
                if (generate(row, col + 1)) {
                    return true;
                }
            }
            table[row][col] = 0;
        }
        return false;
    }
    public boolean checkIfBoardIsFully(){
        for(int row =0; row<table.length ;row++){
            for(int col=0; col<table[row].length;col++){
                if(table[row][col]==0) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkIfBoardIsCorrect(){
        for(int row =0; row<table.length ;row++){
            for(int col=0; col<table[row].length;col++){
                if(!isSafe(row,col,table[row][col],table)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isSafe(int row, int col, int num, int[][] table) {

        for (int i = 0; i < 9; i++) {
            if (table[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (table[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean solve(int row, int col, int[][] table) {
        if (row == table.length - 1 && col == table[row].length) {
            return true;
        }

        if (col == table[row].length) {
            row++;
            col = 0;
        }

        if (table[row][col] != 0)
            return solve(row, col + 1,table);

        for (int i = 1; i < 10; i++) {
            if (isSafe(row, col, i,table)) {
                table[row][col] = i;
                printTable(table);
                if (solve(row, col + 1,table)) {
                    return true;
                }
            }
            table[row][col] = 0;
        }
        return false;
    }

    public int[][] getTable() {
        return table;
    }
    public int[][] getNotModifiedTable() {
        return notModifiedTable;
    }
    public int getTableElement(int row, int col) {
        return table[row][col];
    }

    public boolean isSolvedByComputer() {
        return solvedByComputer;
    }

    public void setSolvedByComputer(boolean solvedByComputer) {
        this.solvedByComputer = solvedByComputer;
    }
}
