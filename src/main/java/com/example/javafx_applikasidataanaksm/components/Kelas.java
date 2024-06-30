package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class Kelas {
    private Integer id_kelas;
    private String nama_kelas;
    private Date created_at;

    public Kelas(Integer id_kelas, String nama_kelas, Date created_at) {
        this.id_kelas = id_kelas;
        this.nama_kelas = nama_kelas;
        this.created_at = created_at;
    }

    public Integer getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(Integer id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
