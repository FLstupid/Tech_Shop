package DAO;

import Model.OrdersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class OrderIO {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("shoping");


    public void insert (OrdersEntity orderDetail)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(orderDetail);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
    }

    public void update (OrdersEntity orderDetail)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.merge(orderDetail);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
    }
    public void delete (OrdersEntity orderDetail)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.remove(orderDetail);
            transaction.commit();
        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
    }
    public static List<?> selectOrderList (long ID)
    {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p.id as MaDonHang, " +
                    "p.createAt as NgayMua, g.productName as TenSanPham ," +
                    "p.totalPrice as TongTien, p.userByUserId.phone" + " FROM OrdersEntity p , UserEntity ac, ProductEntity g\n" +
                    "WHERE g.id=p.id " +
                    "AND  ac.id = ?1").setParameter(1,ID).getResultList();

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally {
            em.close();
        }
    }
}
