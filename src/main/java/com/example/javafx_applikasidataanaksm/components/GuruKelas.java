package com.example.javafx_applikasidataanaksm.components;

public class GuruKelas {
    private Integer id_kelas;
    private Integer id_guru;
    private Integer id_kelas_guru;

    public GuruKelas(Integer id_kelas, Integer id_guru, Integer id_kelas_guru) {
        this.id_kelas = id_kelas;
        this.id_guru = id_guru;
        this.id_kelas_guru = id_kelas_guru;
    }

    public Integer getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(Integer id_kelas) {
        this.id_kelas = id_kelas;
    }

    public Integer getId_guru() {
        return id_guru;
    }

    public void setId_guru(Integer id_guru) {
        this.id_guru = id_guru;
    }

    public Integer getId_kelas_guru() {
        return id_kelas_guru;
    }

    public void setId_kelas_guru(Integer id_kelas_guru) {
        this.id_kelas_guru = id_kelas_guru;
    }
}
