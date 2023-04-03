package priv.klochkov.constructionwork.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
//@Table(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "number_of_flat")
    private Long numberFlat;

    @OneToMany(mappedBy = "address", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    List<OrderEntity> orders = new ArrayList<OrderEntity>();
}
