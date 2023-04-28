package priv.klochkov.constructionwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import priv.klochkov.constructionwork.sevice.utils.MySessionFactory;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractDao<T> {
    private final Class<T> clazz;
    private final SessionFactory sessionFactory = MySessionFactory.getSessionFactory();

    protected AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void create(T entity) {
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            System.out.println("begin trans");
            System.out.println(entity.toString());
            session.persist(entity);
            System.out.println("finish persist");
            transaction.commit();
            System.out.println("finishTrans");
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

    public List<T> findAll() {
        List<T> result = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            String entityClassName = clazz.getSimpleName();
            String queryString = "from " + entityClassName;
            Query<T> query = session.createQuery(queryString);
            result = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }


}
