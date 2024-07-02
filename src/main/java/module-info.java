module com.example.javafx_applikasidataanaksm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafx_applikasidataanaksm to javafx.fxml;
    opens com.example.javafx_applikasidataanaksm.archived.controllers;
    opens com.example.javafx_applikasidataanaksm.components;
    opens com.example.javafx_applikasidataanaksm.controllers;
    opens com.example.javafx_applikasidataanaksm.archived to javafx.fxml;
    opens com.example.javafx_applikasidataanaksm.controllers.users;

    exports com.example.javafx_applikasidataanaksm;
    exports com.example.javafx_applikasidataanaksm.archived.controllers;
    exports com.example.javafx_applikasidataanaksm.components;
    exports com.example.javafx_applikasidataanaksm.controllers;
    exports com.example.javafx_applikasidataanaksm.archived;
    exports com.example.javafx_applikasidataanaksm.controllers.users;
}