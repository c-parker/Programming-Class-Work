package goldenoaks.data;

import goldenoaks.business.Checkout;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class CheckoutDb {

    public static void checkoutBook(Checkout checkout) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(checkout);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static List<Checkout> selectCheckedOutBooks() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c from Checkout c";
        TypedQuery<Checkout> q = em.createQuery(qString, Checkout.class);
        List<Checkout> checkouts;
        try {
            checkouts = q.getResultList();
            if (checkouts == null || checkouts.isEmpty()) {
                checkouts = null;
            }
        } finally {
            em.close();
        }
        
        return checkouts;
    }

    public static void checkinBook(long checkoutNumber) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            Checkout checkout = em.find(Checkout.class, checkoutNumber);
            if (checkout != null) {
                em.remove(checkout);
                trans.commit();
            }
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}