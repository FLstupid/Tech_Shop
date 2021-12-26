package DAO;

import Model.CartItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
public class CartItemIO {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("shoping");
    public static void insert(CartItem cartItem)
    {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(cartItem);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }

    public static void update (CartItem cartItem)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(cartItem);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public static void delete (CartItem cartItem)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.merge(cartItem));
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public static List<?> selectItems (long cartId)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            em.getTransaction().begin();
            return em.createQuery("SELECT c.amount,c.cartId.id," +
                    "c.cartId.userId.id," +
                    "c.productId.productName,c.cartId.price," +
                    "c.productId.id FROM" +
                    " CartItem c WHERE c.cartId.id =?1").setParameter(1,cartId).getResultList();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }

    public static Object selectItem(long productCode, long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            em.getTransaction().begin();
            return em.createQuery("SELECT q FROM CartItem q WHERE q.productId.id =?1 AND q.id =?2").setParameter(1,productCode).setParameter(2,id).getSingleResult();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public static Object selectItemincart(long productCode, long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            em.getTransaction().begin();
            return em.createQuery("SELECT q FROM CartItem q WHERE q.productId.id =?1 AND q.cartId.id =?2").setParameter(1,productCode).setParameter(2,id).getSingleResult();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public static int CountIteminCart(long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            em.getTransaction().begin();
            return (int) em.createQuery("SELECT COUNT(q) FROM CartItem q WHERE q.productId.id =?1").setParameter(1,id).getSingleResult();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public static ArrayList<CartItem> getListCartItemByCartId(String id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CartItem> cartItemTypedQuery;
        ArrayList<CartItem> results = null;
        System.out.println("truoc khi vao try");
        try {

            long idf = Long.parseLong(id);
            cartItemTypedQuery = em.createQuery("select b from CartItem b  where b.cartId.id = ?1", CartItem.class);
            cartItemTypedQuery.setParameter(1,idf);
            System.out.println("Da chay duoc");
            System.out.println(id);
            results = (ArrayList<CartItem>) cartItemTypedQuery.getResultList();
            System.out.println("reshear"+results);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            em.close();
        }
        return results;
    }
}
