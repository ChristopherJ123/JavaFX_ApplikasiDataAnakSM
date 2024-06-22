module com.example.javafx_applikasidataanaksm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafx_applikasidataanaksm to javafx.fxml;
    opens com.example.javafx_applikasidataanaksm.controllers;
    opens com.example.javafx_applikasidataanaksm.components;
    exports com.example.javafx_applikasidataanaksm;
    exports com.example.javafx_applikasidataanaksm.controllers;
    exports com.example.javafx_applikasidataanaksm.components;
}