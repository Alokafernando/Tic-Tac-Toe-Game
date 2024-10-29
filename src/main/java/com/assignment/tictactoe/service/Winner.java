package com.assignment.tictactoe.service;

public class Winner {

    private Piece winnerPiece;
    private  int col1;
    private  int row1;
    private  int col2;
    private  int row2;
    private int col3;
    private int row3;

    public Winner(Piece winnerPiece, int col1, int row1, int col2, int row2, int col3, int row3) {
        this.winnerPiece = winnerPiece;
        this.col1 = col1;
        this.row1 = row1;
        this.col2 = col2;
        this.row2 = row2;
        this.col3 = col3;
        this.row3 = row3;
    }

    public Piece winner() {
        return winnerPiece;
    }
}
