package priv.klochkov.constructionwork.dao;

import priv.klochkov.constructionwork.entity.CustomerEntity;

public class CustomerDao extends AbstractDao<CustomerEntity>{
    public CustomerDao() {
        super(CustomerEntity.class);
    }
}
