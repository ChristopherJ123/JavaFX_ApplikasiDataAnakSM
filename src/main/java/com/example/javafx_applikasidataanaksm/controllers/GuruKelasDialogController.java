package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import com.example.javafx_applikasidataanaksm.DataAnakSMController;
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

    @FXML
    private Label submitButt;

    private DataAnakSMController controller;
    private boolean isUpdate = false;
    private Integer guruIDToUpdate;
    private Integer kelasIDToUpdate;

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

        if (isUpdate) {
            // CRUD UPDATE
            con = DBConnection.getConnection();
            String query = """
                UPDATE guru_kelas
                SET id_kelas = ?, id_guru = ?
                WHERE id_kelas = ? AND id_guru = ?
                """;
            st = con.prepareStatement(query);
            st.setInt(1, Integer.parseInt(field_id_kelas.getValue().split(" ")[0]));
            st.setInt(2, Integer.parseInt(field_id_guru.getValue().split(" ")[0]));
            st.setInt(3, kelasIDToUpdate);
            st.setInt(4, guruIDToUpdate);
            st.execute();
            System.out.println("Kelas sesudah " + Integer.parseInt(field_id_kelas.getValue().split(" ")[0]));
            System.out.println("Guru sesudah " + Integer.parseInt(field_id_guru.getValue().split(" ")[0]));
            System.out.println("Kelas sebelum " + kelasIDToUpdate);
            System.out.println("Guru sebelum " + guruIDToUpdate);
        } else {
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
        }
        add.getScene().getWindow().hide();
        controller.updateTable("button_guru_kelas");
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

    public Integer getKelasIDToUpdate() {
        return kelasIDToUpdate;
    }

    public void setKelasIDToUpdate(Integer kelasIDToUpdate) {
        this.kelasIDToUpdate = kelasIDToUpdate;
    }

    public ComboBox<String> getField_id_guru() {
        return field_id_guru;
    }

    public void setField_id_guru(Integer field_id_guru) {
        this.field_id_guru.setValue(String.valueOf(field_id_guru));
    }

    public ComboBox<String> getField_id_kelas() {
        return field_id_kelas;
    }

    public void setField_id_kelas(Integer field_id_kelas) {
        this.field_id_kelas.setValue(String.valueOf(field_id_kelas));
    }
}
