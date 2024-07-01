package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KebaktianDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private TextField field_nama_kebaktian;

    @FXML
    private DatePicker field_tanggal_kebaktian;

    @FXML
    private Pane add;

    Connection con;
    PreparedStatement st;

    @FXML
    private void handleAdd() throws SQLException {
        // Error handling
        if (field_nama_kebaktian.getText() == null || field_tanggal_kebaktian.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required inputs!");

            alert.showAndWait();
        }

        // CRUD INSERT
        con = DBConnection.getConnection();
        String query = """
                INSERT INTO kebaktian (nama_kebaktian, tanggal_kebaktian)
                VALUES(?, ?)
                """;
        st = con.prepareStatement(query);
        st.setString(1, field_nama_kebaktian.getText());
        st.setDate(2, Date.valueOf(field_tanggal_kebaktian.getValue()));
        st.execute();

        add.getScene().getWindow().hide();
    }
}