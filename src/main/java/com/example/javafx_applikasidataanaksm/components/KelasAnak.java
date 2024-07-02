package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class KelasAnak {
    private int id_anak;
    private int id_kelas;
    private Date created_at;
    private String nama_anak;
    private String nama_kelas;

    public KelasAnak(int id_anak, int idKelas, Date created_at, String nama_anak, String nama_kelas) {
        this.id_anak = id_anak;
        this.id_kelas = idKelas;
        this.created_at = created_at;
        this.nama_anak = nama_anak;
        this.nama_kelas = nama_kelas;
    }

    public int getId_anak() {
        return id_anak;
    }

    public void setId_anak(int id_anak) {
        this.id_anak = id_anak;
    }

    public int getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(int id_kelas) {
        this.id_kelas = id_kelas;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getNama_anak() {
        return nama_anak;
    }

    public void setNama_anak(String nama_anak) {
        this.nama_anak = nama_anak;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }
}

