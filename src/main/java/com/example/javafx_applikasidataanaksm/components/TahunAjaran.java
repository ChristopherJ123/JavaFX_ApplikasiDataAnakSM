package com.example.javafx_applikasidataanaksm.components;

public class TahunAjaran {
    private int id_tahun_ajaran;
    private int tahun;

    public TahunAjaran(int id, int year) {
        this.id_tahun_ajaran = id;
        this.tahun = year;
    }

    public int getId_tahun_ajaran() {
        return id_tahun_ajaran;
    }

    public void setId_tahun_ajaran(int id_tahun_ajaran) {
        this.id_tahun_ajaran = id_tahun_ajaran;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
}
