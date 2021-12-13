package DAO;

import Model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CategoryIO {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("shoping");

    public static Object SelectCategoryByName(String categoryname) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("select q from Category q where q.name = ?1").setParameter(1,categoryname).getSingleResult();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            em.close();
        }
    }

    public void insert (Category category)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(category);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }

    public void update (Category category)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(category);

            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public void delete (Category category)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.remove(category);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
}
