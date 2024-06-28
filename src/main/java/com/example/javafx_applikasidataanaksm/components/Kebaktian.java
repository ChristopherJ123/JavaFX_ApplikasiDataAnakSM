package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class Kebaktian {
    private Integer id_kebaktian;
    private String nama_kebaktian;
    private Date tanggal_kebaktian;

    public Kebaktian(Integer id_kebaktian, String nama_kebaktian, Date tanggal_kebaktian) {
        this.id_kebaktian = id_kebaktian;
        this.nama_kebaktian = nama_kebaktian;
        this.tanggal_kebaktian = tanggal_kebaktian;
    }

    public Integer getId_kebaktian() {
        return id_kebaktian;
    }

    public void setId_kebaktian(Integer id_kebaktian) {
        this.id_kebaktian = id_kebaktian;
    }

    public String getNama_kebaktian() {
        return nama_kebaktian;
    }

    public void setNama_kebaktian(String nama_kebaktian) {
        this.nama_kebaktian = nama_kebaktian;
    }

    public Date getTanggal_kebaktian() {
        return tanggal_kebaktian;
    }

    public void setTanggal_kebaktian(Date tanggal_kebaktian) {
        this.tanggal_kebaktian = tanggal_kebaktian;
    }
}
