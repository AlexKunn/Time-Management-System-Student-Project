package com.example.timemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * ecran de tranzitie, aceasta clasa prezinta un ecran de tranzitie intre functiile aplicatiei.
 */
public class MainScreen {

    @FXML
    private Button logout;
    @FXML
    private Button ViewEvents;
    @FXML
    private Button CreateEvent;

    /**
     * buton ce trimite catre scena ce permite crearea actiunilor
     * @param event
     * @throws IOException
     */
    public  void ViewEvents(ActionEvent event) throws  IOException{
        Main m = new Main();
        m.changeScene("ViewEvents.fxml");
    }

    /**
     * buton ce trimite catre scena ce permite vizualizarea actiunilor
     * @param event
     * @throws IOException
     */
    public  void CreateEvent(ActionEvent event) throws  IOException{
        Main m = new Main();
        m.changeScene("CreateEvent.fxml");
    }

    /**
     * buton ce trimite inapoi la ecranul de log-in
     * @param event
     * @throws IOException
     */
    public  void logout(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("Login.fxml");
    }
}
