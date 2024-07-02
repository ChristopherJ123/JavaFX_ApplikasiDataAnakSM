package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import com.example.javafx_applikasidataanaksm.DataAnakSMController;
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

    @FXML
    private Label submitButt;

    private DataAnakSMController controller;
    private boolean isUpdate = false;
    private Integer kebaktianIDToUpdate;

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

        if (isUpdate) {
            // CRUD UPDATE
            con = DBConnection.getConnection();
            String query = """
                UPDATE kebaktian
                SET nama_kebaktian = ?, tanggal_kebaktian = ?
                WHERE id_kebaktian = ?
                """;
            st = con.prepareStatement(query);
            st.setString(1, field_nama_kebaktian.getText());
            st.setDate(2, Date.valueOf(field_tanggal_kebaktian.getValue()));
            st.setInt(3, kebaktianIDToUpdate);
            st.execute();
        } else {
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
        }
        add.getScene().getWindow().hide();
        controller.updateTable("button_kebaktian");
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

    public Integer getKebaktianIDToUpdate() {
        return kebaktianIDToUpdate;
    }

    public void setKebaktianIDToUpdate(Integer kebaktianIDToUpdate) {
        this.kebaktianIDToUpdate = kebaktianIDToUpdate;
    }

    public TextField getField_nama_kebaktian() {
        return field_nama_kebaktian;
    }

    public void setField_nama_kebaktian(String field_nama_kebaktian) {
        this.field_nama_kebaktian.setText(field_nama_kebaktian);
    }

    public DatePicker getField_tanggal_kebaktian() {
        return field_tanggal_kebaktian;
    }

    public void setField_tanggal_kebaktian(Date field_tanggal_kebaktian) {
        this.field_tanggal_kebaktian.setValue(field_tanggal_kebaktian.toLocalDate());
    }
}