package dao;

import hibernate.HibernateUtil;

import java.sql.SQLException;

import org.hibernate.Session;

import entity.User;

public class UserDAOImpl implements DAO<User> {

	public void add(User user) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
	}

	public User get(int id) throws SQLException {
		 Session session = null;
         User user = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             user = (User) session.get(User.class, id);
         } catch (Exception e) {
        	 System.out.println(e.getMessage());
         } finally {
             if (session != null && session.isOpen()) {
                 session.close();
             }
         }
         return user;
	}

	public void update(User user) throws SQLException {
		  Session session = null;
          try {
              session = HibernateUtil.getSessionFactory().openSession();
              session.beginTransaction();
              session.update(user);
              session.getTransaction().commit();
          } catch (Exception e) {
        	  System.out.println(e.getMessage());
          } finally {
              if (session != null && session.isOpen()) {
                  session.close();
              }
          }
	}

	public void delete(User user) throws SQLException {
		 Session session = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.delete(user);
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
