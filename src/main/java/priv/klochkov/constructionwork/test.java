package priv.klochkov.constructionwork;


import priv.klochkov.constructionwork.dao.OrderDao;
import priv.klochkov.constructionwork.entity.OrderEntity;

import java.util.List;

public class test {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        List<OrderEntity> list = orderDao.findAll();
        list.forEach(order -> System.out.println(order.getDateStart() + " " +
        order.getDateFinish() + " " + order.getCustomer().getName()));
    }
}
