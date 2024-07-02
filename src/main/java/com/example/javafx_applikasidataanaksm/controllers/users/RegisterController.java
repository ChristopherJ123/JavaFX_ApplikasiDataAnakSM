package com.example.javafx_applikasidataanaksm.controllers.users;


import com.example.javafx_applikasidataanaksm.DataAnakSMApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegisterController {
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
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (dbHandler.register(username, password)) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Registration Success");
            alert.setHeaderText(null);
            alert.setContentText("User registered successfully.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Registration Failed");
            alert.setHeaderText(null);
            alert.setContentText("Registration failed. Username might be taken.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBackToLogin() {
        try {
            DataAnakSMApplication.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

