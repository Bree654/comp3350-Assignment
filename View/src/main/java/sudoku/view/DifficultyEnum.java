package sudoku.view;

import sudoku.model.models.SudokuBoard;
import sudoku.model.models.SudokuField;

import java.util.Random;

public enum DifficultyEnum {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    // TODO - think about the size of the board
    public static final int EASY_NUM_REMOVED = 30;
    public static final int MED_NUM_REMOVED = 50;
    public static final int HARD_NUM_REMOVED = 70;

    @SuppressWarnings("unused")
    private int value;

    DifficultyEnum(int newVal) {
        this.value = newVal;
    }

    /**
     * Clears the Sudoku fields from the Sudoku board based on the difficulty.
     * 
     * @param sudokuBoard the Sudoku board to clear fields from
     */
    public void clearSudokuFieldsFromSudokuBoardBasedOnDifficulty(SudokuBoard sudokuBoard) {

        int numberOfFieldsToClear = 0;
        switch (this) {
            case EASY:
                numberOfFieldsToClear = EASY_NUM_REMOVED;
                break;
            case MEDIUM:
                numberOfFieldsToClear = MED_NUM_REMOVED;
                break;
            case HARD:
                numberOfFieldsToClear = HARD_NUM_REMOVED;
                break;
            default:
                break;
        }

        Random random = new Random();
        int fieldsCleared = 0;
        // int boardSize = sudokuBoard.getSize();
        int boardSize = 9;

        while (fieldsCleared < numberOfFieldsToClear) {
            int x = random.nextInt(boardSize);
            int y = random.nextInt(boardSize);
            SudokuField field = sudokuBoard.getField(x, y);

            if (field.getValue() != 0) {
                field.setValue(0);
                fieldsCleared++;
            }
        }

    }
}
