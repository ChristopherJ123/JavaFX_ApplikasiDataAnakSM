package com.example.javafx_applikasidataanaksm.controllers;

import com.example.javafx_applikasidataanaksm.DBConnection;
import com.example.javafx_applikasidataanaksm.components.TahunAjaran;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class TahunAjaranController {

    @FXML
    private Button deleteTahunAjaranBtn;

    @FXML
    private Button editTahunAjaranBtn;

    @FXML
    private TableView<TahunAjaran> table;

    @FXML
    private TableColumn<TahunAjaran, Integer> table_id;

    @FXML
    private TableColumn<TahunAjaran, Integer> table_tahun;

    @FXML
    private Button tambahTahunAjaranBtn;

    Connection con;
    PreparedStatement st;
    ResultSet rs;

    @FXML
    public void initialize() throws SQLException {
        showData();
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(newValue.getId_tahun_ajaran());
                System.out.println(newValue.getTahun());
            }
        });
    }

    public void handleTambahTahunAjaranBtn() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input Tahun Ajaran");
        dialog.setHeaderText(null);
        dialog.setContentText("Tahun Ajaran:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(tahunAjaran -> {
            System.out.println("Tahun Ajaran: " + tahunAjaran);
        });
    }

    public void showData() throws SQLException {
        ObservableList<TahunAjaran> list = getTahunAjaran();
        table.setItems(list);
        table_id.setCellValueFactory(new PropertyValueFactory<TahunAjaran, Integer>("id_tahun_ajaran"));
        table_tahun.setCellValueFactory(new PropertyValueFactory<TahunAjaran, Integer>("tahun"));
    }

    public ObservableList<TahunAjaran> getTahunAjaran() throws SQLException {
        ObservableList<TahunAjaran> listOfTahunAjaran = FXCollections.observableArrayList();
        String query = "SELECT * FROM tahun_ajaran";
        con = DBConnection.getConnection();
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            TahunAjaran tahunAjaran = new TahunAjaran(rs.getInt("id_tahun_ajaran"), rs.getInt("tahun"));
            listOfTahunAjaran.add(tahunAjaran);
        }
        return listOfTahunAjaran;
    }

}
