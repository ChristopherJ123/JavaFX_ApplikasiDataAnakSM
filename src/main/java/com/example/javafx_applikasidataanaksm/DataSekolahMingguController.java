package com.example.javafx_applikasidataanaksm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

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
    private TableView<?> table;

    @FXML
    private Button tambahKelasBtn;

    @FXML
    private Button tambahPesertaBtn;

    @FXML
    private Button tampilkanKelasBtn;

    @FXML
    public void initialize() {
        dropDownMenu.getItems().addAll(
                "Option 1",
                "Option 2",
                "Option 3"
        );
        dropDownMenu.getItems().add("Option 4");
        dropDownMenu.setValue("Pilih kelas");
    }
}