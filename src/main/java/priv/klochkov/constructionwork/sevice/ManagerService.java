package priv.klochkov.constructionwork.sevice;

import priv.klochkov.constructionwork.dto.constructionorderdto.ManagerDtoInsideOrderList;
import priv.klochkov.constructionwork.entity.ManagerEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface ManagerService {

    List<ManagerDtoInsideOrderList> getListManagersDto(OrderEntity orderEntity);
    ManagerDtoInsideOrderList managerToDtoInsideOrderList(ManagerEntity manager);
}
