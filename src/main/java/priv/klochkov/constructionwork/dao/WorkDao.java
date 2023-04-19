package priv.klochkov.constructionwork.dao;

import priv.klochkov.constructionwork.entity.WorkEntity;

public class WorkDao  extends AbstractDao<WorkEntity>{
    public WorkDao() {
        super(WorkEntity.class);
    }
}
