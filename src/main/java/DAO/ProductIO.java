package DAO;

import Model.Product;

import javax.persistence.*;
import java.util.List;

public class ProductIO {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("shoping");
    public static void insert(Product product)
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

    public static Product selectProductByid(long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Product>  acc;
        try {

            acc = em.createQuery("SELECT p FROM Product p where p.id = :id"
                    ,Product.class);
            acc.setParameter("id",id);


            return acc.getSingleResult();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }
    }

    public static void update(Product product)
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
    public void delete (Product product)
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
            return em.createQuery("SELECT p.productName as productname," +
                            " p.categoryId.name as category" +
                            ",p.price as price ," +
                            "p.content FROM Product p where p.id =?1").setParameter(1,ID)
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
                            "FROM Product p")
                    .getResultList();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }
    }

    public static List<?> ListProductByproductname(String ProductName)
    {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p.productName as productname, " +
                            "p.content as decription" +
                            ",p.price as price ,p.id " +
                            "FROM Product p where p.productName like ?1").setParameter(1,"%"+ ProductName+"%")
                    .getResultList();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
    public static List<?> ListProductByCategory(String Category)
    {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p.productName as productname, " +
                            "p.content as decription" +
                            ",p.price as price ,p.id " +
                            "FROM Product p where p.categoryId.name like ?1").setParameter(1,"%"+ Category+"%")
                    .getResultList();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
}
