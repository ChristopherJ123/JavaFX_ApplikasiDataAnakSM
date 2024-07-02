package com.example.javafx_applikasidataanaksm.components;

import java.util.Date;

public class Kehadiran {
    private int id_kehadiran;
    private int status_kehadiran;
    private int id_kebaktian;
    private int id_anak;
    private String nama_anak;
    private String nama_kebaktian;
    private Date tanggal_kebaktian;
    private String deskripsi;

    public Kehadiran(int id_kehadiran, int status_kehadiran, int id_kebaktian, int id_anak,
                     String nama_anak, String nama_kebaktian, Date tanggal_kebaktian,
                     String deskripsi) {
        this.id_kehadiran = id_kehadiran;
        this.status_kehadiran = status_kehadiran;
        this.id_kebaktian = id_kebaktian;
        this.id_anak = id_anak;
        this.nama_anak = nama_anak;
        this.nama_kebaktian = nama_kebaktian;
        this.tanggal_kebaktian = tanggal_kebaktian;
        this.deskripsi = deskripsi;
    }

    public int getId_kehadiran() {
        return id_kehadiran;
    }

    public void setId_kehadiran(int id_kehadiran) {
        this.id_kehadiran = id_kehadiran;
    }

    public int getStatus_kehadiran() {
        return status_kehadiran;
    }

    public boolean getStatus(){
        return status_kehadiran == 1;
    }

    public void setStatus_kehadiran(int status_kehadiran) {
        this.status_kehadiran = status_kehadiran;
    }

    public int getId_kebaktian() {
        return id_kebaktian;
    }

    public void setId_kebaktian(int id_kebaktian) {
        this.id_kebaktian = id_kebaktian;
    }

    public int getId_anak() {
        return id_anak;
    }

    public void setId_anak(int id_anak) {
        this.id_anak = id_anak;
    }

    public String getNama_anak() {
        return nama_anak;
    }

    public void setNama_anak(String nama_anak) {
        this.nama_anak = nama_anak;
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

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

