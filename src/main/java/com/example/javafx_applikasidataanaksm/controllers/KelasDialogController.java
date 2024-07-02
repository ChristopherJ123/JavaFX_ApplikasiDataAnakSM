package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import com.example.javafx_applikasidataanaksm.DataAnakSMController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KelasDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private TextField field_nama_kelas;

    @FXML
    private Pane add;

    @FXML
    private Label submitButt;

    private DataAnakSMController controller;
    private boolean isUpdate = false;
    private Integer kelasIDToUpdate;

    Connection con;
    PreparedStatement st;

    @FXML
    private void handleAdd() throws SQLException {
        // Error handling
        if (field_nama_kelas.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required inputs!");

            alert.showAndWait();
        }

        if (isUpdate) {
            // CRUD UPDATE
            con = DBConnection.getConnection();
            String query = """
                UPDATE kelas
                SET nama_kelas = ?
                WHERE id_kelas = ?
                """;
            st = con.prepareStatement(query);
            st.setString(1, field_nama_kelas.getText());
            st.setInt(2, kelasIDToUpdate);
            st.execute();
        } else {
            // CRUD INSERT
            con = DBConnection.getConnection();
            String query = """
                INSERT INTO kelas (nama_kelas)
                VALUES(?)
                """;
            st = con.prepareStatement(query);
            st.setString(1, field_nama_kelas.getText());
            st.execute();
        }
        add.getScene().getWindow().hide();
        controller.updateTable("button_kelas");
    }

    public DataAnakSMController getController() {
        return controller;
    }

    public void setController(DataAnakSMController controller) {
        this.controller = controller;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        if (update) submitButt.setText("Save");
        else submitButt.setText("Add");
        isUpdate = update;
    }

    public Integer getKelasIDToUpdate() {
        return kelasIDToUpdate;
    }

    public void setKelasIDToUpdate(Integer kelasIDToUpdate) {
        this.kelasIDToUpdate = kelasIDToUpdate;
    }

    public TextField getField_nama_kelas() {
        return field_nama_kelas;
    }

    public void setField_nama_kelas(String field_nama_kelas) {
        this.field_nama_kelas.setText(field_nama_kelas);
    }
}