package com.example.javafx_applikasidataanaksm;

import com.example.javafx_applikasidataanaksm.controllers.TahunAjaranController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DataSekolahMingguApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader appLoader = new FXMLLoader(DataSekolahMingguApplication.class.getResource("app-view.fxml"));
        Scene scene = new Scene(appLoader.load());
        DataSekolahMingguController dataSekolahMingguController = appLoader.getController();
        stage.setTitle("Aplikasi Data Anak Sekolah Minggu");
        stage.setScene(scene);
        stage.show();

        FXMLLoader tahunAjaranLoader = new FXMLLoader(DataSekolahMingguApplication.class.getResource("tahun_ajaran-view.fxml"));
        Scene tahunAjaranScene = new Scene(tahunAjaranLoader.load());
        TahunAjaranController tahunAjaranController = tahunAjaranLoader.getController();
        Stage tahunAjaranStage = new Stage();
        tahunAjaranStage.setTitle("Pilih Tahun Ajaran");
        tahunAjaranStage.setScene(tahunAjaranScene);
        tahunAjaranStage.hide();

        dataSekolahMingguController.setTahunAjaranStage(tahunAjaranStage);
        dataSekolahMingguController.setTahunAjaranController(tahunAjaranController);
        tahunAjaranController.setDataSekolahMingguController(dataSekolahMingguController);
    }

    public static void main(String[] args) {
        launch();
    }
}