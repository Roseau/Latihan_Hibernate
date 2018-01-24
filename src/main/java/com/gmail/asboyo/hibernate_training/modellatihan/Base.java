/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.hibernate_training.modellatihan;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import org.hibernate.engine.jdbc.SerializableBlobProxy;

/**
 *
 * @author St0rm
 */
@MappedSuperclass
public class Base implements Serializable {
    @Column(name="id_update", length = 30)
    private String id_update;
    
    @Column(name="d_update")
    private Timestamp d_update;
    
    @Column(name="d_entry")
    private Timestamp d_entry;
    
    @Column(name="id_entry", length = 30)
    private String id_entry;

    public String getId_update() {
        return id_update;
    }

    public void setId_update(String id_update) {
        this.id_update = id_update;
    }

    public Timestamp getD_update() {
        return d_update;
    }

    public void setD_update(Timestamp d_update) {
        this.d_update = d_update;
    }

    public Timestamp getD_entry() {
        return d_entry;
    }

    public void setD_entry(Timestamp d_entry) {
        this.d_entry = d_entry;
    }

    public String getId_entry() {
        return id_entry;
    }

    public void setId_entry(String id_entry) {
        this.id_entry = id_entry;
    }
}
