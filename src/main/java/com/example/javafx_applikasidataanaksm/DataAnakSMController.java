package com.example.javafx_applikasidataanaksm;

import com.example.javafx_applikasidataanaksm.components.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DataAnakSMController {
    @FXML
    private ComboBox<?> combo_box_tahun_ajaran;

    @FXML
    private ComboBox<?> combo_box_kelas;

    @FXML
    private Pane add;

    @FXML
    private Pane edit;

    @FXML
    private Pane remove;

    @FXML
    private Button button_dashboard;

    @FXML
    private Button button_anak;

    @FXML
    private Button button_kelas_anak;

    @FXML
    private Button button_guru;

    @FXML
    private Button button_guru_kelas;

    @FXML
    private Button button_kebaktian;

    @FXML
    private Button button_kehadiran;

    @FXML
    private Button button_kelas;

    @FXML
    private Button button_laporan;

    @FXML
    private Button button_laporan_mingguan;

    @FXML
    private Button button_laporan_tahunan;

    @FXML
    private Label text_lable;

    @FXML
    private TextArea text_area_laporan;

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
    private TableView<GuruKelas> table_guru_kelas;

    @FXML
    private TableColumn<GuruKelas, Integer> table_guru_kelas_id_kelas;

    @FXML
    private TableColumn<GuruKelas, Integer> table_guru_kelas_id_guru;

    @FXML
    private TableColumn<GuruKelas, String> table_guru_kelas_nama_kelas;

    @FXML
    private TableColumn<GuruKelas, String> table_guru_kelas_nama_guru;

    @FXML
    private TableColumn<GuruKelas, Date> table_guru_kelas_created_at;

    @FXML
    private TableView<Kelas> table_kelas;

    @FXML
    private TableColumn<Kelas, Integer> table_kelas_id_kelas;

    @FXML
    private TableColumn<Kelas, Integer> table_kelas_nama_kelas;

    @FXML
    private TableView<KelasAnak> table_kelas_anak;

    @FXML
    private TableColumn<KelasAnak, Integer> table_kelas_anak_id_anak;

    @FXML
    private TableColumn<KelasAnak, Integer> table_kelas_anak_id_kelas;

    @FXML
    private TableColumn<KelasAnak, String> table_kelas_anak_nama_anak;

    @FXML
    private TableColumn<KelasAnak, String> table_kelas_anak_nama_kelas;

    @FXML
    private TableColumn<KelasAnak, Date> table_kelas_anak_created_at;

    @FXML
    private TableView<Kehadiran> table_kehadiran;

    @FXML
    private TableColumn<Kehadiran, Integer> table_kehadiran_id_kehadiran;

    @FXML
    private TableColumn<Kehadiran, Integer> table_kehadiran_id_anak;

    @FXML
    private TableColumn<Kehadiran, Integer> table_kehadiran_id_kebaktian;

    @FXML
    private TableColumn<Kehadiran, Integer> table_kehadiran_status;

    @FXML
    private TableColumn<Kehadiran, Date> table_kehadiran_tanggal_kebaktian;

    @FXML
    private TableColumn<Kehadiran, String> table_kehadiran_nama_kebaktian;

    @FXML
    private TableColumn<Kehadiran, String> table_kehadiran_nama_anak;

    @FXML
    private TableView<Kebaktian> table_kebaktian;

    @FXML
    private TableColumn<Kebaktian, Integer> table_kebaktian_id_kebaktian;

    @FXML
    private TableColumn<Kebaktian, Date> table_kebaktian_tanggal_kebaktian;

    @FXML
    private TableColumn<Kebaktian, String> table_kebaktian_nama_kebaktian;

    private List<Button> menuButtons;
    private List<Button> laporanButtons;
    private List<TableView<?>> tableViews;
    private List<Pane> CRUDPanes;
    private String buttonId;
    private Integer selectedParam1;
    private Integer selectedParam2;

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    @FXML
    public void initialize() throws SQLException {
        con = DBConnection.getConnection();

        setButtonHoverEffect(button_anak);
        setButtonHoverEffect(button_kelas_anak);
        setButtonHoverEffect(button_guru);
        setButtonHoverEffect(button_guru_kelas);
        setButtonHoverEffect(button_kelas);
        setButtonHoverEffect(button_kehadiran);
        setButtonHoverEffect(button_kebaktian);
        setButtonHoverEffect(button_laporan);
        setButtonHoverEffect(button_laporan_mingguan);
        setButtonHoverEffect(button_laporan_tahunan);

        menuButtons = new ArrayList<>();
        menuButtons.add(button_anak);
        menuButtons.add(button_kelas_anak);
        menuButtons.add(button_guru);
        menuButtons.add(button_guru_kelas);
        menuButtons.add(button_kelas);
        menuButtons.add(button_kebaktian);
        menuButtons.add(button_kehadiran);
        menuButtons.add(button_laporan);

        laporanButtons = new ArrayList<>();
        laporanButtons.add(button_laporan_mingguan);
        laporanButtons.add(button_laporan_tahunan);

        tableViews = new ArrayList<>();
        tableViews.add(table_anak);
        tableViews.add(table_guru);
        tableViews.add(table_guru_kelas);
        tableViews.add(table_kelas);
        tableViews.add(table_kelas_anak);
        tableViews.add(table_kehadiran);
        tableViews.add(table_kebaktian);

        CRUDPanes = new ArrayList<>();
        CRUDPanes.add(add);
        CRUDPanes.add(edit);
        CRUDPanes.add(remove);

        buttonId = "button_anak";

        updateTableViewVisibility();
        updateTable(buttonId);
        for (Button menuButton : menuButtons) {
            menuButton.setVisible(true);
        }
        for (Button laporanButton : laporanButtons) {
            laporanButton.setVisible(false);
        }
        combo_box_kelas.setVisible(false);
        text_area_laporan.setVisible(false);

        table_anak.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedParam1 = newValue.getId_anak();
            }
        });
        table_guru.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedParam1 = newValue.getId_guru();
            }
        });
        table_guru_kelas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedParam1 = newValue.getId_guru();
                selectedParam2 = newValue.getId_kelas();
            }
        });
        table_kelas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedParam1 = newValue.getId_kelas();
            }
        });
        table_kelas_anak.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedParam1 = newValue.getId_anak();
                selectedParam2 = newValue.getId_kelas();
            }
        });
        table_kebaktian.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedParam1 = newValue.getId_kebaktian();
            }
        });
        table_kehadiran.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedParam1 = newValue.getId_kehadiran();
            }
        });
    }

    public void handleButtonDashboardClick(ActionEvent event) throws SQLException {
        if (!Objects.equals(buttonId, "button_dashboard")) {
            for (Button menuButton : menuButtons) {
                menuButton.setVisible(true);
            }
            for (Button laporanButton : laporanButtons) {
                laporanButton.setVisible(false);
            }
            for (Pane pane : CRUDPanes) {
                pane.setVisible(true);
            }
            combo_box_kelas.setVisible(false);
            text_area_laporan.setVisible(false);
            buttonId = "button_anak";
            resetButtonBackgrounds();
            updateTableViewVisibility();
        }
    }

    public void handleButtonMenuClick(ActionEvent event) throws SQLException {
        Button clickedButton = (Button) event.getSource();
        resetButtonBackgrounds();
        clickedButton.setStyle("-fx-background-color: #212d45;");
        buttonId = clickedButton.getId();
        updateTableViewVisibility();
    }

    public void handleButtonLaporanClick(ActionEvent event) throws SQLException {
        Button clickedButton = (Button) event.getSource();
        resetButtonBackgrounds();
        clickedButton.setStyle("-fx-background-color: #1f3341;");
        buttonId = "button_laporan_mingguan";
        for (Button menuButton : menuButtons) {
            menuButton.setVisible(false);
        }
        for (Button laporanButton : laporanButtons) {
            laporanButton.setVisible(true);
        }
        for (Pane pane : CRUDPanes) {
            pane.setVisible(false);
        }
        combo_box_kelas.setVisible(true);
        text_area_laporan.setVisible(true);
        updateTableViewVisibility();
    }

    public void handleAddButtonClick(MouseEvent event) throws IOException, SQLException {
        FXMLLoader appLoader = new FXMLLoader(this.getClass().getResource("dialogs/" + buttonId.replace("button_", "") + "-dialog.fxml"));
        Scene scene = new Scene(appLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Input " + buttonId.replace('_', ' '));
        stage.setScene(scene);
        stage.show();
        updateTable(buttonId);
    }

    public void handleEditButtonClick(MouseEvent event) throws IOException, SQLException {
        FXMLLoader appLoader = new FXMLLoader(this.getClass().getResource("dialogs/" + buttonId.replace("button_", "") + "-dialog.fxml"));
        Scene scene = new Scene(appLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Input " + buttonId.replace('_', ' '));
        stage.setScene(scene);
        stage.show();
        updateTable(buttonId);
    }

    public void handleRemoveButtonClick(MouseEvent event) {

    }

    private void updateTableViewVisibility() throws SQLException {
        for (TableView<?> tableView : tableViews) {
            tableView.setVisible(false);
        }
        switch (buttonId) {
            case "button_anak" -> {
                table_anak.setVisible(true);
                text_lable.setText("Tabel Anak");
            }
            case "button_guru" -> {
                table_guru.setVisible(true);
                text_lable.setText("Tabel Guru");
            }
            case "button_guru_kelas" -> {
                table_guru_kelas.setVisible(true);
                text_lable.setText("Tabel Guru Kelas");
            }
            case "button_kelas" -> {
                table_kelas.setVisible(true);
                text_lable.setText("Tabel Kelas");
            }
            case "button_kelas_anak" -> {
                table_kelas_anak.setVisible(true);
                text_lable.setText("Tabel Kelas Anak");
            }
            case "button_kehadiran" -> {
                table_kehadiran.setVisible(true);
                text_lable.setText("Tabel Kehadiran");
            }
            case "button_kebaktian" -> {
                table_kebaktian.setVisible(true);
                text_lable.setText("Tabel Kebaktian");
            }
            case "button_laporan_mingguan" -> {
                text_lable.setText("Laporan Mingguan");
                viewLaporanMingguan();
            }
            case "button_laporan_tahunan" -> {
                text_lable.setText("Laporan Tahunan");
                viewLaporanTahunan();
            }
        }
        updateTable(buttonId);
    }

    private void resetButtonBackgrounds() {
        button_anak.setStyle("-fx-background-color: #2C3C5C;");
        button_guru.setStyle("-fx-background-color: #2C3C5C;");
        button_guru_kelas.setStyle("-fx-background-color: #2C3C5C;");
        button_kelas.setStyle("-fx-background-color: #2C3C5C;");
        button_kelas_anak.setStyle("-fx-background-color: #2C3C5C;");
        button_kehadiran.setStyle("-fx-background-color: #2C3C5C;");
        button_kebaktian.setStyle("-fx-background-color: #2C3C5C;");
        button_laporan.setStyle("-fx-background-color: #2C3C5C;");
        button_laporan_mingguan.setStyle("-fx-background-color: #2C3C5C;");
        button_laporan_tahunan.setStyle("-fx-background-color: #2C3C5C;");
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
            case "button_guru_kelas" -> {
                ObservableList<GuruKelas> list = getGuruKelas();
                table_guru_kelas.setItems(list);
                table_guru_kelas_created_at.setCellValueFactory(new PropertyValueFactory<>("created_at"));
                table_guru_kelas_id_guru.setCellValueFactory(new PropertyValueFactory<>("id_guru"));
                table_guru_kelas_id_kelas.setCellValueFactory(new PropertyValueFactory<>("id_kelas"));
            }
            case "button_kelas" -> {
                ObservableList<Kelas> list = getKelas();
                table_kelas.setItems(list);
                table_kelas_id_kelas.setCellValueFactory(new PropertyValueFactory<>("id_kelas"));
                table_kelas_nama_kelas.setCellValueFactory(new PropertyValueFactory<>("nama_kelas"));
            }
            case "button_kelas_anak" -> {
                ObservableList<KelasAnak> list = getKelasAnak();
                table_kelas_anak.setItems(list);
                table_kelas_anak_created_at.setCellValueFactory(new PropertyValueFactory<>("created_at"));
                table_kelas_anak_id_anak.setCellValueFactory(new PropertyValueFactory<>("id_anak"));
                table_kelas_anak_id_kelas.setCellValueFactory(new PropertyValueFactory<>("id_kelas"));
            }
            case "button_kehadiran" -> {
                ObservableList<Kehadiran> list = getKehadiran();
                table_kehadiran.setItems(list);
                table_kehadiran_id_kehadiran.setCellValueFactory(new PropertyValueFactory<>("id_kehadiran"));
                table_kehadiran_id_anak.setCellValueFactory(new PropertyValueFactory<>("id_anak"));
                table_kehadiran_id_kebaktian.setCellValueFactory(new PropertyValueFactory<>("id_kebaktian"));
                table_kehadiran_status.setCellValueFactory(new PropertyValueFactory<>("status_kehadiran"));
            }
            case "button_kebaktian" -> {
                ObservableList<Kebaktian> list = getKebaktian();
                table_kebaktian.setItems(list);
                table_kebaktian_id_kebaktian.setCellValueFactory(new PropertyValueFactory<>("id_kebaktian"));
                table_kebaktian_nama_kebaktian.setCellValueFactory(new PropertyValueFactory<>("nama_kebaktian"));
                table_kebaktian_tanggal_kebaktian.setCellValueFactory(new PropertyValueFactory<>("tanggal_kebaktian"));
            }
        }
    }

    public void viewLaporanMingguan() throws SQLException {
        text_area_laporan.setText("");
        con = DBConnection.getConnection();
        String query1 = """
                SELECT id_kebaktian, nama_kebaktian FROM kebaktian
                """;
        st = con.prepareStatement(query1);
        rs = st.executeQuery();
        Map<Integer, String> kebaktianList = new HashMap<>();
        while (rs.next()) {
            kebaktianList.put(rs.getInt("id_kebaktian"), rs.getString("nama_kebaktian"));
        }
        String query2 = """
                SELECT k.nama_kelas,
                    SUM(CASE WHEN a.gender = 'Laki-laki' THEN 1 ELSE 0 END) AS jumlah_laki,
                    SUM(CASE WHEN a.gender = 'Perempuan' THEN 1 ELSE 0 END) AS jumlah_perempuan
                FROM kebaktian kb
                JOIN kehadiran kh
                ON kh.id_kebaktian = kb.id_kebaktian
                JOIN anak a
                ON a.id_anak = kh.id_anak
                JOIN kelas_anak ka
                ON ka.id_anak = a.id_anak
                JOIN kelas k
                ON k.id_kelas = ka.id_kelas
                WHERE kh.status_kehadiran = 1 AND kb.id_kebaktian = ?
                GROUP BY k.id_kelas
                """;
        for (int i = 1; i <= kebaktianList.size(); i++) {
            st = con.prepareStatement(query2);
            st.setInt(1, i);
            rs = st.executeQuery();
            text_area_laporan.setText(text_area_laporan.getText() +
                kebaktianList.get(i) + "\n" + """
                Nama Kelas \t\t\t Jumlah Laki-laki \t\t Jumlah Perempuan
                """);
            while (rs.next()) {
                text_area_laporan.setText(text_area_laporan.getText() +
                        rs.getString(1) + "\t\t\t" + rs.getInt(2) + "\t\t" + rs.getInt(3)
                        + "\n"
                );
            }
            text_area_laporan.setText(text_area_laporan.getText() + "\n\n");
        }
    }

    public void viewLaporanTahunan() throws SQLException {
        text_area_laporan.setText("");
        con = DBConnection.getConnection();
        String query1 = """
                SELECT id_kelas, nama_kelas FROM kelas
                """;
        st = con.prepareStatement(query1);
        rs = st.executeQuery();
        Map<Integer, String> kelasList = new HashMap<>();
        while (rs.next()) {
            kelasList.put(rs.getInt("id_kelas"), rs.getString("nama_kelas"));
        }
        con = DBConnection.getConnection();
        String query2 = """
                SELECT a.id_anak, a.nama_anak, COUNT(*) AS total_kehadiran\s
                FROM kehadiran kh
                JOIN anak a
                ON a.id_anak = kh.id_anak
                JOIN kelas_anak ka
                ON ka.id_anak = a.id_anak
                JOIN kelas k
                ON k.id_kelas = ka.id_kelas
                WHERE kh.status_kehadiran = 1 AND k.id_kelas = ?
                GROUP BY a.id_anak
                """;
        for (int i = 1; i <= kelasList.size(); i++) {
            st = con.prepareStatement(query2);
            st.setInt(1, i);
            rs = st.executeQuery();
            text_area_laporan.setText(text_area_laporan.getText() +
                    kelasList.get(i) + "\n" + """
                ID Anak \t\t\t Nama Anak \t\t Total Kehadiran
                """);
            while (rs.next()) {
                text_area_laporan.setText(text_area_laporan.getText() +
                        rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t\t" + rs.getInt(3)
                        + "\n"
                );
            }
            text_area_laporan.setText(text_area_laporan.getText() + "\n\n");
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

    public ObservableList<KelasAnak> getKelasAnak() throws SQLException {
        ObservableList<KelasAnak> listKelasAnak = FXCollections.observableArrayList();
        con = DBConnection.getConnection();
        String query = """
                SELECT * FROM kelas_anak
        """;
        st = con.prepareStatement(query);
        rs = st.executeQuery();
        while (rs.next()) {
            KelasAnak kelasAnak = new KelasAnak(rs.getInt("id_anak"), rs.getInt("id_kelas"),
                    rs.getDate("created_at"));
            listKelasAnak.add(kelasAnak);
        }
        return listKelasAnak;
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
            GuruKelas guruKelas = new GuruKelas(rs.getInt("id_kelas"), rs.getInt("id_guru"),
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

    public void update() throws SQLException {
        ObservableList<Kelas> list = getKelas();
        table_kelas.setItems(list);
        table_kelas_id_kelas.setCellValueFactory(new PropertyValueFactory<>("id_kelas"));
        table_kelas_nama_kelas.setCellValueFactory(new PropertyValueFactory<>("nama_kelas"));
    }

}
