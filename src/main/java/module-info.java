module com.example.gymmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gymmanager to javafx.fxml;
    exports com.example.gymmanager;
}