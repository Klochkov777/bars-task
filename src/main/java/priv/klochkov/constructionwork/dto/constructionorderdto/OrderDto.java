package priv.klochkov.constructionwork.dto.constructionorderdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private Long id;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private CustomerDtoInsideOrder customer;
    private List<ManagerDtoInsideOrderList> managers = new ArrayList();
    private AddressDtoInsideOrder address;
}
