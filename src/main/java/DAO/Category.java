package DAO;

import Model.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Category {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dhs");
    public static final EntityManager em = emf.createEntityManager();
    public static final EntityTransaction transaction = em.getTransaction();

    public void insert (CategoryEntity category)
    {
        try {
            transaction.begin();
            em.persist(category);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
    }

    public void update (CategoryEntity category)
    {
        try {
            transaction.begin();
            em.merge(category);

            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
    }
    public void delete (CategoryEntity category)
    {
        try {
            transaction.begin();

            em.remove(category);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
    }
}
