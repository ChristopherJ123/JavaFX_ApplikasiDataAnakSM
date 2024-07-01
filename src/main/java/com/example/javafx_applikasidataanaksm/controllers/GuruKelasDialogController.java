package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuruKelasDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private ComboBox<Integer> field_id_guru;

    @FXML
    private ComboBox<Integer> field_id_kelas;

    @FXML
    private Pane add;

    Connection con;
    PreparedStatement st;

    @FXML
    private void handleAdd() throws SQLException {
        // Error handling
        if (field_id_guru.getValue() == null || field_id_kelas.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required inputs!");

            alert.showAndWait();
        }

        // CRUD INSERT
        con = DBConnection.getConnection();
        String query = """
                INSERT INTO guru_kelas (id_kelas, id_guru)
                VALUES(?, ?)
                """;
        st = con.prepareStatement(query);
        st.setInt(1, field_id_kelas.getValue());
        st.setInt(2, field_id_guru.getValue());
        st.executeQuery();

        add.getScene().getWindow().hide();
    }

}
