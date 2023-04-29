package priv.klochkov.constructionwork.dto.constructionorderdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDtoInsideOrder {
    Long id;
    String name;
    String surname;
}
