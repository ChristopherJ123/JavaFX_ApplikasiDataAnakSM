package com.example.javafx_applikasidataanaksm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSekolahMingguController {
    @FXML
    private ComboBox<String> dropDownMenu;

    @FXML
    private Button editKelasBtn;

    @FXML
    private Button editPesertaBtn;

    @FXML
    private Button hapusKelasBtn;

    @FXML
    private Button hapusPesertaBtn;

    @FXML
    private Button pilihTahunAjaranBtn;

    @FXML
    private TableView<?> table;

    @FXML
    private Button tambahKelasBtn;

    @FXML
    private Button tambahPesertaBtn;

    @FXML
    private Button tampilkanKelasBtn;

    Connection con;
    PreparedStatement st;
    ResultSet rs;

    @FXML
    public void initialize() throws SQLException {
        con = DBConnection.getConnection();

        // Get Kelas values for drop down menu
        String query = "SELECT * FROM kelas";
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            dropDownMenu.getItems().add(rs.getString("nama_kelas"));
        }
        dropDownMenu.setValue("Pilih kelas");
    }

    public void handlePilihTahunAjaranBtn() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DataSekolahMingguApplication.class.getResource("tahun_ajaran-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Pilih Tahun Ajaran");
        stage.setScene(new Scene(root));
        stage.show();
    }
}