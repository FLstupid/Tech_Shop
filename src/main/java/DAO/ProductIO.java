package DAO;

import Model.ProductEntity;

import javax.persistence.*;
import java.util.List;

public class ProductIO {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dhs");
    public static void insert(ProductEntity product)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(product);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }

    public void update (ProductEntity product)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(product);

            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public void delete (ProductEntity product)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.remove(product);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
        }
    }
    public static Object selectProduct(long ID)
    {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p.id, p.productName as productname," +
                            " p.categoryByCategoryId.name as decription" +
                            ",p.price as price ," +
                            "p.content FROM ProductEntity p where p.id =?1").setParameter(1,ID)
                    .getSingleResult();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }

    }

    public static List<?> selectListProduct()
    {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p.productName as productname, " +
                            "p.content as decription" +
                            ",p.price as price ,p.id, p.picture " +
                            "FROM ProductEntity p")
                    .getResultList();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }
    }

    public static List<?> selectListProductByproductname(String ProductName)
    {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p.productName as productname, " +
                            "p.content as decription" +
                            ",p.price as price ,p.id " +
                            "FROM ProductEntity p where p.productName like ?1").setParameter(1,"%"+ ProductName+"%")
                    .getResultList();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
    public static ProductEntity selectProductByid(long idproduct)
    {
        EntityManager em = emf.createEntityManager();
        try {

            return (ProductEntity) em.createQuery("SELECT p FROM ProductEntity p where p.id =?1").setParameter(1,idproduct).getSingleResult();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }

    }
}
