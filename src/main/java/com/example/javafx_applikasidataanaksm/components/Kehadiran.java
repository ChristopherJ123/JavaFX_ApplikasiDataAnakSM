package com.example.javafx_applikasidataanaksm.components;

import java.util.Date;

public class Kehadiran {
    private int idKehadiran;
    private int statusKehadiran;
    private int idKebaktian;
    private int idAnak;
    private String namaAnak;
    private String namaKebaktian;
    private Date tanggalKebaktian;
    private String deskripsi;

    public Kehadiran(int idKehadiran, int statusKehadiran, int idKebaktian, int idAnak,
                     String namaAnak, String namaKebaktian, Date tanggalKebaktian,
                     String deskripsi) {
        this.idKehadiran = idKehadiran;
        this.statusKehadiran = statusKehadiran;
        this.idKebaktian = idKebaktian;
        this.idAnak = idAnak;
        this.namaAnak = namaAnak;
        this.namaKebaktian = namaKebaktian;
        this.tanggalKebaktian = tanggalKebaktian;
        this.deskripsi = deskripsi;
    }

    public int getIdKehadiran() {
        return idKehadiran;
    }

    public void setIdKehadiran(int idKehadiran) {
        this.idKehadiran = idKehadiran;
    }

    public int getStatusKehadiran() {
        return statusKehadiran;
    }
    public boolean getStatus(){
        return statusKehadiran == 1;
    }

    public void setStatusKehadiran(int statusKehadiran) {
        this.statusKehadiran = statusKehadiran;
    }

    public int getIdKebaktian() {
        return idKebaktian;
    }

    public void setIdKebaktian(int idKebaktian) {
        this.idKebaktian = idKebaktian;
    }

    public int getIdAnak() {
        return idAnak;
    }

    public void setIdAnak(int idAnak) {
        this.idAnak = idAnak;
    }

    public String getNamaAnak() {
        return namaAnak;
    }

    public void setNamaAnak(String namaAnak) {
        this.namaAnak = namaAnak;
    }

    public String getNamaKebaktian() {
        return namaKebaktian;
    }

    public void setNamaKebaktian(String namaKebaktian) {
        this.namaKebaktian = namaKebaktian;
    }

    public Date getTanggalKebaktian() {
        return tanggalKebaktian;
    }

    public void setTanggalKebaktian(Date tanggalKebaktian) {
        this.tanggalKebaktian = tanggalKebaktian;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

