package com.example.javafx_applikasidataanaksm.components;

public class Kelas {
    private Integer id_kelas;
    private String nama_kelas;
    private Integer id_tahun_ajaran;

    public Kelas(Integer id_kelas, String nama_kelas, Integer id_tahun_ajaran) {
        this.id_kelas = id_kelas;
        this.nama_kelas = nama_kelas;
        this.id_tahun_ajaran = id_tahun_ajaran;
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

    public Integer getId_tahun_ajaran() {
        return id_tahun_ajaran;
    }

    public void setId_tahun_ajaran(Integer id_tahun_ajaran) {
        this.id_tahun_ajaran = id_tahun_ajaran;
    }
}
