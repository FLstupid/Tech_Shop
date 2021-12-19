package DAO;

import Model.User;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserIO {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("shoping");
    public UserIO (){

    }
    public UserIO(HttpServletRequest request, HttpServletResponse response) {
    }

    public static long insert (User user)
    {    EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        long id;
        transaction.begin();
        try {
            em.persist(user);
            id = user.getId();
            transaction.commit();
            return id;
        }catch (Exception e){
            transaction.rollback();
            return 1;
        } finally
        {
            em.close();
        }
    }

    public long getID (User a)
    {
        return a.getId();
    }
    public static void update (User account)
    { EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(account);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        } finally
        {
            em.close();
        }
    }
    public static void delete (User account)
    {EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.merge(account));
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        } finally {
            em.close();
        }
    }

    public static Object selectAcc (String email)
    {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT q FROM User q WHERE q.email =?1").setParameter(1,email).getSingleResult();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
    public static boolean userExist(String username)
    {
        User u = (User) selectAcc(username);
        return u!= null;
    }
    public static User getAccountById (long Id){
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(User.class, Id);
        }finally {
            em.close();
        }
    }
    public static ArrayList<User> getAllAccIDName(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> listUser;
        ArrayList<User> results = null;
        try{
            listUser = em.createQuery("select a from User a",User.class);
            results = (ArrayList<User>) listUser.getResultList();
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
