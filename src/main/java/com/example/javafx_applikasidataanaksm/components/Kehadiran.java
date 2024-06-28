package com.example.javafx_applikasidataanaksm.components;

public class Kehadiran {
    private Integer id_kehadiran;
    private Integer status_kehadiran;
    private Integer id_kebaktian;
    private Integer id_anak;

    public Kehadiran(Integer id_kehadiran, Integer status_kehadiran, Integer id_kebaktian, Integer id_anak) {
        this.id_kehadiran = id_kehadiran;
        this.status_kehadiran = status_kehadiran;
        this.id_kebaktian = id_kebaktian;
        this.id_anak = id_anak;
    }

    public Integer getId_kehadiran() {
        return id_kehadiran;
    }

    public void setId_kehadiran(Integer id_kehadiran) {
        this.id_kehadiran = id_kehadiran;
    }

    public Integer getStatus_kehadiran() {
        return status_kehadiran;
    }

    public void setStatus_kehadiran(Integer status_kehadiran) {
        this.status_kehadiran = status_kehadiran;
    }

    public Integer getId_kebaktian() {
        return id_kebaktian;
    }

    public void setId_kebaktian(Integer id_kebaktian) {
        this.id_kebaktian = id_kebaktian;
    }

    public Integer getId_anak() {
        return id_anak;
    }

    public void setId_anak(Integer id_anak) {
        this.id_anak = id_anak;
    }
}
