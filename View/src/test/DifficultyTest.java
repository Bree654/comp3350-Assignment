import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import sudoku.model.exceptions.FillingBoardSudokuException;
import sudoku.model.interfaces.SudokuBaseContainer;
import sudoku.model.models.SudokuBoard;
import sudoku.model.models.SudokuField;
import sudoku.model.solver.BacktrackingSudokuSolver;

public class DifficultyTest {
    @Test
    void testRemoveFieldsEasyDifficulty() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        int numEmptyFields = 0;

        try {
            sudokuBoard.solveGame();
        } catch (FillingBoardSudokuException e) {
            e.printStackTrace();
            fail("solveGame() threw a FillingBoardSudokuException");
        }

        for (int y = 0; y < SudokuBoard.BOARD_SIZE; y++) {
            for(int x = 0; x < SudokuBoard.BOARD_SIZE; x++) {
                SudokuField field = sudokuBoard.getField(x, y);

                if(0 == field.getValue()) {
                    numEmptyFields++;
                }
            }
        }

        //I know its a magic number but they dont have these values saved anywhere
        assertEquals(numEmptyFields, 30);

    }
}
