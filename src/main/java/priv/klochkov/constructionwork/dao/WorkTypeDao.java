package priv.klochkov.constructionwork.dao;

import priv.klochkov.constructionwork.entity.WorkEntity;
import priv.klochkov.constructionwork.entity.WorkTypeEntity;

public class WorkTypeDao extends AbstractDao<WorkTypeEntity>{
    public WorkTypeDao() {
        super(WorkTypeEntity.class);
    }
}
