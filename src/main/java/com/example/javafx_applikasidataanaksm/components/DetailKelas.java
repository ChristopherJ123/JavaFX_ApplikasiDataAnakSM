package com.example.javafx_applikasidataanaksm.components;

public class DetailKelas {
    private Integer id_anak;
    private Integer id_kelas;

    public DetailKelas(Integer id_anak, Integer id_kelas) {
        this.id_anak = id_anak;
        this.id_kelas = id_kelas;
    }

    public Integer getId_anak() {
        return id_anak;
    }

    public void setId_anak(Integer id_anak) {
        this.id_anak = id_anak;
    }

    public Integer getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(Integer id_kelas) {
        this.id_kelas = id_kelas;
    }
}
