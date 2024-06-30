package com.example.javafx_applikasidataanaksm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader appLoader = new FXMLLoader(this.getClass().getResource("app-view.fxml"));
        Scene scene = new Scene(appLoader.load());
        stage.setTitle("Aplikasi Data Anak Sekolah Minggu");
        stage.setScene(scene);
        stage.show();
    }
}
