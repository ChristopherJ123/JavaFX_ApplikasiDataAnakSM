package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import com.example.javafx_applikasidataanaksm.DataAnakSMController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.sql.*;

public class AnakDialogController {

    @FXML
    private TextField field_nama_anak;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton field_gender_laki_laki;

    @FXML
    private RadioButton field_gender_perempuan;

    @FXML
    private DatePicker field_tanggal_lahir;

    @FXML
    private TextField field_nama_orang_tua;

    @FXML
    private TextField field_no_telp_orang_tua;

    @FXML
    private TextArea field_alamat;

    @FXML
    private Pane add;

    @FXML
    private Label submitButt;

    private DataAnakSMController controller;
    private boolean isUpdate = false;
    private Integer anakIDToUpdate;

    Connection con;
    PreparedStatement st;

    @FXML
    private void handleAdd() throws SQLException {
        // Error handling
        if (field_nama_anak.getText() == null || getGender() == null || field_tanggal_lahir.getValue() == null) {
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
                UPDATE anak
                SET nama_anak = ?, gender = ?, tanggal_lahir = ?, nama_orang_tua = ?, no_telp_orang_tua = ?, alamat = ?
                WHERE id_anak = ?
                """;
            st = con.prepareStatement(query);
            st.setString(1, field_nama_anak.getText());
            st.setString(2, getGender());
            st.setDate(3, Date.valueOf(field_tanggal_lahir.getValue()));
            st.setString(4, field_nama_orang_tua.getText());
            st.setString(5, field_no_telp_orang_tua.getText());
            st.setString(6, field_alamat.getText());
            st.setInt(7, anakIDToUpdate);
            st.execute();
        } else {
            // CRUD INSERT
            con = DBConnection.getConnection();
            String query = """
                INSERT INTO anak (nama_anak, gender, tanggal_lahir, nama_orang_tua, no_telp_orang_tua, alamat)
                VALUES(?, ?, ?, ?, ?, ?)
                """;
            st = con.prepareStatement(query);
            st.setString(1, field_nama_anak.getText());
            st.setString(2, getGender());
            st.setDate(3, Date.valueOf(field_tanggal_lahir.getValue()));
            st.setString(4, field_nama_orang_tua.getText());
            st.setString(5, field_no_telp_orang_tua.getText());
            st.setString(6, field_alamat.getText());
            st.execute();
        }
        add.getScene().getWindow().hide();
        controller.updateTable("button_anak");
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

    public Integer getAnakIDToUpdate() {
        return anakIDToUpdate;
    }

    public void setAnakIDToUpdate(Integer anakIDToUpdate) {
        this.anakIDToUpdate = anakIDToUpdate;
    }

    public String getGender() {
        return gender.getSelectedToggle() == field_gender_laki_laki ? "Laki-laki" : "Perempuan";
    }

    public void setGender(ToggleGroup gender) {
        this.gender = gender;
    }

    public TextField getField_nama_anak() {
        return field_nama_anak;
    }

    public void setField_nama_anak(String field_nama_anak) {
        this.field_nama_anak.setText(field_nama_anak);
    }

    public RadioButton getField_gender_laki_laki() {
        return field_gender_laki_laki;
    }

    public void setField_gender_laki_laki() {
        this.field_gender_laki_laki.fire();
    }

    public RadioButton getField_gender_perempuan() {
        return field_gender_perempuan;
    }

    public void setField_gender_perempuan() {
        this.field_gender_perempuan.fire();
    }

    public DatePicker getField_tanggal_lahir() {
        return field_tanggal_lahir;
    }

    public void setField_tanggal_lahir(Date date) {
        this.field_tanggal_lahir.setValue(date.toLocalDate());
    }

    public TextField getField_nama_orang_tua() {
        return field_nama_orang_tua;
    }

    public void setField_nama_orang_tua(String field_nama_orang_tua) {
        this.field_nama_orang_tua.setText(field_nama_orang_tua);
    }

    public TextField getField_no_telp_orang_tua() {
        return field_no_telp_orang_tua;
    }

    public void setField_no_telp_orang_tua(String field_no_telp_orang_tua) {
        this.field_no_telp_orang_tua.setText(field_no_telp_orang_tua);
    }

    public TextArea getField_alamat() {
        return field_alamat;
    }

    public void setField_alamat(String field_alamat) {
        this.field_alamat.setText(field_alamat);
    }
}
