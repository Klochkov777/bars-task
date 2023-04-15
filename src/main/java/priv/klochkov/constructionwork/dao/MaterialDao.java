package priv.klochkov.constructionwork.dao;

import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import priv.klochkov.constructionwork.entity.MaterialEntity;
import priv.klochkov.constructionwork.sevice.utils.MySessionFactory;

public class MaterialDao extends AbstractDao<MaterialEntity> {

    private final SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    public MaterialDao() {
        super(MaterialEntity.class);
    }
}
