/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Hibernate.HibernateUtil;
import Pojos.AssignmentSubmission;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AssignmentSubmissionController {

    private AssignmentSubmissionController() {
    }
    private static final AssignmentSubmissionController asc = new AssignmentSubmissionController();

    public static AssignmentSubmissionController getInstance() {
        return asc;
    }
    
    public void Save(AssignmentSubmission obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();
    }

    public void Update(AssignmentSubmission obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(obj);
        tx.commit();
        session.close();
    }

    public void Delete(AssignmentSubmission obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public List Load() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<AssignmentSubmission> List = new ArrayList<AssignmentSubmission>();
        List = session.createCriteria(AssignmentSubmission.class).list();
        tx.commit();
        session.close();

        return List;
    }
}
