package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dao.ManagerDao;
import priv.klochkov.constructionwork.dto.constructionorderdto.ManagerDto;
import priv.klochkov.constructionwork.entity.ManagerEntity;
import priv.klochkov.constructionwork.entity.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl {

    private final ManagerDao managerDao;

    @Autowired
    public ManagerServiceImpl(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public List<ManagerDto> getListManagersDto(OrderEntity orderEntity) {
        return orderEntity.getManagers().stream().map(this::managerToDto).collect(Collectors.toList());
    }

    public ManagerDto managerToDto(ManagerEntity manager) {
        ManagerDto result = new ManagerDto();
        result.setId(manager.getId());
        result.setSurname(manager.getSurname());
        result.setNameByFather(manager.getNameViaFather());
        result.setEmail(manager.getEmail().getEmail());
        return result;
    }

}
