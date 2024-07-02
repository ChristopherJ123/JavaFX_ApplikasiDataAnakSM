package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import com.example.javafx_applikasidataanaksm.DataAnakSMController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KehadiranDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private ComboBox<String> field_id_anak;

    @FXML
    private ComboBox<String> field_id_kebaktian;

    @FXML
    private ToggleGroup status;

    @FXML
    private RadioButton field_hadir;

    @FXML
    private RadioButton field_tidak_hadir;

    @FXML
    private Pane add;

    @FXML
    private Label submitButt;

    private DataAnakSMController controller;
    private boolean isUpdate = false;
    private Integer kehadiranIDToUpdate;

    Connection con;
    PreparedStatement st;
    ResultSet rs;

    public void initialize() throws SQLException {
        con = DBConnection.getConnection();
        String queryAnak = """
                SELECT id_anak, nama_anak FROM anak
                """;
        String queryKebaktian = """
                SELECT id_kebaktian, nama_kebaktian FROM kebaktian
                """;
        field_id_anak.getItems().clear();
        field_id_kebaktian.getItems().clear();
        st = con.prepareStatement(queryAnak);
        rs = st.executeQuery();
        while (rs.next()) {
            field_id_anak.getItems().add(rs.getInt(1) + " " + rs.getString(2));
        }
        st = con.prepareStatement(queryKebaktian);
        rs = st.executeQuery();
        while (rs.next()) {
            field_id_kebaktian.getItems().add(rs.getInt(1) + " " + rs.getString(2));
        }
    }

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

        if (isUpdate) {
            // CRUD UPDATE
            con = DBConnection.getConnection();
            String query = """
                UPDATE kehadiran
                SET id_anak = ?, id_kebaktian = ?, status_kehadiran = ?
                WHERE id_kehadiran = ?
                """;
            st = con.prepareStatement(query);
            st.setInt(1, Integer.parseInt(field_id_anak.getValue().split(" ")[0]));
            st.setInt(2, Integer.parseInt(field_id_kebaktian.getValue().split(" ")[0]));
            st.setString(3, getStatus());
            st.setInt(4, kehadiranIDToUpdate);
            st.execute();
        } else {
            // CRUD INSERT
            con = DBConnection.getConnection();
            String query = """
                INSERT INTO kehadiran (id_anak, id_kebaktian, status_kehadiran)
                VALUES(?, ?, ?)
                """;
            st = con.prepareStatement(query);
            st.setInt(1, Integer.parseInt(field_id_anak.getValue().split(" ")[0]));
            st.setInt(2, Integer.parseInt(field_id_kebaktian.getValue().split(" ")[0]));
            st.setString(3, getStatus());
            st.execute();
        }
        add.getScene().getWindow().hide();
        controller.updateTable("button_kehadiran");
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

    public Integer getKehadiranIDToUpdate() {
        return kehadiranIDToUpdate;
    }

    public void setKehadiranIDToUpdate(Integer kehadiranIDToUpdate) {
        this.kehadiranIDToUpdate = kehadiranIDToUpdate;
    }

    public String getStatus() {
        return status.getSelectedToggle() == field_hadir ? "1" : "0";
    }

    public ComboBox<String> getField_id_anak() {
        return field_id_anak;
    }

    public void setField_id_anak(Integer field_id_anak) {
        this.field_id_anak.setValue(String.valueOf(field_id_anak));
    }

    public ComboBox<String> getField_id_kebaktian() {
        return field_id_kebaktian;
    }

    public void setField_id_kebaktian(Integer field_id_kebaktian) {
        this.field_id_kebaktian.setValue(String.valueOf(field_id_kebaktian));
    }

    public RadioButton getField_hadir() {
        return field_hadir;
    }

    public void setField_hadir(boolean hadir) {
        if (hadir) {
            field_hadir.setSelected(true);
            field_tidak_hadir.setSelected(false);
        } else {
            field_hadir.setSelected(false);
            field_tidak_hadir.setSelected(true);
        }
    }

    public RadioButton getField_tidak_hadir() {
        return field_tidak_hadir;
    }

    public void setField_tidak_hadir(RadioButton field_tidak_hadir) {
        this.field_tidak_hadir = field_tidak_hadir;
    }
}