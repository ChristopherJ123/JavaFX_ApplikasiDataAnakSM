package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KehadiranDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private ComboBox<Integer> field_id_anak;

    @FXML
    private ComboBox<Integer> field_id_kebaktian;

    @FXML
    private ToggleGroup status;

    @FXML
    private RadioButton field_hadir;

    @FXML
    private RadioButton field_tidak_hadir;

    @FXML
    private Pane add;

    Connection con;
    PreparedStatement st;

    @FXML
    private void handleAdd() throws SQLException {
        // Error handling
        if (field_id_anak.getValue() == null || field_id_kebaktian.getValue() == null || getStatus() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required inputs!");

            alert.showAndWait();
        }

        // CRUD INSERT
        con = DBConnection.getConnection();
        String query = """
                INSERT INTO kehadiran (id_anak, id_kebaktian, status)
                VALUES(?, ?, ?)
                """;
        st = con.prepareStatement(query);
        st.setInt(1, field_id_anak.getValue());
        st.setInt(2, field_id_kebaktian.getValue());
        st.setString(3, getStatus());
        st.execute();

        add.getScene().getWindow().hide();
    }

    public String getStatus() {
        return status.getSelectedToggle() == field_hadir ? "1" : "0";
    }
}