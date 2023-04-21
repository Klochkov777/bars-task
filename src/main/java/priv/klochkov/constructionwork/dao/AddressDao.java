package priv.klochkov.constructionwork.dao;

import priv.klochkov.constructionwork.entity.AddressEntity;

public class AddressDao extends AbstractDao<AddressEntity> {
    public AddressDao() {
        super(AddressEntity.class);
    }
}
