package com.assignment.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/view/Board.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe");

        Image image = new Image(getClass().getResourceAsStream("/images/application logo1.png"));
        stage.getIcons().add(image);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
