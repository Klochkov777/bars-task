package priv.klochkov.constructionwork.dto.constructionorderdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
    private Long id;
    private String country;
    private String town;
    private String street;
    private String house;
    private Long numberFlat;
}
