package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dao.OrderDao;
import priv.klochkov.constructionwork.dto.constructionorderdto.AddressDto;
import priv.klochkov.constructionwork.dto.constructionorderdto.CustomerDto;
import priv.klochkov.constructionwork.dto.constructionorderdto.ManagerDto;
import priv.klochkov.constructionwork.dto.constructionorderdto.OrderDto;
import priv.klochkov.constructionwork.dto.orderdtoforlist.CustomerDtoOrderList;
import priv.klochkov.constructionwork.dto.orderdtoforlist.OrderDtoList;
import priv.klochkov.constructionwork.entity.AddressEntity;
import priv.klochkov.constructionwork.entity.CustomerEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderDao orderDao;
    private final CustomerServiceImpl customerService;
    private final ManagerServiceImpl managerService;
    private final AddressServiceImpl addressService;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, CustomerServiceImpl customerService,
                            ManagerServiceImpl managerService, AddressServiceImpl addressService) {
        this.orderDao = orderDao;
        this.customerService = customerService;
        this.managerService = managerService;
        this.addressService = addressService;
    }

    public OrderEntity getOrderById(Long id) {
        return orderDao.read(id);
    }

    public List<OrderDtoList> getAllOrders() {
       return orderDao.findAll().stream().map(this::orderToDtoForList).collect(Collectors.toList());
    }

    private OrderDtoList orderToDtoForList(OrderEntity orderEntity) {
        OrderDtoList result = new OrderDtoList();
        CustomerEntity customer = orderEntity.getCustomer();
        CustomerDtoOrderList customerDto = customerService.customerToDtoOrderList(customer);
        result.setDateStart(orderEntity.getDateStart());
        result.setDateFinish(orderEntity.getDateFinish());
        result.setId(orderEntity.getId());
        result.setCustomerDtoOrderList(customerDto);
        return result;
    }

    public OrderDto getOrderDtoByOrderId(long id) {
        OrderEntity orderEntity = orderDao.read(id);
        return orderEntityToOrderDto(orderEntity);
    }


    private OrderDto orderEntityToOrderDto(OrderEntity orderEntity) {
        CustomerEntity customer = orderEntity.getCustomer();
        AddressEntity address = orderEntity.getAddress();
        CustomerDto customerDto = customerService.customerToDtoInsideOrder(customer);
        List<ManagerDto> listManagerDto = managerService.getListManagersDto(orderEntity);
        AddressDto addressDto = addressService.addressToDtoInsideOrder(address);
        return buildOrderDto(orderEntity, customerDto, addressDto, listManagerDto);
    }

    private OrderDto buildOrderDto(OrderEntity order, CustomerDto customerDto, AddressDto addressDto,
                                   List<ManagerDto> listManagerDto) {
        OrderDto result = new OrderDto();
        result.setId(order.getId());
        result.setDateStart(order.getDateStart());
        result.setDateFinish(order.getDateFinish());
        result.setCustomer(customerDto);
        result.setAddress(addressDto);
        result.setManagers(listManagerDto);
        return result;
    }

//    public List<MaterialDto> getMaterialsDtoByOrderId() {
//
//    }



}
