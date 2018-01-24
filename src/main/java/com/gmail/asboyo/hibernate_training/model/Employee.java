/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.hibernate_training.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author St0rm
 */
@Entity
@Table(name="pegawai", schema="public")//optional, bila tidak ada, nama kelas akan dibuatkan, biasanya dengan huruf kecil
public class Employee extends BaseClass {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // membuat id menjadi auto generated(dapat dirubah sesuai kebutuhan, bila ingin custom, bisa menggunakan class)
    @Column(name="id", updatable= false, nullable = false) // nullable berarti tidak boleh null
    private int id;
    
    @Column(name="nama", length=50)//panjang dari input yang dimasukkan
    private String nama;
    
    @Column(name="alamat", length=150)
    private String alamat;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dept")
    private Department department;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "employee")
    private Set<Task> listTask;
    
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Task> getListTask() {
        return listTask;
    }

    public void setListTask(Set<Task> listTask) {
        this.listTask = listTask;
    }
    
    
    
}
