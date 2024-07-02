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

public class GuruDialogController {

    @FXML
    private TextField field_nama_guru;

    @FXML
    private TextField field_no_telp;

    @FXML
    private TextField field_alamat;

    @FXML
    private Pane add;

    @FXML
    private Label submitButt;

    private DataAnakSMController controller;
    private boolean isUpdate = false;
    private Integer guruIDToUpdate;

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

        if (isUpdate) {
            // CRUD UPDATE
            con = DBConnection.getConnection();
            String query = """
                UPDATE guru
                SET nama_guru = ?, no_telp_guru = ?, alamat = ?
                WHERE id_guru = ?
                """;
            st = con.prepareStatement(query);
            st.setString(1, field_nama_guru.getText());
            st.setString(2, field_no_telp.getText());
            st.setString(3, field_alamat.getText());
            st.setInt(4, guruIDToUpdate);
            st.execute();
        } else {
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
        }
        add.getScene().getWindow().hide();
        controller.updateTable("button_guru");
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

    public Integer getGuruIDToUpdate() {
        return guruIDToUpdate;
    }

    public void setGuruIDToUpdate(Integer guruIDToUpdate) {
        this.guruIDToUpdate = guruIDToUpdate;
    }

    public TextField getField_nama_guru() {
        return field_nama_guru;
    }

    public void setField_nama_guru(String field_nama_guru) {
        this.field_nama_guru.setText(field_nama_guru);
    }

    public TextField getField_no_telp() {
        return field_no_telp;
    }

    public void setField_no_telp(String field_no_telp) {
        this.field_no_telp.setText(field_no_telp);
    }

    public TextField getField_alamat() {
        return field_alamat;
    }

    public void setField_alamat(String field_alamat) {
        this.field_alamat.setText(field_alamat);
    }
}