package priv.klochkov.constructionwork.dto.orderdtoforlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDtoList {
    Long id;
    LocalDate dateStart;
    LocalDate dateFinish;
    CustomerDtoOrderList customerDtoOrderList;

}
