package com.example.javafx_applikasidataanaksm;

import com.example.javafx_applikasidataanaksm.controllers.TahunAjaranController;
import javafx.fxml.FXML;
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

    private Stage tahunAjaranStage;
    private TahunAjaranController tahunAjaranController;

    Connection con;
    PreparedStatement st;
    ResultSet rs;

    private int id_tahun_ajaran;

    @FXML
    public void initialize() {

    }

    public void updateKelasDropDownMenu() throws SQLException {
        con = DBConnection.getConnection();
        // Get Kelas values for drop down menu
        String query = "SELECT * FROM kelas WHERE id_tahun_ajaran = ?";
        st = con.prepareStatement(query);
        st.setInt(1, id_tahun_ajaran);
        rs = st.executeQuery();
        dropDownMenu.getItems().clear();
        while (rs.next()) {
            dropDownMenu.getItems().add(rs.getString("nama_kelas"));
        }
    }

    public void handlePilihTahunAjaranBtn() throws IOException {
        if (tahunAjaranStage != null) {
            tahunAjaranStage.show();
        }
    }

    public void setTahunAjaranStage(Stage tahunAjaranStage) {
        this.tahunAjaranStage = tahunAjaranStage;
    }

    public Stage getTahunAjaranStage() {
        return tahunAjaranStage;
    }

    public void setTahunAjaranController(TahunAjaranController tahunAjaranController) {
        this.tahunAjaranController = tahunAjaranController;
    }

    public TahunAjaranController getTahunAjaranController() {
        return tahunAjaranController;
    }

    public int getId_tahun_ajaran() {
        return id_tahun_ajaran;
    }

    public void setId_tahun_ajaran(int id_tahun_ajaran) {
        this.id_tahun_ajaran = id_tahun_ajaran;
    }
}