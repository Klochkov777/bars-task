package priv.klochkov.constructionwork.dto.constructionorderdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManagerDtoInsideOrderList {
    private Long id;
    private String name;
    private String surname;
    private String nameByFather;
    private String email;
}
