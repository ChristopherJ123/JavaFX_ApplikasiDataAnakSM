package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuruKelasDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private ComboBox<String> field_id_guru;

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
                SELECT id_guru, nama_guru FROM guru
                """;
        String queryKelas = """
                SELECT id_kelas, nama_kelas FROM kelas
                """;
        field_id_guru.getItems().clear();
        field_id_kelas.getItems().clear();
        st = con.prepareStatement(queryGuru);
        rs = st.executeQuery();
        while (rs.next()) {
            field_id_guru.getItems().add(rs.getInt(1) + " " + rs.getString(2));
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
        st.setInt(1, Character.getNumericValue(field_id_kelas.getValue().charAt(0)));
        st.setInt(2, Character.getNumericValue(field_id_guru.getValue().charAt(0)));
        st.execute();

        add.getScene().getWindow().hide();
    }

}
