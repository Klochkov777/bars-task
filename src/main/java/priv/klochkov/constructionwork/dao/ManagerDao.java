package priv.klochkov.constructionwork.dao;

import org.springframework.stereotype.Repository;
import priv.klochkov.constructionwork.entity.ManagerEntity;

@Repository
public class ManagerDao extends AbstractDao<ManagerEntity> {
    public ManagerDao() {
        super(ManagerEntity.class);
    }


}
