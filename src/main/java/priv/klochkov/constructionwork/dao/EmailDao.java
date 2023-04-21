package priv.klochkov.constructionwork.dao;

import priv.klochkov.constructionwork.entity.EmailEntity;

public class EmailDao extends AbstractDao<EmailEntity> {

    public EmailDao() {
        super(EmailEntity.class);
    }
}
