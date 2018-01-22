/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.hibernate_training;

import com.gmail.asboyo.hibernate_training.model.Employee;
import com.gmail.asboyo.hibernate_training.util.HibernateUtil;
import java.sql.Timestamp;
import org.hibernate.Session;

/**
 *
 * @author St0rm
 */
public class MainProgram {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String result = getNativeQuery(session, "select version()");
        System.out.println(result);
        
        simpanPegawai(session);
        
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
    private static Integer simpanPegawai(Session session){
        Employee emp = new Employee();
        emp.setNama("Carter");
        emp.setAlamat("jln Gowa");
        emp.setIdEntry("user1");
        emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
        return (Integer) session.save(emp);
    }
    
    private static String getNativeQuery(Session session, String sql){
        return(String) session.createNativeQuery(sql).getSingleResult();
    }
}
