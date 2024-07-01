package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuruDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private TextField field_nama_guru;

    @FXML
    private TextField field_no_telp;

    @FXML
    private TextField field_alamat;

    @FXML
    private Pane add;

    Connection con;
    PreparedStatement st;

    @FXML
    private void handleAdd() throws SQLException {
        // Error handling
        if (field_nama_guru.getText() == null || field_no_telp.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required inputs!");

            alert.showAndWait();
        }

        // CRUD INSERT
        con = DBConnection.getConnection();
        String query = """
                INSERT INTO guru (nama_guru, no_telp_guru, alamat)
                VALUES(?, ?, ?)
                """;
        st = con.prepareStatement(query);
        st.setString(1, field_nama_guru.getText());
        st.setString(2, field_no_telp.getText());
        st.setString(3, field_alamat.getText());
        st.execute();

        add.getScene().getWindow().hide();
    }

}