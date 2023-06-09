package priv.klochkov.constructionwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import priv.klochkov.constructionwork.entity.CustomerEntity;
import priv.klochkov.constructionwork.sevice.utils.MySessionFactory;

import java.util.Optional;

@Repository
public class CustomerDao extends AbstractDao<CustomerEntity>{

    private final SessionFactory sessionFactory = MySessionFactory.getSessionFactory();

    public CustomerDao() {
        super(CustomerEntity.class);
    }



}
