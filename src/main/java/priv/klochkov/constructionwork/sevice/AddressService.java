package priv.klochkov.constructionwork.sevice;

import priv.klochkov.constructionwork.dto.constructionorderdto.AddressDtoInsideOrder;
import priv.klochkov.constructionwork.entity.AddressEntity;

public interface AddressService {
    AddressDtoInsideOrder addressToDtoInsideOrder(AddressEntity address);
}
