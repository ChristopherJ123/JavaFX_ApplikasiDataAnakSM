package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import com.example.javafx_applikasidataanaksm.DataAnakSMController;
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

    @FXML
    private Label submitButt;

    private DataAnakSMController controller;
    private boolean isUpdate = false;
    private Integer kelasIDToUpdate;
    private Integer anakIDToUpdate;

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

        if (isUpdate) {
            // CRUD UPDATE
            con = DBConnection.getConnection();
            String query = """
                UPDATE detail_kelas
                SET id_anak = ?, id_kelas = ?
                WHERE id_anak = ? AND id_kelas = ?
                """;
            st = con.prepareStatement(query);
            st.setInt(1, Integer.parseInt(field_id_anak.getValue().split(" ")[0]));
            st.setInt(2, Integer.parseInt(field_id_kelas.getValue().split(" ")[0]));
            st.setInt(3, anakIDToUpdate);
            st.setInt(4, kelasIDToUpdate);
            st.execute();
        } else {
            // CRUD INSERT
            con = DBConnection.getConnection();
            String query = """
                INSERT INTO detail_kelas (id_anak, id_kelas)
                VALUES(?, ?)
                """;
            st = con.prepareStatement(query);
            st.setInt(1, Integer.parseInt(field_id_anak.getValue().split(" ")[0]));
            st.setInt(2, Integer.parseInt(field_id_kelas.getValue().split(" ")[0]));
            st.execute();
        }
        add.getScene().getWindow().hide();
        controller.updateTable("button_kelas_anak");
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

    public Integer getAnakIDToUpdate() {
        return anakIDToUpdate;
    }

    public void setAnakIDToUpdate(Integer anakIDToUpdate) {
        this.anakIDToUpdate = anakIDToUpdate;
    }

    public ComboBox<String> getField_id_anak() {
        return field_id_anak;
    }

    public void setField_id_anak(Integer field_id_anak) {
        this.field_id_anak.setValue(String.valueOf(field_id_anak));
    }

    public ComboBox<String> getField_id_kelas() {
        return field_id_kelas;
    }

    public void setField_id_kelas(Integer field_id_kelas) {
        this.field_id_kelas.setValue(String.valueOf(field_id_kelas));
    }
}
