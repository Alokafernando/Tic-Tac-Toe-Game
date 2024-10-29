package com.assignment.tictactoe.controller;

import com.assignment.tictactoe.service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;


public class BoardController implements BoardUi {
    BoardImpl board;
    AiPlayer aiPlayer;
    HumanPlayer humanPlayer;

    public BoardController(){
        board = new BoardImpl();
        aiPlayer = new AiPlayer(board);
        humanPlayer = new HumanPlayer(board);
    }

    @FXML
    private Label lblAiWinningCount;

    @FXML
    private Label lblHumanWinningCount;

    @FXML
    private Label lblMatchTiedCount;

    @FXML
    private GridPane mainGrid;

    private int humanCount = 0;
    private int aiCount = 0;
    private int tiedCount = 0;

   @FXML
    void setValues_onButton(ActionEvent event) {
       Button button = (Button) event.getSource();
//       int row = Integer.parseInt(button.getId().split("")[2]);
//       int col = Integer.parseInt(button.getId().split("")[3]);
       int row = Integer.parseInt(button.getId().substring(3, 4)); // Gets the first digit after "btn"
       int col = Integer.parseInt(button.getId().substring(4, 5)); // Gets the second digit after "btn"


       humanPlayer.move(row, col);
       updateUi();
       aiPlayer.findBestMove();
       board.printBoard();
       updateUi();

       if (board.checkWinner() != null) {
           notifyWinner(board.checkWinner().winner());
       } else if (board.isBoardFull()) {
           tiedCount++;
           showAlert("Tie");
       }
    }

    private void updateUi() {
        for (int i = 0; i < board.getPieces().length; i++) {
            for (int j = 0; j < board.getPieces()[i].length; j++) {
                update(i, j, board.getPieces()[i][j]);

            }
        }
    }

    @Override
    public void update(int col, int row, Piece piece) {
        String buttonId = "btn" + col + row;
        for (Node node : mainGrid.getChildren()) {
            if (node instanceof Button button && buttonId.equals(node.getId())) {
                button.setStyle("-fx-background-color:  #045D5D; -fx-background-radius: 25; -fx-border-radius: 25; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 10, 0.3, 0, 4);\n");
                if (piece == Piece.X) {
                    button.setStyle("-fx-border-color: #3867d6; -fx-background-radius: 25; -fx-border-radius: 25; -fx-text-fill: #3867d6; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 10, 0.3, 0, 4);\n");
                    button.setText("X");
                } else if (piece == Piece.O) {
                    button.setStyle("-fx-border-color: #ff3838; -fx-background-radius: 25; -fx-border-radius: 25; -fx-text-fill: #ff3838; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 10, 0.3, 0, 4);\n");
                    button.setText("O");
                } else {
                    button.setText("");
                }
                break;
            }
        }
    }

    @Override
    public void notifyWinner(Piece winner) {
        if (winner == Piece.X) {
            humanCount++;
            showAlert("Human win");
        } else if (winner == Piece.O) {
            aiCount++;
            showAlert("Ai win");
        }
        setMatchCount();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.setOnCloseRequest((DialogEvent event) -> {
           board.intializeBoard();
            updateUi();
            setMatchCount();
        });
        alert.showAndWait();
    }

    private void setMatchCount(){
       lblMatchTiedCount.setText(String.valueOf(tiedCount));
       lblHumanWinningCount.setText(String.valueOf(humanCount));
       lblAiWinningCount.setText(String.valueOf(aiCount));
    }

}


