/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.hibernate_training;

import com.gmail.asboyo.hibernate_training.model.Employee;
import com.gmail.asboyo.hibernate_training.util.HibernateUtil;
import java.sql.Timestamp;
import java.util.List;
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
        //updatePegawai(session);
        //updatePegawaiDua(session);
        //deletePegawai(session);
        List<Employee> listPegawai = getListPegawai(session);
        for(Employee employee : listPegawai){
            System.out.println(employee.getNama());
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
    private static Integer simpanPegawai(Session session){
        Employee emp = new Employee();
        emp.setNama("Erazor Djinn");
        emp.setAlamat("jln purwodadi");
        emp.setIdEntry("user4");
        emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
        return (Integer) session.save(emp);
    }
    
    private static String getNativeQuery(Session session, String sql){
        return(String) session.createNativeQuery(sql).getSingleResult();
    }
    
    private static List<Employee> getListPegawai(Session session){
        return session.createQuery("select p from Employee p").getResultList();
    }
    //update Pegawai berdasarkan ID
    private static void updatePegawai(Session session){
        Employee emp = session.find(Employee.class, 2);
        emp.setNama("UPDATED GUY");
        emp.setAlamat("UPDATED ROAD");
        emp.setIdEntry("user1");
        emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
        session.update(emp);
    }
    //update pegawai berdasarkan parameter
    private static int updatePegawaiDua(Session session){
        return session.createQuery("update Employee set nama = :nama where id = :id")
                .setParameter("nama","nama update hql")
                .setParameter("id",1).executeUpdate();
    }
    private static void deletePegawai(Session session){
        Employee emp = session.find(Employee.class,2);
        session.delete(emp);
    }
    
}
