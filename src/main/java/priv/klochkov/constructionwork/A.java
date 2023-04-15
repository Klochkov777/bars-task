package priv.klochkov.constructionwork;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import priv.klochkov.constructionwork.dao.KindMaterialDAO;
import priv.klochkov.constructionwork.dao.MaterialDao;
import priv.klochkov.constructionwork.dao.OrderDao;
import priv.klochkov.constructionwork.entity.KindMaterialEntity;
import priv.klochkov.constructionwork.entity.MaterialEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.utils.MySessionFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {

        //create

        KindMaterialDAO kindMaterialDAO = new KindMaterialDAO();
        KindMaterialEntity kindMaterial1 = new KindMaterialEntity();
        kindMaterial1.setName("board");
        kindMaterial1.setUnit("M2");
        kindMaterial1.setCost(new BigDecimal("100"));
        kindMaterialDAO.create(kindMaterial1);


        KindMaterialEntity kindMaterial2 = new KindMaterialEntity();
        kindMaterial2.setName("stone");
        kindMaterial2.setUnit("M3");
        kindMaterial2.setCost(new BigDecimal("300"));
        kindMaterialDAO.create(kindMaterial2);


        KindMaterialEntity kindMaterial3 = new KindMaterialEntity();
        kindMaterial3.setName("plaster");
        kindMaterial3.setUnit("M2");
        kindMaterial3.setCost(new BigDecimal("500"));
        kindMaterialDAO.create(kindMaterial3);
//
//        //update
//        kindMaterial1.setCost(new BigDecimal("5000"));
//        kindMaterialDAO.update(kindMaterial1);
//
//        //delete
//        kindMaterialDAO.delete(kindMaterial2);
//
//        //read
//        System.out.println("Read by id   " + kindMaterialDAO.read(kindMaterial3.getId()));
//
//        //readByName
//        System.out.println("Read by name     " + kindMaterialDAO.readByName("plaster"));
//
//        //readAll
//        System.out.println("Read All names     " + kindMaterialDAO.getAllNamesKindsMaterial());
//
//
//        System.out.println("Read All kindsOfMaterials     " + kindMaterialDAO.getAllKindsMaterial());


//        OrderDao orderDao = new OrderDao();
//        OrderEntity order = new OrderEntity();
//        MaterialEntity materialEntity1 = new MaterialEntity();
////        kindMaterial1.setId(1l);
////        materialEntity1.setKindMaterial(kindMaterial1);
//        materialEntity1.setAmount(100L);
//        materialEntity1.setOrder(order);
//        order.getMaterials().add(materialEntity1);
////        System.out.println("!!!!!!!!!!!!!!!" + order.getMaterials().get(0).getKindMaterial().getName());
//
//        orderDao.create(order);

//        MaterialEntity material2  = new MaterialEntity();
//        material2.setAmount(40l);
//        material2.setKindMaterial(kindMaterial3);
//        List<MaterialEntity> materialEntityList  = new ArrayList<>();
//        materialEntityList.add(material2);
//        System.out.println("!!!!!!!!!!!!!!!" + order.getMaterials().get(0).getKindMaterial().getName() + "and" + order.getMaterials().get(0).getKindMaterial().getName());
//
//
////        orderDao.addMaterials(1l, materialEntityList);
//
//        System.out.println("Order get  id1 " + orderDao.read(1l));

//        KindMaterialEntity kindMaterialEntity4 = new KindMaterialEntity();
//        kindMaterialEntity4.


        //create material and bind kind_of_material
        SessionFactory sessionFactory = MySessionFactory.getSessionFactory();

        MaterialDao materialDao = new MaterialDao();

        MaterialEntity materialEntity1 = new MaterialEntity();
        materialEntity1.setAmount(50l);
        kindMaterial1.setId(1l);

        //this option does not work (kind_material = null) !!!!!!!!!!!!!

//        materialDao.create(materialEntity1);


        //this option workable !!!!!!!!!!!!!!!!!

//        try(Session session = sessionFactory.getCurrentSession()) {
//            Transaction transaction = session.beginTransaction();
//            kindMaterial1 = session.find(KindMaterialEntity.class, 1l);
//            kindMaterial1.getMaterials().add(materialEntity1);
//            materialEntity1.setKindMaterial(kindMaterial1);
//            session.persist(materialEntity1);
//            transaction.commit();
//        }





        OrderDao orderDao = new OrderDao();
        OrderEntity order = new OrderEntity();

        MaterialEntity materialEntity2 = new MaterialEntity();
        materialEntity2.setAmount(100000L);

        kindMaterial2.setId(2l);

        //here I bind material and order( in future  i get dto and this action
        // in service)

        materialEntity1.setKindMaterial(kindMaterial1);
        kindMaterial1.getMaterials().add(materialEntity1);
        materialEntity2.setKindMaterial(kindMaterial2);
        kindMaterial2.getMaterials().add(materialEntity2);

        order.getMaterials().addAll(List.of(materialEntity1, materialEntity2));


        materialEntity1.setOrder(order);
        materialEntity2.setOrder(order);

        //attempt with order by cascade (materials were not created) !!!!!!!!!!!!!!!!!!!!!

//        orderDao.create(order);



        //this option workable

        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            materialEntity1 = order.getMaterials().get(0);
            materialEntity2 = order.getMaterials().get(1);

            Long idKindMaterial1 = materialEntity1.getKindMaterial().getId();
            Long idKindMaterial2 = materialEntity2.getKindMaterial().getId();

            kindMaterial1 = session.find(KindMaterialEntity.class, idKindMaterial1);
            kindMaterial2 = session.find(KindMaterialEntity.class, idKindMaterial2);

            materialEntity1.setKindMaterial(kindMaterial1);
            materialEntity2.setKindMaterial(kindMaterial2);

            session.persist(order);

            transaction.commit();
        }




    }
}
