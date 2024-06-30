package com.example.javafx_applikasidataanaksm.archived;

import com.example.javafx_applikasidataanaksm.DBConnection;
import com.example.javafx_applikasidataanaksm.components.Anak;
import com.example.javafx_applikasidataanaksm.archived.controllers.TahunAjaranController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

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
    private TableView<Anak> table;

    @FXML
    private TableColumn<Anak, Integer> id_anak;

    @FXML
    private TableColumn<Anak, String> nama_anak;

    @FXML
    private TableColumn<Anak, String> gender;

    @FXML
    private TableColumn<Anak, Date> tanggal_lahir;

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

    private Integer id_tahun_ajaran;
    private String nama_kelas;

    @FXML
    public void initialize() {
        dropDownMenu.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    nama_kelas = newValue;
                    updateTable();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
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

    public void updateTable() throws SQLException {
        ObservableList<Anak> list = getAnak();
        table.setItems(list);
        id_anak.setCellValueFactory(new PropertyValueFactory<Anak, Integer>("id_anak"));
        nama_anak.setCellValueFactory(new PropertyValueFactory<Anak, String>("nama_anak"));
        gender.setCellValueFactory(new PropertyValueFactory<Anak, String>("gender"));
        tanggal_lahir.setCellValueFactory(new PropertyValueFactory<Anak, Date>("tanggal_lahir"));
    }

    public ObservableList<Anak> getAnak() throws SQLException {
        ObservableList<Anak> listOfAnak = FXCollections.observableArrayList();
        con = DBConnection.getConnection();
        String query = """
                SELECT a.id_anak, a.nama_anak, a.gender, a.tanggal_lahir FROM public.detail_kelas dk
                JOIN anak a ON a.id_anak = dk.id_anak
                JOIN kelas k ON k.id_kelas = dk.id_kelas
                WHERE nama_kelas = ? AND id_tahun_ajaran = ?
        """;
        st = con.prepareStatement(query);
        st.setString(1, nama_kelas);
        st.setInt(2, id_tahun_ajaran);
        rs = st.executeQuery();
        while (rs.next()) {
            Anak anak = new Anak(rs.getInt("id_anak"), rs.getString("nama_anak"), rs.getString("gender"), rs.getDate("tanggal_lahir"), rs.getDate("created_at"));
            listOfAnak.add(anak);
        }
        return listOfAnak;
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