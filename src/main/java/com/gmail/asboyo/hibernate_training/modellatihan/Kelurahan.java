/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.hibernate_training.modellatihan;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author St0rm
 */
@Entity
@Table(name = "m_kelurahan", schema = "public")
public class Kelurahan extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kelurahan", updatable = false, nullable = false)
    private long id;
    
    @Column(name = "nm_kelurahan", length = 75)
    private String namaKelurahan;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kec")
    private Kecamatan_ kecamatan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }

    public Kecamatan_ getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(Kecamatan_ kecamatan) {
        this.kecamatan = kecamatan;
    }
    
}
