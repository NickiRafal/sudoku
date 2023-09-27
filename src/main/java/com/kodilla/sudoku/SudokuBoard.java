package com.kodilla.sudoku;

public class SudokuBoard {
    private SudokuCell[][] board;
    private static final int BOARD_SIZE = 9;

    public SudokuBoard() {
        this.board = new SudokuCell[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    public SudokuCell[][] getBoard() {
        return board;
    }

    public void initializeBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = new SudokuCell();
            }
        }
    }

    public boolean isValidMove(int row, int col, int value) {
        SudokuCell cell = board[row][col];

        if (cell.isInitial() || value < 1 || value > 9) {
            return false;
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][col].getValue() == value || board[row][i].getValue() == value) {
                return false; // Sprawdzanie wierszy i kolumn.
            }
        }

        int sectionStartRow = (row / 3) * 3;
        int sectionStartCol = (col / 3) * 3;
        for (int i = sectionStartRow; i < sectionStartRow + 3; i++) {
            for (int j = sectionStartCol; j < sectionStartCol + 3; j++) {
                if (board[i][j].getValue() == value) {
                    return false; // Sprawdzanie sekcji 3x3.
                }
            }
        }

        return true;
    }

    public boolean makeMove(int row, int col, int value) {
        if (isValidMove(row, col, value)) {
            board[row][col].setValue(value);
            return true;
        }
        return false;
    }

    public boolean isGameCompleted() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        initializeBoard();
    }
}
