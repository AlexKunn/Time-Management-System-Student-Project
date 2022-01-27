package com.example.timemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    private  static  Stage stg;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stg= primaryStage;
        primaryStage.setResizable(false);
        Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("The Clock");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();



    }
    public  void changeScene(String fxml) throws  IOException{
        Parent pane =FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}