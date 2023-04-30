
package priv.klochkov.constructionwork.sevice;

import priv.klochkov.constructionwork.dto.constructionorderdto.AddressDtoInsideOrder;
import priv.klochkov.constructionwork.dto.constructionorderdto.CustomerDtoInsideOrder;
import priv.klochkov.constructionwork.dto.constructionorderdto.ManagerDtoInsideOrderList;
import priv.klochkov.constructionwork.dto.constructionorderdto.OrderDto;
import priv.klochkov.constructionwork.dto.orderdtoforlist.CustomerDtoOrderList;
import priv.klochkov.constructionwork.dto.orderdtoforlist.OrderDtoList;
import priv.klochkov.constructionwork.entity.AddressEntity;
import priv.klochkov.constructionwork.entity.CustomerEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface OrderService {
    OrderEntity getOrderById(Long id);

    List<OrderDtoList> getAllOrders();

    OrderDtoList orderToDtoForList(OrderEntity orderEntity);

    OrderDto getOrderDtoByOrderId(long id);



}
