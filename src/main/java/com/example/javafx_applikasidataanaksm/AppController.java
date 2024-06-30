package com.example.javafx_applikasidataanaksm;

import com.example.javafx_applikasidataanaksm.components.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

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
    private TableColumn<Anak, ?> table_anak_id_anak;

    @FXML
    private TableColumn<Anak, ?> table_anak_nama_anak;

    @FXML
    private TableColumn<Anak, ?> table_anak_gender_anak;

    @FXML
    private TableColumn<Anak, ?> table_anak_tanggal_lahir;

    @FXML
    private TableColumn<Anak, ?> table_anak_alamat;

    @FXML
    private TableColumn<Anak, ?> table_anak_nama_orangtua;

    @FXML
    private TableColumn<Anak, ?> table_anak_no_telp;

    @FXML
    private TableView<Guru> table_guru;

    @FXML
    private TableColumn<Guru, ?> table_guru_id_guru;

    @FXML
    private TableColumn<Guru, ?> table_guru_nama_guru;

    @FXML
    private TableColumn<Guru, ?> table_guru_alamat_guru;

    @FXML
    private TableColumn<Guru, ?> table_guru_no_telp;

    @FXML
    private TableView<Kelas> table_kelas;

    @FXML
    private TableColumn<Kelas, ?> table_kelas_id_kelas;

    @FXML
    private TableColumn<Kelas, ?> table_kelas_nama_kelas;

    @FXML
    private TableView<Kehadiran> table_kehadiran;

    @FXML
    private TableColumn<Kehadiran, ?> table_kehadiran_id_kehadiran;

    @FXML
    private TableColumn<Kehadiran, ?> table_kehadiran_tanggal_kebaktian;

    @FXML
    private TableColumn<Kehadiran, ?> table_kehadiran_judul_kebaktian;

    @FXML
    private TableColumn<Kehadiran, ?> table_kehadiran_nama_kehadiran;

    @FXML
    private TableColumn<Kehadiran, ?> table_kehadiran_kehadiran;

    @FXML
    private TableView<Kebaktian> table_kebaktian;

    @FXML
    private TableColumn<Kebaktian, ?> table_kebaktian_no_kebaktian;

    @FXML
    private TableColumn<Kebaktian, ?> table_kebaktian_tanggal_kebaktian;

    @FXML
    private TableColumn<Kebaktian, ?> table_kebaktian_judul_kebaktian;

    @FXML
    private TableColumn<Kebaktian, ?> table_kebaktian_laki_kebaktian;

    @FXML
    private TableColumn<Kebaktian, ?> table_kebaktian_perempuan_kebaktian;

    @FXML
    private TableColumn<Kebaktian, ?> table_kebaktian_total_kehadiran;

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

    @FXML
    public void initialize() {
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
    }

    public void handleButtonMenuClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        resetButtonBackgrounds();
        clickedButton.setStyle("-fx-background-color: #1f3341;");
        buttonId = clickedButton.getId();
        updateTableViewVisibility();
    }

    private void updateTableViewVisibility() {
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

}
