/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Hibernate.HibernateUtil;
import Pojos.UserRegistration;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserRegistrationController {

    private UserRegistrationController() {
    }
    private static final UserRegistrationController urc = new UserRegistrationController();

    public static UserRegistrationController getInstance() {
        return urc;
    }

    public void Save(UserRegistration obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();
    }

    public void Update(UserRegistration obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(obj);
        tx.commit();
        session.close();
    }

    public void Delete(UserRegistration obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public List Load() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<UserRegistration> List = new ArrayList<UserRegistration>();
        List = session.createCriteria(UserRegistration.class).list();
        tx.commit();
        session.close();

        return List;
    }
}
