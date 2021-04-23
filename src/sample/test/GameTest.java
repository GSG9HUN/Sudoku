package sample.test;

import org.junit.jupiter.api.Test;
import sample.model.Game;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testIsSafeWhenTryToInsertNumber3x3MatrixWhereHaveTheSameNumber(){
        //when
        Game game = new Game();
        game.createBoard();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                game.insertNumberInTable(i,j,0);
            }
        game.insertNumberInTable(1,2,5);
        //then
        boolean isSafe= game.isSafe(2,1,5);
        //given
        assertFalse(isSafe);
    }
    @Test
    public void testIsSafeWhenTryToInsertNumber3x3MatrixWhereHaveNotTheSameNumber(){
        //when
        Game game = new Game();
        game.createBoard();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                game.insertNumberInTable(i,j,0);
            }
        game.insertNumberInTable(1,2,5);
        //then
        boolean isSafe= game.isSafe(5,1,5);
        //given
        assertTrue(isSafe);
    }




    @Test
    public void testIsSafeWhenTryToInsertNumberSameRow(){
        //when
        Game game = new Game();
        game.createBoard();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                game.insertNumberInTable(i,j,0);
            }
        game.insertNumberInTable(1,2,5);
        //then
        boolean isSafe= game.isSafe(1,1,5);
        //given
        assertFalse(isSafe);
    }

    @Test
    public void testIsSafeWhenTryToInsertNumberSameColumn(){
        //when
        Game game = new Game();
        game.createBoard();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                game.insertNumberInTable(i,j,0);
            }
        game.insertNumberInTable(1,1,5);
        //then
        boolean isSafe= game.isSafe(5,1,5);
        //given
        assertFalse(isSafe);
    }
    @Test
    public void testIsSafeWhenTryToInsertNumber(){
        //when
        Game game = new Game();
        game.createBoard();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                game.insertNumberInTable(i,j,0);
            }
        game.insertNumberInTable(0,2,5);
        game.insertNumberInTable(2,0,4);
        game.insertNumberInTable(2,1,4);
        game.insertNumberInTable(2,2,2);
        //then
        boolean isSafe= game.isSafe(1,1,7);
        //given
        assertTrue(isSafe);
    }

    @Test
    public void testSolveGivenSudoku(){
        //when
        Game game = new Game();

        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        game.setTable(grid);
        //then
        boolean solvable = game.solve(0,0);
        //given
        assertTrue(solvable);
    }

}

