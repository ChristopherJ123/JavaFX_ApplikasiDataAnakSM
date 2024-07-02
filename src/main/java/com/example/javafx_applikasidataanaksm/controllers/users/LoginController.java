package com.example.javafx_applikasidataanaksm.controllers.users;

import com.example.javafx_applikasidataanaksm.AppApplication;
import com.example.javafx_applikasidataanaksm.DataAnakSMApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    private DatabaseHandler dbHandler;

    @FXML
    public void initialize() {
        dbHandler = new DatabaseHandler();
    }

    @FXML
    private void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (dbHandler.login(username, password)) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Success");
            alert.setHeaderText(null);
            alert.setContentText("Welcome " + username);
            alert.showAndWait();

            FXMLLoader appLoader = new FXMLLoader(DataAnakSMApplication.class.getResource("data_anak_sm-view.fxml"));
            Scene scene = new Scene(appLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Aplikasi Data Anak Sekolah Minggu");
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleRegister() {
        try {
            DataAnakSMApplication.showRegisterPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


