package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class Anak {
    private Integer id_anak;
    private String nama_anak;
    private String gender;
    private Date tanggal_lahir;

    public Anak(Integer id_anak, String nama_anak, String gender, Date tanggal_lahir) {
        this.id_anak = id_anak;
        this.nama_anak = nama_anak;
        this.gender = gender;
        this.tanggal_lahir = tanggal_lahir;
    }

    public Integer getId_anak() {
        return id_anak;
    }

    public void setId_anak(Integer id_anak) {
        this.id_anak = id_anak;
    }

    public String getNama_anak() {
        return nama_anak;
    }

    public void setNama_anak(String nama_anak) {
        this.nama_anak = nama_anak;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }
}
