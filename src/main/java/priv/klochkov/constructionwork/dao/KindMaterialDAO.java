package priv.klochkov.constructionwork.dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import priv.klochkov.constructionwork.entity.KindMaterialEntity;
import priv.klochkov.constructionwork.entity.MaterialEntity;
import priv.klochkov.constructionwork.sevice.utils.MySessionFactory;

import java.math.BigDecimal;
import java.util.List;

public class KindMaterialDAO extends AbstractDao<KindMaterialEntity> {

    private final SessionFactory sessionFactory = MySessionFactory.getSessionFactory();

    public KindMaterialDAO() {
        super(KindMaterialEntity.class);
    }


    public List<String> getAllNamesKindsMaterial() {
        List<String> result = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<String> query = session.createQuery("select e.name from KindMaterialEntity e", String.class);
            result = query.getResultList();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }

    public List<KindMaterialEntity> getAllKindsMaterial() {
        List<KindMaterialEntity> result = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<KindMaterialEntity> query = session.createQuery("select e.name from KindMaterialEntity e", KindMaterialEntity.class);
            result = query.getResultList();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }

    public KindMaterialEntity readByName(String nameMaterial) {
        KindMaterialEntity kindMaterial = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<KindMaterialEntity> query =
                    session.createQuery("from KindMaterialEntity k where k.name = :nameMaterial", KindMaterialEntity.class);
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
