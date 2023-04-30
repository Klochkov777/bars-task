package priv.klochkov.constructionwork.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import priv.klochkov.constructionwork.dto.orderdtoforlist.OrderDtoList;
import priv.klochkov.constructionwork.entity.EmailEntity;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String name;
    private String surname;
    private String nameByFather;
    private String passportNumber;
    private String email;
    private List<String> numbersPhone;
    private List<OrderDtoList> orders;
}
