package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class GuruKelas {
    private int idKelas;
    private int idGuru;
    private Date createdAt;
    private String namaGuru;
    private String namaKelas;

    public GuruKelas(int idKelas, int idGuru, Date createdAt, String namaGuru, String namaKelas) {
        this.idKelas = idKelas;
        this.idGuru = idGuru;
        this.createdAt = createdAt;
        this.namaGuru = namaGuru;
        this.namaKelas = namaKelas;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public int getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(int idGuru) {
        this.idGuru = idGuru;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
}
