package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dao.AddressDao;
import priv.klochkov.constructionwork.dao.CustomerDao;
import priv.klochkov.constructionwork.dao.ManagerDao;
import priv.klochkov.constructionwork.dao.OrderDao;
import priv.klochkov.constructionwork.dto.constructionorderdto.AddressDtoInsideOrder;
import priv.klochkov.constructionwork.dto.constructionorderdto.CustomerDtoInsideOrder;
import priv.klochkov.constructionwork.dto.constructionorderdto.ManagerDtoInsideOrderList;
import priv.klochkov.constructionwork.dto.constructionorderdto.OrderDto;
import priv.klochkov.constructionwork.dto.orderdtoforlist.CustomerDtoOrderList;
import priv.klochkov.constructionwork.dto.orderdtoforlist.OrderDtoList;
import priv.klochkov.constructionwork.entity.AddressEntity;
import priv.klochkov.constructionwork.entity.CustomerEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderDao orderDao;
    public final CustomerServiceImpl customerService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private AddressService addressService;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, @Qualifier("customerService") CustomerServiceImpl customerService) {
        this.orderDao = orderDao;
        this.customerService = customerService;
    }

    //    public OrderServiceImpl(OrderDao orderDao, CustomerService customerService) {
//        this.orderDao = orderDao;
//        this.customerService = customerService;
//    }

    public OrderEntity getOrderById(Long id) {
        return orderDao.read(id);
    }

    public List<OrderDtoList> getAllOrders() {
       return orderDao.findAll().stream().map(this::orderToDtoForList).collect(Collectors.toList());
    }

    public OrderDtoList orderToDtoForList(OrderEntity orderEntity) {

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
//        ManagerServiceImpl managerService = new ManagerServiceImpl(new ManagerDao());
//        CustomerServiceImpl customerService = new CustomerServiceImpl(new CustomerDao());
//        AddressServiceImpl addressService = new AddressServiceImpl(new AddressDao());
        CustomerEntity customer = orderEntity.getCustomer();
        AddressEntity address = orderEntity.getAddress();
        CustomerDtoInsideOrder customerDto = customerService.customerToDtoInsideOrder(customer);
        List<ManagerDtoInsideOrderList> listManagerDto = managerService.getListManagersDto(orderEntity);
        AddressDtoInsideOrder addressDto = addressService.addressToDtoInsideOrder(address);
        return buildOrderDto(orderEntity, customerDto, addressDto, listManagerDto);
    }

    private OrderDto buildOrderDto(OrderEntity order, CustomerDtoInsideOrder customerDto, AddressDtoInsideOrder addressDto,
                                   List<ManagerDtoInsideOrderList> listManagerDto) {
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

