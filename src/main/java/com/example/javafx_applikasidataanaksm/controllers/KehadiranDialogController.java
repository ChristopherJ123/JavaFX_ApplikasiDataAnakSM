package com.example.javafx_applikasidataanaksm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class KehadiranDialogController {

    @FXML
    private Label text_lable;

    @FXML
    private ComboBox<?> field_id_anak;

    @FXML
    private ComboBox<?> field_id_kebaktian;

    @FXML
    private ToggleGroup status;

    @FXML
    private RadioButton field_hadir;

    @FXML
    private RadioButton field_tidak_hadir;

    @FXML
    private Pane add;
}