package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dao.AddressDao;
import priv.klochkov.constructionwork.dto.constructionorderdto.AddressDtoInsideOrder;
import priv.klochkov.constructionwork.entity.AddressEntity;
import priv.klochkov.constructionwork.sevice.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    private final static AddressDao addressDao = new AddressDao();

    public AddressDtoInsideOrder addressToDtoInsideOrder(AddressEntity address) {
        AddressDtoInsideOrder result = new AddressDtoInsideOrder();
        result.setId(address.getId());
        result.setCountry(address.getCountry());
        result.setHouse(address.getHouse());
        result.setStreet(address.getStreet());
        result.setNumberFlat(address.getNumberFlat());
        return result;
    }
}
