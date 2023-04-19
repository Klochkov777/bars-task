package priv.klochkov.constructionwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import priv.klochkov.constructionwork.entity.MaterialTypeEntity;
import priv.klochkov.constructionwork.sevice.utils.MySessionFactory;

import java.util.List;

public class MaterialTypeDao extends AbstractDao<MaterialTypeEntity> {

    private final SessionFactory sessionFactory = MySessionFactory.getSessionFactory();

    public MaterialTypeDao() {
        super(MaterialTypeEntity.class);
    }


    public List<String> getAllNamesTypesMaterial() {
        List<String> result = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<String> query = session.createQuery("select e.name from MaterialTypeEntity e", String.class);
            result = query.getResultList();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }

    public List<MaterialTypeEntity> getAllTypesMaterial() {
        List<MaterialTypeEntity> result = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<MaterialTypeEntity> query = session.createQuery("select e.name from MaterialTypeEntity e", MaterialTypeEntity.class);
            result = query.getResultList();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }

    public MaterialTypeEntity readByName(String nameMaterial) {
        MaterialTypeEntity kindMaterial = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<MaterialTypeEntity> query =
                    session.createQuery("from MaterialTypeEntity k where k.name = :nameMaterial", MaterialTypeEntity.class);
            query.setParameter("nameMaterial", nameMaterial);
            kindMaterial = query.getSingleResult();
            transaction.commit();
            return kindMaterial;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return kindMaterial;
    }
}
