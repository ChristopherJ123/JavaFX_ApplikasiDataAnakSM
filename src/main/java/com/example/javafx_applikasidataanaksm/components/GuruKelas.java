package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class GuruKelas {
    private int id_kelas;
    private int id_guru;
    private Date created_at;
    private String nama_guru;
    private String nama_kelas;

    public GuruKelas(int id_kelas, int id_guru, Date created_at, String nama_guru, String nama_kelas) {
        this.id_kelas = id_kelas;
        this.id_guru = id_guru;
        this.created_at = created_at;
        this.nama_guru = nama_guru;
        this.nama_kelas = nama_kelas;
    }

    public int getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(int id_kelas) {
        this.id_kelas = id_kelas;
    }

    public int getId_guru() {
        return id_guru;
    }

    public void setId_guru(int id_guru) {
        this.id_guru = id_guru;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }
}
