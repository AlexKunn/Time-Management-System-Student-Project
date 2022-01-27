package com.example.timemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * clasa verifica username-ul si parola
 */
public class LogIn {

    public LogIn(){

    }
    @FXML

    private Button button;
    @FXML
    private Label WrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    /**
     *Apasarea butonului initializeaza verificarea campurilor username si password
     * @param event
     * @throws IOException
     */
    public void  UserLogIn(ActionEvent event) throws IOException{
        checkLogIn();
    }

    /**
     * verificarea username-ului si a parolei
     * @throws IOException
     */
    private void checkLogIn() throws IOException {
        Main m= new Main();
    if(username.getText().toString().equals("admin") && password.getText().toString().equals("123"))
    {
        WrongLogIn.setText("Succes!");

        m.changeScene("afterLogin.fxml");
    }

    else if(username.getText().isEmpty() && password.getText().isEmpty())
        WrongLogIn.setText("please enter your data!");
    else{
        WrongLogIn.setText("wrong user/pass!");
    }

    }


}