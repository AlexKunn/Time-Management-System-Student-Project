module com.example.timemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.timemanagementsystem to javafx.fxml;
    exports com.example.timemanagementsystem;
}