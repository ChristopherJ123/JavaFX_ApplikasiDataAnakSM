package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class Guru {
    private Integer id_guru;
    private String nama_guru;
    private String alamat;
    private String no_telp_guru;
    private Date created_at;

    public Guru(Integer id_guru, String nama_guru, String alamat, String no_telp_guru, Date created_at) {
        this.id_guru = id_guru;
        this.nama_guru = nama_guru;
        this.alamat = alamat;
        this.no_telp_guru = no_telp_guru;
        this.created_at = created_at;
    }

    public Integer getId_guru() {
        return id_guru;
    }

    public void setId_guru(Integer id_guru) {
        this.id_guru = id_guru;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp_guru() {
        return no_telp_guru;
    }

    public void setNo_telp_guru(String no_telp_guru) {
        this.no_telp_guru = no_telp_guru;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
