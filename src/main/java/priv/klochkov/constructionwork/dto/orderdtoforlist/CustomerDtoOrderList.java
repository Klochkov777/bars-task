package priv.klochkov.constructionwork.dto.orderdtoforlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDtoOrderList {
    private String name;
    private String surname;
    private String nameByFather;
    private String passportNumber;
}
