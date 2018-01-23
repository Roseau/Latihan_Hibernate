/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.hibernate_training.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author St0rm
 */
@Entity
@Table(name="Departemen", schema="public")
public class Department extends BaseClass {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_dept", updatable= false, nullable = false)
    private int id_departement;
    
    @Column(name="nama_dept", length = 160)
    private String namaDepartment;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
    private Employee employee;

    public Integer getId_departement() {
        return id_departement;
    }

    public void setId_departement(Integer id_departement) {
        this.id_departement = id_departement;
    }

    public String getNama() {
        return namaDepartment;
    }

    public void setNama(String nama) {
        this.namaDepartment = nama;
    }
    
    public Employee getEmployee(){
        return this.employee;
    }
    
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
}
