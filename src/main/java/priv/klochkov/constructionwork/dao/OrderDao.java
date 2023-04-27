package priv.klochkov.constructionwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import priv.klochkov.constructionwork.entity.AddressEntity;
import priv.klochkov.constructionwork.entity.CustomerEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.utils.MySessionFactory;

//@Component
@Repository
public class OrderDao extends AbstractDao<OrderEntity> {

    public OrderDao() {
        super(OrderEntity.class);
    }

    private final SessionFactory sessionFactory = MySessionFactory.getSessionFactory();

//    public void addMaterials(Long idOrder, List<MaterialEntity> materials) {
//        try(Session session = sessionFactory.getCurrentSession()) {
//            Transaction transaction = session.beginTransaction();
//            Query<OrderEntity> query = session.createQuery("from OrderEntity where id = :idOrder", OrderEntity.class);
//            query.setParameter("idOrder", idOrder);
//            OrderEntity order = query.getSingleResult();
//            order.getMaterials().addAll(materials);
//            session.merge(order);
//            transaction.commit();
//        }catch (Exception e){
//            e.getStackTrace();
//        }
//    }

    @Override
    public void create(OrderEntity entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            bindCustomerAndOrder(session, entity);
            bindAddressAndOrder(session, entity);
            session.persist(entity);
            transaction.commit();
        }
        super.create(entity);
    }

    private void bindCustomerAndOrder(Session session, OrderEntity entity) {
        Query<CustomerEntity> query = session.createQuery("select c from CustomerEntity c where c.passportNumber like :passportNum", CustomerEntity.class);
        query.setParameter ("passportNum", entity.getCustomer().getPassportNumber());
        CustomerEntity customer = query.getSingleResultOrNull();
        if (customer != null) {
            entity.setCustomer(customer);
            customer.getOrders().add(entity);
        }
    }

    private void bindAddressAndOrder(Session session, OrderEntity entity) {
        Query<AddressEntity> query = session.createQuery("from AddressEntity a where " +
                "a.country = :country and a.town = :town and a.street = :street and a.house = :house and a.numberFlat = :numberFlat", AddressEntity.class);
        AddressEntity address = entity.getAddress();
        query.setParameter ("country", address.getCountry());
        query.setParameter ("street", address.getStreet());
        query.setParameter("town", address.getTown());
        query.setParameter ("house", address.getHouse());
        query.setParameter ("numberFlat", address.getNumberFlat());
        address = query.getSingleResultOrNull();
        if (address != null) {
            entity.setAddress(address);
            address.getOrders().add(entity);
        }
    }
}
