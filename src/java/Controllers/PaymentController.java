
package Controllers;

import Hibernate.HibernateUtil;
import Pojos.Payment;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PaymentController {

    private PaymentController() {
    }
    private static final PaymentController pc = new PaymentController();

    public static PaymentController getInstance() {
        return pc;
    }

    public void Save(Payment obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();
    }

    public void Update(Payment obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(obj);
        tx.commit();
        session.close();
    }

    public void Delete(Payment obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public List Load() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Payment> List = new ArrayList<Payment>();
        List = session.createCriteria(Payment.class).list();
        tx.commit();
        session.close();

        return List;
    }
}
