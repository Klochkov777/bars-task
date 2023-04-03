package priv.klochkov.constructionwork.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
//@Table(name = "kind_of_work")
public class KindWorkEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "unit")
    private String unit;

    @JoinColumn(name = "cost")
    private BigDecimal cost;

    @OneToMany(mappedBy = "kindWork", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    List<WorkEntity> works = new ArrayList<WorkEntity>();
}
