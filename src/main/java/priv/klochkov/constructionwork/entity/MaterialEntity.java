package priv.klochkov.constructionwork.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "materials")
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @ManyToOne(cascade = CascadeType.ALL/*{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}*/)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne(cascade = CascadeType.ALL/*{CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}*/)
    @JoinColumn(name = "kind_material id")
    private KindMaterialEntity kindMaterial;


}
