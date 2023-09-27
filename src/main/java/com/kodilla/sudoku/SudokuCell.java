package com.kodilla.sudoku;

public class SudokuCell {
    private int value;
    private boolean initial;

    public SudokuCell() {
        this.value = 0;
        this.initial = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isInitial() {
        return initial;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }
}
