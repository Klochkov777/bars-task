package priv.klochkov.constructionwork;

import priv.klochkov.constructionwork.dao.*;
import priv.klochkov.constructionwork.entity.*;

import java.math.BigDecimal;
import java.util.List;

public class A {
    public static void main(String[] args) {

        //create

        MaterialTypeDao materialTypeDAO = new MaterialTypeDao();
        MaterialTypeEntity typeMaterial1 = new MaterialTypeEntity();
        typeMaterial1.setName("board");
        typeMaterial1.setUnit("M2");
        typeMaterial1.setCost(new BigDecimal("100"));
        materialTypeDAO.create(typeMaterial1);


        MaterialTypeEntity typeMaterial2 = new MaterialTypeEntity();
        typeMaterial2.setName("stone");
        typeMaterial2.setUnit("M3");
        typeMaterial2.setCost(new BigDecimal("300"));
        materialTypeDAO.create(typeMaterial2);


        MaterialTypeEntity typeMaterial3 = new MaterialTypeEntity();
        typeMaterial3.setName("plaster");
        typeMaterial3.setUnit("M2");
        typeMaterial3.setCost(new BigDecimal("500"));
        materialTypeDAO.create(typeMaterial3);


        WorkTypeDao workTypeDao = new WorkTypeDao();
        WorkTypeEntity workTypeEntity1 = new WorkTypeEntity();
        workTypeEntity1.setName("work1");
        workTypeEntity1.setUnit("m2");
        workTypeEntity1.setCost(new BigDecimal(1000));
        workTypeDao.create(workTypeEntity1);

        WorkTypeEntity workTypeEntity2 = new WorkTypeEntity();
        workTypeEntity2.setName("work2");
        workTypeEntity2.setUnit("m2");
        workTypeEntity2.setCost(new BigDecimal(2000));
        workTypeDao.create(workTypeEntity2);

        WorkTypeEntity workTypeEntity3 = new WorkTypeEntity();
        workTypeEntity3.setName("work3");
        workTypeEntity3.setUnit("m2");
        workTypeEntity3.setCost(new BigDecimal(3000));
        workTypeDao.create(workTypeEntity3);

        EmailDao emailDao = new EmailDao();
        EmailEntity emailEntity1 = new EmailEntity();
        emailEntity1.setEmail("vova@mail.ru");

        EmailEntity emailEntity2 = new EmailEntity();
        emailEntity2.setEmail("serg@mail.ru");

        CustomerDao customerDao = new CustomerDao();
        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setName("Vladimir");
        customerEntity1.setSurname("Klochkov");
        customerEntity1.setNameByFather("Aleksandrovich");
        customerEntity1.setPassportNumber("657748789");
        customerEntity1.setEmailEntity(emailEntity1);
        customerEntity1.getNumbersPhone().addAll(List.of("89093456787", "7864532"));

        CustomerEntity customerEntity2 = new CustomerEntity();
        customerEntity2.setName("Serg");
        customerEntity2.setSurname("Ivanov");
        customerEntity2.setNameByFather("Aleksandrovich");
        customerEntity2.setPassportNumber("65763");
        customerEntity2.setEmailEntity(emailEntity2);


        AddressDao addressDao = new AddressDao();
        AddressEntity addressEntity1 = new AddressEntity();
        addressEntity1.setCountry("Russia");
        addressEntity1.setTown("Odincovo");
        addressEntity1.setStreet("Skolkovo");
        addressEntity1.setHouse("5");
        addressEntity1.setNumberFlat(10l);

        AddressEntity addressEntity2 = new AddressEntity();
        addressEntity2.setCountry("Usa");
        addressEntity2.setStreet("wash");
        addressEntity2.setTown("NEw york");
        addressEntity2.setHouse("4");
        addressEntity2.setNumberFlat(22l);


        ManagerDao managerDao = new ManagerDao();
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setName("Evgeniy");
        managerEntity.setSurname("Zagrodskiy");
        managerEntity.setNameViaFather("byDather");
        EmailEntity email = new EmailEntity();
        email.setEmail("zag@mail.ru");
        managerEntity.setEmail(email);

//        customerEntity1.getNumbersPhone().addAll(List.of("89997772324", "89368889933"));

//
//        //update
//        typeMaterial1.setCost(new BigDecimal("5000"));
//        materialTypeDAO.update(typeMaterial1);
//
//        //delete
//        materialTypeDAO.delete(typeMaterial2);
//
//        //read
//        System.out.println("Read by id   " + materialTypeDAO.read(typeMaterial3.getId()));
//
//        //readByName
//        System.out.println("Read by name     " + materialTypeDAO.readByName("plaster"));
//
//        //readAll
//        System.out.println("Read All names     " + materialTypeDAO.getAllNamesKindsMaterial());
//
//
//        System.out.println("Read All kindsOfMaterials     " + materialTypeDAO.getAllKindsMaterial());


//        OrderDao orderDao = new OrderDao();
//        OrderEntity order = new OrderEntity();
//        MaterialEntity materialEntity1 = new MaterialEntity();
////        typeMaterial1.setId(1l);
////        materialEntity1.setKindMaterial(typeMaterial1);
//        materialEntity1.setAmount(100L);
//        materialEntity1.setOrder(order);
//        order.getMaterials().add(materialEntity1);
////        System.out.println("!!!!!!!!!!!!!!!" + order.getMaterials().get(0).getKindMaterial().getName());
//
//        orderDao.create(order);

//        MaterialEntity material2  = new MaterialEntity();
//        material2.setAmount(40l);
//        material2.setKindMaterial(typeMaterial3);
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









        OrderDao orderDao = new OrderDao();
        OrderEntity order = new OrderEntity();

        MaterialEntity materialEntity1 = new MaterialEntity();
        materialEntity1.setAmount(50l);
        typeMaterial1.setId(1l);

        MaterialEntity materialEntity2 = new MaterialEntity();
        materialEntity2.setAmount(100000L);


        materialEntity1.setKindMaterial(typeMaterial1);
        materialEntity2.setKindMaterial(typeMaterial2);

        order.getMaterials().addAll(List.of(materialEntity1, materialEntity2));


        WorkEntity workEntity1 = new WorkEntity();
        workEntity1.setAmount(1l);
        workEntity1.setKindWork(workTypeEntity1);

        WorkEntity workEntity2 = new WorkEntity();
        workEntity2.setAmount(2l);
        workEntity2.setKindWork(workTypeEntity1);

        WorkEntity workEntity3 = new WorkEntity();
        workEntity3.setAmount(3l);
        workEntity3.setKindWork(workTypeEntity2);

        order.getWorks().addAll(List.of(workEntity1, workEntity2, workEntity3));

        order.setCustomer(customerEntity1);
        order.setAddress(addressEntity1);

        OrderEntity order2 = new OrderEntity();
        order2.setCustomer(customerEntity1);
        order2.setAddress(addressEntity2);

        OrderEntity order3 = new OrderEntity();
        order3.setCustomer(customerEntity2);
        order3.setAddress(addressEntity2);

        order.getManagers().add(managerEntity);







        orderDao.create(order);
        orderDao.create(order2);
        orderDao.create(order3);





    }
}
