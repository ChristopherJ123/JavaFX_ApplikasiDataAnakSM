package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class Anak {
    private Integer id_anak;
    private String nama_anak;
    private String gender;
    private Date tanggal_lahir;
    private String nama_orang_tua;
    private String no_telp_orang_tua;
    private String alamat;
    private Date created_at;

    public Anak(Integer id_anak, String nama_anak, String gender, Date tanggal_lahir, Date created_at) {
        this.id_anak = id_anak;
        this.nama_anak = nama_anak;
        this.gender = gender;
        this.tanggal_lahir = tanggal_lahir;
        this.created_at = created_at;
    }

    public Anak(Integer id_anak, String nama_anak, String gender, Date tanggal_lahir, String nama_orang_tua, String no_telp_orang_tua, String alamat, Date created_at) {
        this.id_anak = id_anak;
        this.nama_anak = nama_anak;
        this.gender = gender;
        this.tanggal_lahir = tanggal_lahir;
        this.nama_orang_tua = nama_orang_tua;
        this.no_telp_orang_tua = no_telp_orang_tua;
        this.alamat = alamat;
        this.created_at = created_at;
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

    public String getNama_orang_tua() {
        return nama_orang_tua;
    }

    public void setNama_orang_tua(String nama_orang_tua) {
        this.nama_orang_tua = nama_orang_tua;
    }

    public String getNo_telp_orang_tua() {
        return no_telp_orang_tua;
    }

    public void setNo_telp_orang_tua(String no_telp_orang_tua) {
        this.no_telp_orang_tua = no_telp_orang_tua;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
