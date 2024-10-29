package com.assignment.tictactoe.service;

import javax.swing.text.Position;

public interface Board {
    BoardUi getBoardUi();
    void intializeBoard();
    Boolean isLegalMove(int row, int col);
    void updateMove(int row, int col, Piece piece);
    Winner checkWinner();
    void printBoard();


    Piece[][] getPieces();
}