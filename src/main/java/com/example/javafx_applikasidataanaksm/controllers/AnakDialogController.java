package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.sql.*;

public class AnakDialogController {

    @FXML
    private Label text_lable;

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

    Connection con;
    private PreparedStatement st;

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

        add.getScene().getWindow().hide();
    }

    public String getGender() {
        return gender.getSelectedToggle() == field_gender_laki_laki ? "Laki-laki" : "Perempuan";
    }

    public TextField getField_nama_anak() {
        return field_nama_anak;
    }

    public RadioButton getField_gender_laki_laki() {
        return field_gender_laki_laki;
    }

    public RadioButton getField_gender_perempuan() {
        return field_gender_perempuan;
    }

    public DatePicker getField_tanggal_lahir() {
        return field_tanggal_lahir;
    }

    public TextField getField_nama_orang_tua() {
        return field_nama_orang_tua;
    }

    public TextField getField_no_telp_orang_tua() {
        return field_no_telp_orang_tua;
    }

    public TextArea getField_alamat() {
        return field_alamat;
    }
}
