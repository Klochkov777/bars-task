package priv.klochkov.constructionwork.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class OrderDto {
    private Long id;

    private CustomerDtoForListOrder customerDtoForOrder;




}
