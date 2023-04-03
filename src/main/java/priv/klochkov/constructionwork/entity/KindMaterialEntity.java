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
@Entity
@Table(name = "kind_of_Material")
public class KindMaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "unit", columnDefinition = "varchar(10)")
    private String unit;

    @Column(name = "cost")
    private BigDecimal cost;

//    @OneToMany(mappedBy = "kindMaterial", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = false)
//    private List<MaterialEntity> materials = new ArrayList<MaterialEntity>();
}