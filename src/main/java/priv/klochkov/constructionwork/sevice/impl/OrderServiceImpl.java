package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dao.OrderDao;
import priv.klochkov.constructionwork.dto.CustomerDtoForListOrder;
import priv.klochkov.constructionwork.dto.OrderDtoForList;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderEntity getOrderById(Long id) {
        return orderDao.read(id);
    }

    public List<OrderDtoForList> getAllOrders() {
       return orderDao.findAll().stream().map(this::orderEntityToOrderDtoForList).collect(Collectors.toList());
    }

    private OrderDtoForList orderEntityToOrderDtoForList(OrderEntity orderEntity) {
        OrderDtoForList result = new OrderDtoForList();
        CustomerDtoForListOrder customer = customerEntityToCustomerDtoForListOrder(orderEntity);
        result.setDateStart(orderEntity.getDateStart());
        result.setDateFinish(orderEntity.getDateFinish());
        result.setId(orderEntity.getId());
        result.setCustomerDtoForListOrder(customer);
        return result;
    }

    private CustomerDtoForListOrder customerEntityToCustomerDtoForListOrder(OrderEntity order) {
        CustomerDtoForListOrder result = new CustomerDtoForListOrder();
        result.setName(order.getCustomer().getName());
        result.setSurname(order.getCustomer().getSurname());
        result.setNameByFather(order.getCustomer().getNameByFather());
        result.setPassportNumber(order.getCustomer().getPassportNumber());
        return result;
    }


}
