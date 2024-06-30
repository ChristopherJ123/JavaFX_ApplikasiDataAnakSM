package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class GuruKelas {
    private Integer id_kelas;
    private Integer id_guru;
    private Date created_at;

    public GuruKelas(Integer id_kelas, Integer id_guru, Date created_at) {
        this.id_kelas = id_kelas;
        this.id_guru = id_guru;
        this.created_at = created_at;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
