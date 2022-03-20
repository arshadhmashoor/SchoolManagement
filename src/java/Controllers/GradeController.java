/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Hibernate.Connector;
import Hibernate.HibernateUtil;
import Pojos.Grade;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class GradeController {

    Connector a = new Connector();

    private GradeController() {
    }

    private static final GradeController gc = new GradeController();

    public static GradeController getInstance() {
        return gc;
    }

    public void Save(Grade obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();
    }

    public void Update(Grade obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(obj);
        tx.commit();
        session.close();
    }

    public void UpdateFeedback(Grade obj) throws Exception {
        a.getConnection();
        a.aud("UPDATE grade SET student_feedback='" + obj.getStudentFeedback() + "' WHERE grade_id='" + obj.getGradeId() + "'");
    }

    public void DeleteFeedback(Grade obj) throws Exception {
        a.getConnection();
        a.aud("UPDATE grade SET student_feedback='' WHERE grade_id='" + obj.getGradeId() + "'");
    }

    public void Delete(Grade obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public List Load() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Grade> List = new ArrayList<Grade>();
        List = session.createCriteria(Grade.class).list();
        tx.commit();
        session.close();

        return List;
    }

    public List LoadByStudentID(Grade obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Grade E WHERE E.studentId = '" + obj.getStudentId() + "'";
        List<Grade> List = new ArrayList<Grade>();
        Query query = session.createQuery(hql);
        List = query.list();
        tx.commit();
        session.close();

        return List;
    }
}
