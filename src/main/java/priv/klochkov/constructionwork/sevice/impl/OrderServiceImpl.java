package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dao.OrderDao;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.OrderService;
import priv.klochkov.constructionwork.sevice.utils.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderDao orderDao;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderMapper orderMapper) {
        this.orderDao = orderDao;
        this.orderMapper = orderMapper;
    }

    public OrderEntity getOrderById(Long id) {
        return orderDao.read(id);
    }


}
