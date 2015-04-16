package dao;

import hibernate.HibernateUtil;

import java.sql.SQLException;

import org.hibernate.Session;

import entity.Product;

public class ProductDAOImpl implements DAO<Product> {

	public void add(Product product) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
	}

	public Product get(int id) throws SQLException {
		Session session = null;
        Product product = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            product = (Product) session.get(Product.class, id);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
	}

	public void update(Product product) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
	}

	public void delete(Product product) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }	
	}
}
