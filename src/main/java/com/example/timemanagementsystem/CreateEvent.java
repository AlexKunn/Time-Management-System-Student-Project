package com.example.timemanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Alex
 * clasa creeaza un eveniment, in functie de data, ora, titlu, si descriere
 * data si ora sunt verificate folosind regex
 * titlul si descrierea nu sunt obligatorii
 */
public class CreateEvent {
    @FXML
    private Button Back;
    @FXML
    private Label Success;
    @FXML
    private Label DateCheck;
    @FXML
    private Label HourCheck;
    @FXML
    private TextField Hour;
    @FXML
    private TextField Date;
    @FXML
    private TextField Title;
    @FXML
    private TextField Desc;
    @FXML
    private Button Create;

    /**
     *
     * @param event butonul create porneste verificarea datei si a orei
     * @throws IOException
     */
    public void Create(ActionEvent event) throws IOException {
        CheckCreate();
    }

    /**
     * verificarea datei si a orei
     * @throws IOException
     */
    private void CheckCreate() throws IOException {
        Main m = new Main();
        if (Hour.getText().matches("\\d{2}:\\d{2}")) {
            if (Date.getText().matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
                Writedate();
            } else
                DateCheck.setText("Date format not ok,please use zz/ll/yyyy");
        } else
            HourCheck.setText("Hour format not ok, please use hh:mm");

    }

    /**
     * preluarea valorilor din text fields, si trecerea acestora in text file
     * @throws IOException
     */
    private void Writedate() throws IOException {

        String datewrite = String.valueOf(Date.getText());
        String hourwrite = String.valueOf(Hour.getText());
        String titlewrite= String.valueOf(Title.getText());
        String descwrite= String.valueOf(Desc.getText());
        System.out.print(datewrite);
        Scanner scan = new Scanner(new File(("Events.txt")));
        while (scan.hasNext()) {
            String line = scan.nextLine().toLowerCase().toString();
            if (line.contains(datewrite + "," + hourwrite)) {
                Success.setText("event already exists");
                break;
            }
            else {
                try {
                    FileWriter fw = new FileWriter("Events.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.newLine();
                    bw.write(datewrite);
                    bw.write(",");
                    bw.write(hourwrite);
                    bw.write(",");
                    bw.write(titlewrite);
                    bw.write(",");
                    bw.write(descwrite);
                    bw.newLine();
                    bw.close();
                    System.out.println("Successfully wrote to the file.");
                    Success.setText("Success!");
                    break;
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }
    }
    public  void Back(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("afterLogin.fxml");
    }
}