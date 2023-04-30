package priv.klochkov.constructionwork.sevice;

import priv.klochkov.constructionwork.dto.constructionorderdto.CustomerDtoInsideOrder;
import priv.klochkov.constructionwork.dto.orderdtoforlist.CustomerDtoOrderList;
import priv.klochkov.constructionwork.entity.CustomerEntity;

public interface CustomerServiceIn {
    CustomerDtoInsideOrder customerToDtoInsideOrder(CustomerEntity customer);
    CustomerDtoOrderList customerToDtoOrderList(CustomerEntity customer);
}
