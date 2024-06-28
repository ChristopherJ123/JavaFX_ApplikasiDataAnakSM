package com.example.javafx_applikasidataanaksm.components;

public class Guru {
    private Integer id_guru;
    private String nama_guru;

    public Guru(Integer id_guru, String nama_guru) {
        this.id_guru = id_guru;
        this.nama_guru = nama_guru;
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
}
