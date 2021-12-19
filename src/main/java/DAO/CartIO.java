package DAO;

import Model.Cart;
import Model.User;

import javax.persistence.*;
import java.util.ArrayList;

public class CartIO {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("shoping");


    public void insert (Cart cart)
    { EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(cart);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public void update (Cart cart)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(cart);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public void delete (Cart cart)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(cart);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public static Object selectCart (long AccountId)
    {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Cart p WHERE p.userId.id =?1").setParameter(1,AccountId).getSingleResult();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
    public static ArrayList<Cart> getAllAccCart(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Cart> listCart;
        ArrayList<Cart> results = null;
        try{
            listCart = em.createQuery("select a from Cart a",Cart.class);
            results = (ArrayList<Cart>) listCart.getResultList();
            System.out.println(results);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }
        return results;
    }
}
