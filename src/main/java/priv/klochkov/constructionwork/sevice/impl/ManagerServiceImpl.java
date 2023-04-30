package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dao.ManagerDao;
import priv.klochkov.constructionwork.dto.constructionorderdto.ManagerDtoInsideOrderList;
import priv.klochkov.constructionwork.entity.ManagerEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.ManagerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerDao managerDao;

    @Autowired
    public ManagerServiceImpl(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public List<ManagerDtoInsideOrderList> getListManagersDto(OrderEntity orderEntity) {
        return orderEntity.getManagers().stream().map(this::managerToDtoInsideOrderList).collect(Collectors.toList());
    }

    public ManagerDtoInsideOrderList managerToDtoInsideOrderList(ManagerEntity manager) {
        ManagerDtoInsideOrderList result = new ManagerDtoInsideOrderList();
        result.setId(manager.getId());
        result.setSurname(manager.getSurname());
        result.setNameByFather(manager.getNameViaFather());
        result.setEmail(manager.getEmail().getEmail());
        return result;
    }

}
