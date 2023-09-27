package com.kodilla.sudoku;
import org.springframework.stereotype.Service;

@Service
public class SudokuService {
    private final SudokuBoard sudokuBoard;

    public SudokuService() {
        this.sudokuBoard = new SudokuBoard();
    }

    public SudokuBoard getBoard() {
        return sudokuBoard;
    }

    public boolean makeMove(SudokuMove move) {
        int row = move.getRow();
        int col = move.getCol();
        int value = move.getValue();

        return sudokuBoard.makeMove(row, col, value);
    }

    public boolean isGameCompleted() {
        return sudokuBoard.isGameCompleted();
    }

    public void resetBoard() {
        sudokuBoard.resetBoard();
    }
}
