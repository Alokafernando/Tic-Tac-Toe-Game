package com.assignment.tictactoe.service;

public interface BoardUi {
    void update(int col, int row, Piece piece);
    void notifyWinner(Piece winner);
}
