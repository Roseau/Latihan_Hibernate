/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.hibernate_training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author St0rm
 */
@Entity
@Table(name="pegawai", schema="public")
public class Employee extends BaseClass {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // membuat id menjadi auto generated
    @Column(name="id", updatable= false, nullable = false) // nullable berarti tidak boleh null
    private int id;
    
    @Column(name="nama", length=50)//panjang dari input yang dimasukkan
    private String nama;
    
    @Column(name="alamat", length=150)
    private String alamat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}
