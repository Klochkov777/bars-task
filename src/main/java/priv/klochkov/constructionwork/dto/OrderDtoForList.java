package priv.klochkov.constructionwork.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDtoForList {
    Long id;
    LocalDate dateStart;
    LocalDate dateFinish;
    CustomerDtoForListOrder customerDtoForListOrder;

}
