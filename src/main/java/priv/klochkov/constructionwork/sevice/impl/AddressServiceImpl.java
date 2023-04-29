package priv.klochkov.constructionwork.sevice.impl;

import org.springframework.stereotype.Service;
import priv.klochkov.constructionwork.dto.constructionorderdto.AddressDto;
import priv.klochkov.constructionwork.entity.AddressEntity;

@Service
public class AddressServiceImpl {
    public AddressDto addressToDtoInsideOrder(AddressEntity address) {
        AddressDto result = new AddressDto();
        result.setId(address.getId());
        result.setCountry(address.getCountry());
        result.setHouse(address.getHouse());
        result.setStreet(address.getStreet());
        result.setNumberFlat(address.getNumberFlat());
        return result;
    }
}
