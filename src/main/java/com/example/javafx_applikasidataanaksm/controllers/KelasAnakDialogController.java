package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.sql.*;

public class KelasAnakDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private ComboBox<String> field_id_anak;

    @FXML
    private ComboBox<String> field_id_kelas;

    @FXML
    private Pane add;

    Connection con;
    PreparedStatement st;
    ResultSet rs;

    @FXML
    public void initialize() throws SQLException {
        con = DBConnection.getConnection();
        String queryGuru = """
                SELECT id_anak, nama_anak FROM anak
                """;
        String queryKelas = """
                SELECT id_kelas, nama_kelas FROM kelas
                """;
        field_id_anak.getItems().clear();
        field_id_kelas.getItems().clear();
        st = con.prepareStatement(queryGuru);
        rs = st.executeQuery();
        while (rs.next()) {
            field_id_anak.getItems().add(rs.getInt(1) + " " + rs.getString(2));
        }
        st = con.prepareStatement(queryKelas);
        rs = st.executeQuery();
        while (rs.next()) {
            field_id_kelas.getItems().add(rs.getInt(1) + " " + rs.getString(2));
        }
    }

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
        st.setInt(1, Character.getNumericValue(field_id_anak.getValue().charAt(0)));
        st.setInt(2, Character.getNumericValue(field_id_kelas.getValue().charAt(0)));
        st.execute();

        add.getScene().getWindow().hide();
    }

}
