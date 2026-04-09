package view;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import sudoku.model.exceptions.FillingBoardSudokuException;
import sudoku.model.models.SudokuBoard;
import sudoku.model.models.SudokuField;
import sudoku.model.solver.BacktrackingSudokuSolver;
import sudoku.view.DifficultyEnum;

public class DifficultyTest {
    @Test
    void testRemoveFieldsEasyDifficulty() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        DifficultyEnum gameDifficulty = DifficultyEnum.EASY;
        int numEmptyFields = 0;

        try {
            sudokuBoard.solveGame();
        } catch (FillingBoardSudokuException e) {
            e.printStackTrace();
            fail("solveGame() threw a FillingBoardSudokuException");
        }

        gameDifficulty.clearSudokuFieldsFromSudokuBoardBasedOnDifficulty(sudokuBoard);

        for (int y = 0; y < SudokuBoard.BOARD_SIZE; y++) {
            for(int x = 0; x < SudokuBoard.BOARD_SIZE; x++) {
                SudokuField field = sudokuBoard.getField(x, y);

                System.out.println("X: " + x + " Y: " + y);
                if(0 == field.getValue()) {
                    System.out.println("Here");
                    numEmptyFields++;
                }
            }
        }

        //I know its a magic number but they dont have these values saved anywhere
        assertEquals(30, numEmptyFields);

    }
}