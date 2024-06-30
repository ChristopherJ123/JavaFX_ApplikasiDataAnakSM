package com.example.javafx_applikasidataanaksm;

import com.example.javafx_applikasidataanaksm.components.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppController {
    @FXML
    private ComboBox<?> tahun_ajaran;

    @FXML
    private Pane add;

    @FXML
    private Pane edit;

    @FXML
    private Pane remove;

    @FXML
    private Button button_anak;

    @FXML
    private Button button_dashboard;

    @FXML
    private Button button_guru;

    @FXML
    private Button button_kebaktian;

    @FXML
    private Button button_kehadiran;

    @FXML
    private Button button_kelas;

    @FXML
    private Button button_laporan;

    @FXML
    private Label lable_table_anak;

    @FXML
    private Label lable_table_guru;

    @FXML
    private Label lable_table_kebaktian;

    @FXML
    private Label lable_table_kehadiran;

    @FXML
    private Label lable_table_kelas;

    @FXML
    private Label lable_table_laporan;

    @FXML
    private TableView<Anak> table_anak;

    @FXML
    private TableColumn<Anak, Integer> table_anak_id_anak;

    @FXML
    private TableColumn<Anak, String> table_anak_nama_anak;

    @FXML
    private TableColumn<Anak, String> table_anak_gender_anak;

    @FXML
    private TableColumn<Anak, Date> table_anak_tanggal_lahir;

    @FXML
    private TableColumn<Anak, String> table_anak_alamat;

    @FXML
    private TableColumn<Anak, String> table_anak_nama_orang_tua;

    @FXML
    private TableColumn<Anak, String> table_anak_no_telp_orang_tua;

    @FXML
    private TableView<Guru> table_guru;

    @FXML
    private TableColumn<Guru, Integer> table_guru_id_guru;

    @FXML
    private TableColumn<Guru, String> table_guru_nama_guru;

    @FXML
    private TableColumn<Guru, String> table_guru_alamat_guru;

    @FXML
    private TableColumn<Guru, String> table_guru_no_telp;

    @FXML
    private TableView<Kelas> table_kelas;

    @FXML
    private TableColumn<Kelas, Integer> table_kelas_id_kelas;

    @FXML
    private TableColumn<Kelas, Integer> table_kelas_nama_kelas;

    @FXML
    private TableView<Kehadiran> table_kehadiran;

    @FXML
    private TableColumn<Kehadiran, Integer> table_kehadiran_id_kehadiran;

    @FXML
    private TableColumn<Kehadiran, Date> table_kehadiran_tanggal_kebaktian;

    @FXML
    private TableColumn<Kehadiran, String> table_kehadiran_judul_kebaktian;

    @FXML
    private TableColumn<Kehadiran, String> table_kehadiran_nama_kehadiran;

    @FXML
    private TableColumn<Kehadiran, Date> table_kehadiran_kehadiran;

    @FXML
    private TableView<Kebaktian> table_kebaktian;

    @FXML
    private TableColumn<Kebaktian, Integer> table_kebaktian_id_kebaktian;

    @FXML
    private TableColumn<Kebaktian, Date> table_kebaktian_tanggal_kebaktian;

    @FXML
    private TableColumn<Kebaktian, String> table_kebaktian_nama_kebaktian;

    @FXML
    private TableColumn<Kebaktian, Integer> table_kebaktian_laki_kebaktian;

    @FXML
    private TableColumn<Kebaktian, Integer> table_kebaktian_perempuan_kebaktian;

    @FXML
    private TableColumn<Kebaktian, Integer> table_kebaktian_total_kehadiran;

    @FXML
    private TableView<?> table_laporan;

    @FXML
    private TableColumn<?, ?> table_laporan_no_laporan;

    @FXML
    private TableColumn<?, ?> table_laporan_nama_laporan;

    @FXML
    private TableColumn<?, ?> table_laporan_total_laporan;

    private List<Label> labels;
    private List<TableView<?>> tableViews;
    private String buttonId;

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    @FXML
    public void initialize() throws SQLException {
        con = DBConnection.getConnection();
        button_anak.setStyle("-fx-background-color: #1f3341;");

        setButtonHoverEffect(button_anak);
        setButtonHoverEffect(button_guru);
        setButtonHoverEffect(button_kelas);
        setButtonHoverEffect(button_kehadiran);
        setButtonHoverEffect(button_kebaktian);
        setButtonHoverEffect(button_laporan);

        labels= new ArrayList<>();
        labels.add(lable_table_anak);
        labels.add(lable_table_guru);
        labels.add(lable_table_kelas);
        labels.add(lable_table_kehadiran);
        labels.add(lable_table_kebaktian);
        labels.add(lable_table_laporan);

        tableViews = new ArrayList<>();
        tableViews.add(table_anak);
        tableViews.add(table_guru);
        tableViews.add(table_kelas);
        tableViews.add(table_kehadiran);
        tableViews.add(table_kebaktian);
        tableViews.add(table_laporan);

        buttonId = "button_anak";
        updateTableViewVisibility();
        updateTable(buttonId);
    }

    public void handleButtonMenuClick(ActionEvent event) throws SQLException {
        Button clickedButton = (Button) event.getSource();
        resetButtonBackgrounds();
        clickedButton.setStyle("-fx-background-color: #1f3341;");
        buttonId = clickedButton.getId();
        updateTableViewVisibility();
    }

    private void updateTableViewVisibility() throws SQLException {
        for (Label label : labels) {
            label.setVisible(false);
        }
        for (TableView<?> tableView : tableViews) {
            tableView.setVisible(false);
        }
        switch (buttonId) {
            case "button_anak" -> {
                table_anak.setVisible(true);
                lable_table_anak.setVisible(true);
            }
            case "button_guru" -> {
                table_guru.setVisible(true);
                lable_table_guru.setVisible(true);
            }
            case "button_kelas" -> {
                table_kelas.setVisible(true);
                lable_table_kelas.setVisible(true);
            }
            case "button_kehadiran" -> {
                table_kehadiran.setVisible(true);
                lable_table_kehadiran.setVisible(true);
            }
            case "button_kebaktian" -> {
                table_kebaktian.setVisible(true);
                lable_table_kebaktian.setVisible(true);
            }
            case "button_laporan" -> {
                table_laporan.setVisible(true);
                lable_table_laporan.setVisible(true);
            }
        }
        updateTable(buttonId);
    }

    private void resetButtonBackgrounds() {
        button_anak.setStyle("-fx-background-color: #2C3C5C;");
        button_guru.setStyle("-fx-background-color: #2C3C5C;");
        button_kelas.setStyle("-fx-background-color: #2C3C5C;");
        button_kehadiran.setStyle("-fx-background-color: #2C3C5C;");
        button_kebaktian.setStyle("-fx-background-color: #2C3C5C;");
        button_laporan.setStyle("-fx-background-color: #2C3C5C;");
    }

    private void setButtonHoverEffect(Button button) {
        String initialStyle = button.getStyle();

        button.setOnMouseEntered(e -> button.setStyle(button.getStyle() + "-fx-background-color: #3A4C6D;"));
        button.setOnMouseExited(e -> {
            button.setStyle(initialStyle);
            if (button.getId().equals(buttonId)) {
                button.setStyle("-fx-background-color: #1f3341;");
            }
        });
    }

    public void updateTable(String buttonID) throws SQLException {
        switch (buttonID) {
            case "button_anak" -> {
                ObservableList<Anak> list = getAnak();
                table_anak.setItems(list);
                table_anak_id_anak.setCellValueFactory(new PropertyValueFactory<>("id_anak"));
                table_anak_nama_anak.setCellValueFactory(new PropertyValueFactory<>("nama_anak"));
                table_anak_gender_anak.setCellValueFactory(new PropertyValueFactory<>("gender"));
                table_anak_tanggal_lahir.setCellValueFactory(new PropertyValueFactory<>("tanggal_lahir"));
                table_anak_nama_orang_tua.setCellValueFactory(new PropertyValueFactory<>("nama_orang_tua"));
                table_anak_no_telp_orang_tua.setCellValueFactory(new PropertyValueFactory<>("no_telp_orang_tua"));
                table_anak_alamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
            }
            case "button_guru" -> {
                ObservableList<Guru> list = getGuru();
                table_guru.setItems(list);
                table_guru_id_guru.setCellValueFactory(new PropertyValueFactory<>("id_guru"));
                table_guru_nama_guru.setCellValueFactory(new PropertyValueFactory<>("nama_guru"));
                table_guru_alamat_guru.setCellValueFactory(new PropertyValueFactory<>("alamat"));
                table_guru_no_telp.setCellValueFactory(new PropertyValueFactory<>("no_telp_guru"));
            }
            case "button_kelas" -> {
                ObservableList<Kelas> list = getKelas();
                table_kelas.setItems(list);
                table_kelas_id_kelas.setCellValueFactory(new PropertyValueFactory<>("id_kelas"));
                table_kelas_nama_kelas.setCellValueFactory(new PropertyValueFactory<>("nama_kelas"));
            }
            case "button_kehadiran" -> {

            }
            case "button_kebaktian" -> {
                ObservableList<Kebaktian> list = getKebaktian();
                for (Kebaktian kebaktian : list) {
                    System.out.println(kebaktian.getNama_kebaktian());
                }
                table_kebaktian.setItems(list);
                table_kebaktian_id_kebaktian.setCellValueFactory(new PropertyValueFactory<>("id_kebaktian"));
                table_kebaktian_nama_kebaktian.setCellValueFactory(new PropertyValueFactory<>("nama_kebaktian"));
                table_kebaktian_tanggal_kebaktian.setCellValueFactory(new PropertyValueFactory<>("tanggal_kebaktian"));
            }
        }

    }

    public ObservableList<Anak> getAnak() throws SQLException {
        ObservableList<Anak> listAnak = FXCollections.observableArrayList();
        con = DBConnection.getConnection();
        String query = """
                SELECT * FROM anak
        """;
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            Anak anak = new Anak(rs.getInt("id_anak"), rs.getString("nama_anak"),
                    rs.getString("gender"), rs.getDate("tanggal_lahir"),
                    rs.getString("nama_orang_tua"), rs.getString("no_telp_orang_tua"),
                    rs.getString("alamat"), rs.getDate("created_at"));
            listAnak.add(anak);
        }
        return listAnak;
    }

    public ObservableList<Kelas> getKelas() throws SQLException {
        ObservableList<Kelas> listKelas = FXCollections.observableArrayList();
        con = DBConnection.getConnection();
        String query = """
                SELECT * FROM kelas
        """;
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            Kelas kelas = new Kelas(rs.getInt("id_kelas"), rs.getString("nama_kelas"),
                    rs.getDate("created_at"));
            listKelas.add(kelas);
        }
        return listKelas;
    }

    public ObservableList<DetailKelas> getDetailKelas() throws SQLException {
        ObservableList<DetailKelas> listDetailKelas = FXCollections.observableArrayList();
        con = DBConnection.getConnection();
        String query = """
                SELECT * FROM detail_kelas
        """;
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            DetailKelas detailKelas = new DetailKelas(rs.getInt("id_anak"), rs.getInt("id_kelas"),
                    rs.getDate("created_at"));
            listDetailKelas.add(detailKelas);
        }
        return listDetailKelas;
    }

    public ObservableList<Guru> getGuru() throws SQLException {
        ObservableList<Guru> listGuru = FXCollections.observableArrayList();
        con = DBConnection.getConnection();
        String query = """
                SELECT * FROM guru
        """;
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            Guru guru = new Guru(rs.getInt("id_guru"), rs.getString("nama_guru"),
                    rs.getString("alamat"), rs.getString("no_telp_guru"),
                    rs.getDate("created_at"));
            listGuru.add(guru);
        }
        return listGuru;
    }

    public ObservableList<GuruKelas> getGuruKelas() throws SQLException {
        ObservableList<GuruKelas> listGuruKelas = FXCollections.observableArrayList();
        con = DBConnection.getConnection();
        String query = """
                SELECT * FROM guru_kelas
        """;
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            GuruKelas guruKelas = new GuruKelas(rs.getInt("id_kelas"), rs.getInt("id_anak"),
                    rs.getDate("created_at"));
            listGuruKelas.add(guruKelas);
        }
        return listGuruKelas;
    }

    public ObservableList<Kehadiran> getKehadiran() throws SQLException {
        ObservableList<Kehadiran> listKehadiran = FXCollections.observableArrayList();
        con = DBConnection.getConnection();
        String query = """
                SELECT * FROM kehadiran
        """;
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            Kehadiran kehadiran = new Kehadiran(rs.getInt("id_kehadiran"),
                    rs.getInt("status_kehadiran"), rs.getInt("id_kebaktian"),
                    rs.getInt("id_anak")
            );
            listKehadiran.add(kehadiran);
        }
        return listKehadiran;
    }

    public ObservableList<Kebaktian> getKebaktian() throws SQLException {
        ObservableList<Kebaktian> listKebaktian = FXCollections.observableArrayList();
        con = DBConnection.getConnection();
        String query = """
                SELECT * FROM kebaktian
        """;
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            Kebaktian kebaktian = new Kebaktian(rs.getInt("id_kebaktian"),
                    rs.getString("nama_kebaktian"), rs.getDate("tanggal_kebaktian"));
            listKebaktian.add(kebaktian);
        }
        return listKebaktian;
    }

}
