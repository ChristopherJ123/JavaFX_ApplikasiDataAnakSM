package com.example.javafx_applikasidataanaksm.controllers.users;

import com.example.javafx_applikasidataanaksm.DataAnakSMApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (dbHandler.login(username, password)) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Success");
            alert.setHeaderText(null);
            alert.setContentText("Welcome " + username);
            alert.showAndWait();
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


