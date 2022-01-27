package com.example.timemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * aceasta clasa permite vizualizarea evenimentelor, si cautandu-le in functie de data in care au fost plasate
 */
public class ViewEvents {

    public String ListEvent;
    boolean EventIsPresent=false;
    @FXML
    public ListView<String> myListView;
    @FXML
    public String DateTowrite;
    @FXML
    private Label DateChecker;
    @FXML
    private Label EventFound;
    @FXML
    private TextField Writedate;
    @FXML
    private Button Back;
    @FXML
    private Button SearchButton;
    @FXML
    /**
     *pornirea verificarii datei introdusa in camp
     * @param event reprezinta actiunea pornita la apasarea butonului
     * @throws IOException
     */
                public void Search (ActionEvent event) throws IOException {
                CheckSearch();
            }

    /**
     * verificarea datei introdusa in camp, si introducerea evenimentelor gasite in Listview
     * @throws IOException
     */
                private void CheckSearch() throws IOException {
                    myListView.getItems().clear();
                if (Writedate.getText().matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
                    DateChecker.setText("Date format ok");
                    DateTowrite=String.valueOf(Writedate.getText());
                    System.out.print("test1\n");
                    Scanner scan = new Scanner(new File(("Events.txt")));
                    EventIsPresent=false;
                    System.out.print(DateTowrite+"\n");
                    while (scan.hasNext()) {
                        String line = scan.nextLine().toLowerCase().toString();
                        ListEvent=line;
                        if (line.contains(DateTowrite))
                        {
                            EventIsPresent=true;
                            System.out.print("yes"+"\n");
                            EventFound.setText("event/s found");
                            myListView.getItems().add(myListView.getItems().size(), line);

                        }
                        if(!EventIsPresent)
                            EventFound.setText("event not found");

                    }
                } else
                    DateChecker.setText("Date format not ok,please use zz/ll/yyyy");
            }

    /**
     * intoarcerea la meniul precedent
     * @param event
     * @throws IOException
     */
                public void Back (ActionEvent event) throws IOException {
                Main m = new Main();
                m.changeScene("afterLogin.fxml");
            }
            }





