module com.example.javafx_applikasidataanaksm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafx_applikasidataanaksm to javafx.fxml;
    exports com.example.javafx_applikasidataanaksm;
}