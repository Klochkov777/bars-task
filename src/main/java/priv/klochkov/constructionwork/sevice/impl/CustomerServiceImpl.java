package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dao.CustomerDao;
import priv.klochkov.constructionwork.dao.OrderDao;
import priv.klochkov.constructionwork.dto.CustomerDto;
import priv.klochkov.constructionwork.dto.constructionorderdto.CustomerDtoInsideOrder;
import priv.klochkov.constructionwork.dto.orderdtoforlist.CustomerDtoOrderList;
import priv.klochkov.constructionwork.dto.orderdtoforlist.OrderDtoList;
import priv.klochkov.constructionwork.entity.CustomerEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.CustomerService;
import priv.klochkov.constructionwork.sevice.CustomerServiceIn;
import priv.klochkov.constructionwork.sevice.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerServiceIn {

    private final CustomerDao customerDao;


    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public CustomerDtoOrderList customerToDtoOrderList(CustomerEntity customer) {
        CustomerDtoOrderList result = new CustomerDtoOrderList();
        result.setName(customer.getName());
        result.setSurname(customer.getSurname());
        result.setNameByFather(customer.getNameByFather());
        result.setPassportNumber(customer.getPassportNumber());
        return result;
    }

    public CustomerDtoInsideOrder customerToDtoInsideOrder(CustomerEntity customer) {
        CustomerDtoInsideOrder result = new CustomerDtoInsideOrder();
        result.setId(customer.getId());
        result.setName(customer.getName());
        result.setSurname(customer.getSurname());
        return result;
    }

    public CustomerDto customerToDto(CustomerEntity customer, OrderService orderService) {
        CustomerDto result = new CustomerDto();
        result.setName(customer.getName());
        result.setSurname(customer.getSurname());
        result.setNameByFather(customer.getNameByFather());
        result.setPassportNumber(customer.getPassportNumber());
        result.setEmail(customer.getEmailEntity().getEmail());
        result.setNumbersPhone(customer.getNumbersPhone());
        List<OrderDtoList> ordersDto = customer.getOrders().stream().map(orderService::orderToDtoForList).collect(Collectors.toList());
        result.setOrders(ordersDto);
        return result;
    }


}
