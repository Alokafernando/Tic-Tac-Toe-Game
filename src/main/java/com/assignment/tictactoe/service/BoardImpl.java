package com.assignment.tictactoe.service;

public class BoardImpl implements Board {

    private Piece [][] pieces;

    public BoardImpl() {
        pieces = new Piece[3][3];
        intializeBoard();
    }

    @Override
    public BoardUi getBoardUi() {
        return null;
    }

    @Override
    public void intializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                pieces[row][col] = Piece.EMPTY;
            }
        }
    }

    @Override
    public Boolean isLegalMove(int row, int col) {
        return pieces[row][col] == Piece.EMPTY;
    }

    @Override
    public void updateMove(int row, int col, Piece piece) {
        pieces[row][col] = piece;
    }

    @Override
    public Winner checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (pieces[i][0] == pieces[i][1] && pieces[i][0] == pieces[i][2] && pieces[i][0] != Piece.EMPTY) {
                return new Winner(pieces[i][0], i, 0, i, 1, i, 2);
            }
            if (pieces[0][i] == pieces[1][i] && pieces[0][i] == pieces[2][i] && pieces[0][i] != Piece.EMPTY) {
                return new Winner(pieces[0][i], 0, i, 1, i, 2, i);
            }
        }
        if (pieces[0][0] == pieces[1][1] && pieces[0][0] == pieces[2][2] && pieces[0][0] != Piece.EMPTY) {
            return new Winner(pieces[0][0], 0, 0, 1, 1, 2, 2);
        }
        if (pieces[0][2] == pieces[1][1] && pieces[0][2] == pieces[2][0] && pieces[0][2] != Piece.EMPTY) {
            return new Winner(pieces[0][2], 0, 2, 1, 1, 2, 0);
        }
        return null;
    }

    @Override
    public void printBoard() {
        System.out.println("_________________________");
        for (int row = 0; row < pieces.length; row++) {
            for (int col = 0; col < pieces[row].length; col++) {
                System.out.printf("| %-5s ", pieces[row][col]);
            }
            System.out.println("|");
            System.out.println("_________________________");
        }
        System.out.println();
    }

    @Override
    public Piece[][] getPieces() {
        return pieces;
    }


    public boolean isBoardFull() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
