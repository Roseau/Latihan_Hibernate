/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.hibernate_training;

import com.gmail.asboyo.hibernate_training.model.Alamat;
import com.gmail.asboyo.hibernate_training.model.Department;
import com.gmail.asboyo.hibernate_training.model.Employee;
import com.gmail.asboyo.hibernate_training.model.Kecamatan;
import com.gmail.asboyo.hibernate_training.model.Student;
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
        System.out.println("Menapilkan Result! : ");
        System.out.println(result);
        
        //simpanPegawai(session);
        //updatePegawai(session);
        //updatePegawaiDua(session);
        //deletePegawai(session);
//        simpanStudent(session);
//        List<Employee> listPeg = getListPegawaiDanDept(session);
//        for(Employee employee : listPeg){
//            System.out.println(employee.getNama()+"  dept "+employee.getDepartment().getNama());
//        }
//        List<Department> listDept = getListDepartmentDanPeg(session);
//        for(Department department : listDept){
//            System.out.println(department.getNama()+"  employee "+department.getEmployee().getNama());
//        }
//        List<Employee> listPegawai = getListPegawai(session);
//        for(Employee employee : listPegawai){
//            System.out.println(employee.getNama());
//        }
//        session.getTransaction().commit();
        //mengambil list student
//        List<Student> listStudent = getListFromStudent(session);
//        for(Student student : listStudent){
//            System.out.println(student.getNama()+"  alamat "+student.getAlamat().getNama()+"  kecamatan "+student.getAlamat().getKecamatan().getNama());
//        }
        //mengambil list alamat
//        List<Alamat> listAlamat = getListFromAlamat(session);
//        for(Alamat alamat : listAlamat){
//            System.out.println(alamat.getNama()+"  Student "+alamat.getStudent().getNama()+"  kecamatan "+alamat.getKecamatan().getNama());
//        }
        //mengambil list kecamatan
        List<Kecamatan> listKecamatan = getListFromKecamatan(session);
        for(Kecamatan kec : listKecamatan){
            System.out.println(kec.getNama()+"  alamat "+kec.getAlamat().getNama()+"  student "+kec.getAlamat().getStudent().getNama());
        }
        session.close();
        HibernateUtil.shutdown();
        //System.out.println(student.getNama()+" "+student.getAlamat().getNama()+" "+student.getAlamat().getKecamatan().getNama());      
    }
    private static Integer simpanPegawai(Session session){
        Department dep = new Department();
        dep.setNama("DIV IT");
        dep.setIdEntry("userdept");
        dep.setTglEntry(new Timestamp(System.currentTimeMillis()));
        Employee emp = new Employee();
        emp.setNama("Peter J. Clapton");
        emp.setAlamat("jln nugini");
        emp.setIdEntry("user5");
        emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
        emp.setDepartment(dep);
        return (Integer) session.save(emp);
    }
    //latihan kecamatan, student, alamat
    private static Integer simpanStudent(Session session){
        Kecamatan kec = new Kecamatan();
        kec.setNama("Kecamatan oompaloompa");
        Alamat a = new Alamat();
        a.setNama("Jalan pembalasan");
        a.setKecamatan(kec);
        Student student = new Student();
        student.setNama("DIO");
        student.setAlamat(a);
        student.setIdEntry("stu02");
        student.setTglEntry(new Timestamp(System.currentTimeMillis()));
        return (Integer) session.save(student);
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
    private static List<Employee> getListPegawaiDanDept(Session session){
        return session.createQuery("select p from Employee p JOIN FETCH p.department").getResultList();
    }
    private static List<Department> getListDepartmentDanPeg(Session session){
        return session.createQuery("select d from Department d JOIN FETCH d.employee").getResultList();
    }
    
    private static List<Student> getListFromStudent(Session session){
        return session.createQuery("Select s from Student s JOIN FETCH s.alamat").getResultList();
    }
    
    private static List<Alamat> getListFromAlamat(Session session){
        return session.createQuery("Select a from Alamat a JOIN FETCH a.student").getResultList();
    }
    
    private static List<Alamat> getListFromAlamatKecamatan(Session session){
        return session.createQuery("Select a from Alamat a JOIN FETCH a.kecamatan").getResultList();
    }
    
    private static List<Kecamatan> getListFromKecamatan(Session session){
        return session.createQuery("Select k from Kecamatan k JOIN FETCH k.alamat").getResultList();
    }
}
