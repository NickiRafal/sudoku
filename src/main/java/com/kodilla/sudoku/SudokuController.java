package com.kodilla.sudoku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sudoku")
public class SudokuController {
    private final SudokuService sudokuService;

    @Autowired
    public SudokuController(SudokuService sudokuService) {
        this.sudokuService = sudokuService;
    }

    @GetMapping("/board")
    public SudokuBoard getBoard() {
        return sudokuService.getBoard();
    }

    @PostMapping("/move")
    public boolean makeMove(@RequestBody SudokuMove move) {
        return sudokuService.makeMove(move);
    }

    @GetMapping("/check")
    public boolean checkIfGameCompleted() {
        return sudokuService.isGameCompleted();
    }

    @PostMapping("/reset")
    public void resetBoard() {
        sudokuService.resetBoard();
    }
    @GetMapping("/")
    public String index() {
        return "index"; // Zwraca nazwę pliku HTML bez rozszerzenia.
    }
}
