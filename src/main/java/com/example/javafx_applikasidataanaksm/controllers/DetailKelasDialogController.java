package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DetailKelasDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private ComboBox<Integer> field_id_anak;

    @FXML
    private ComboBox<Integer> field_id_kelas;

    @FXML
    private Pane add;

    Connection con;
    PreparedStatement st;

    @FXML
    private void handleAdd() throws SQLException {
        // Error handling
        if (field_id_anak.getValue() == null || field_id_kelas.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required inputs!");

            alert.showAndWait();
        }

        // CRUD INSERT
        con = DBConnection.getConnection();
        String query = """
                INSERT INTO detail_kelas (id_anak, id_kelas)
                VALUES(?, ?)
                """;
        st = con.prepareStatement(query);
        st.setInt(1, field_id_anak.getValue());
        st.setInt(2, field_id_kelas.getValue());
        st.executeQuery();

        add.getScene().getWindow().hide();
    }

}
