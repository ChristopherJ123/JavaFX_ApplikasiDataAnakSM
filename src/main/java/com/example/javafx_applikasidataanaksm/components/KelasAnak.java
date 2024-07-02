package com.example.javafx_applikasidataanaksm.components;

import java.sql.Date;

public class KelasAnak {
    private Integer id_anak;
    private Integer id_kelas;
    private Date created_at;

    public KelasAnak(Integer id_anak, Integer id_kelas, Date created_at) {
        this.id_anak = id_anak;
        this.id_kelas = id_kelas;
        this.created_at = created_at;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
