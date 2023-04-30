package priv.klochkov.constructionwork.sevice;

import priv.klochkov.constructionwork.dao.OrderDao;
import priv.klochkov.constructionwork.dto.CustomerDto;
import priv.klochkov.constructionwork.dto.constructionorderdto.CustomerDtoInsideOrder;
import priv.klochkov.constructionwork.dto.orderdtoforlist.CustomerDtoOrderList;
import priv.klochkov.constructionwork.dto.orderdtoforlist.OrderDtoList;
import priv.klochkov.constructionwork.entity.CustomerEntity;
import priv.klochkov.constructionwork.sevice.impl.OrderServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public interface CustomerService {
    public CustomerDtoOrderList customerToDtoOrderList(CustomerEntity customer);

    CustomerDtoInsideOrder customerToDtoInsideOrder(CustomerEntity customer);

    CustomerDto customerToDto(CustomerEntity customer);
}
