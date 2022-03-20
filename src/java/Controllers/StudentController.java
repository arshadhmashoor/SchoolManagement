/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Hibernate.HibernateUtil;
import Pojos.Student;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StudentController {

    private StudentController() {
    }
    private static final StudentController sc = new StudentController();

    public static StudentController getInstance() {
        return sc;
    }

    public void Save(Student obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();
    }

    public void Update(Student obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(obj);
        tx.commit();
        session.close();
    }

    public void Delete(Student obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public List Load() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Student> List = new ArrayList<Student>();
        List = session.createCriteria(Student.class).list();
        tx.commit();
        session.close();

        return List;
    }
    public List LoadbyID(Student obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Student E WHERE E.studentId = '" + obj.getStudentId() + "'";
        List<Student> List = new ArrayList<Student>();
        Query query = session.createQuery(hql);
        List = query.list();
        tx.commit();
        session.close();

        return List;
    }
}
