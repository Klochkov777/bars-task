package priv.klochkov.constructionwork.dao;

import org.hibernate.SessionFactory;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.utils.MySessionFactory;


public class OrderDao extends AbstractDao<OrderEntity>{

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
}
