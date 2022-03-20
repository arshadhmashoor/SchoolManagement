/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Hibernate.HibernateUtil;
import Pojos.Assignment;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AssignmentController {

    private AssignmentController() {
    }
    private static final AssignmentController ac = new AssignmentController();

    public static AssignmentController getInstance() {
        return ac;
    }

    public void Save(Assignment obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();
    }

    public void Update(Assignment obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(obj);
        tx.commit();
        session.close();
    }

    public void Delete(Assignment obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public List Load() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Assignment> List = new ArrayList<Assignment>();
        List = session.createCriteria(Assignment.class).list();
        tx.commit();
        session.close();

        return List;
    }

    public List LoadByClassLevel(Assignment obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Assignment E WHERE E.classLevel = '" + obj.getClassLevel() + "'";
        List<Assignment> List = new ArrayList<Assignment>();
        Query query = session.createQuery(hql);
        List = query.list();
        tx.commit();
        session.close();

        return List;
    }
}
