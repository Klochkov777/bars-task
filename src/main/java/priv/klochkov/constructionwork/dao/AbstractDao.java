package priv.klochkov.constructionwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import priv.klochkov.constructionwork.sevice.utils.MySessionFactory;

public abstract class AbstractDao<T> {
    private final Class<T> clazz;
    private final SessionFactory sessionFactory = MySessionFactory.getSessionFactory();

    protected AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void create(T entity) {
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void update(T entity) {
        try(Session session = sessionFactory.getCurrentSession();) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public T read(Long id) {
        T entity = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            entity = session.find(clazz, id);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return entity;
    }

    public void delete(T entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
