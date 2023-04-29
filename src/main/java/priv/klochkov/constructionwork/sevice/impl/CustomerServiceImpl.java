package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dto.constructionorderdto.CustomerDto;
import priv.klochkov.constructionwork.dto.orderdtoforlist.CustomerDtoOrderList;
import priv.klochkov.constructionwork.entity.CustomerEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;

@Service
public class CustomerServiceImpl {
    public CustomerDtoOrderList customerToDtoOrderList(CustomerEntity customer) {
        CustomerDtoOrderList result = new CustomerDtoOrderList();
        result.setName(customer.getName());
        result.setSurname(customer.getSurname());
        result.setNameByFather(customer.getNameByFather());
        result.setPassportNumber(customer.getPassportNumber());
        return result;
    }

    public CustomerDto customerToDtoInsideOrder(CustomerEntity customer) {
        CustomerDto result = new CustomerDto();
        result.setId(customer.getId());
        result.setName(customer.getName());
        result.setSurname(customer.getSurname());
        return result;
    }
}
