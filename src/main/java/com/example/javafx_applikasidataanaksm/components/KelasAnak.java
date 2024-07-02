package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class KelasAnak {
    private int idAnak;
    private int idKelas;
    private Date createdAt;
    private String namaAnak;
    private String namaKelas;

    public KelasAnak(int idAnak, int idKelas, Date createdAt, String namaAnak, String namaKelas) {
        this.idAnak = idAnak;
        this.idKelas = idKelas;
        this.createdAt = createdAt;
        this.namaAnak = namaAnak;
        this.namaKelas = namaKelas;
    }

    public int getIdAnak() {
        return idAnak;
    }

    public void setIdAnak(int idAnak) {
        this.idAnak = idAnak;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getNamaAnak() {
        return namaAnak;
    }

    public void setNamaAnak(String namaAnak) {
        this.namaAnak = namaAnak;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
}

