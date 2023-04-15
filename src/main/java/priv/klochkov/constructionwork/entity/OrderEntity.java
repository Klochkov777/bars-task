package priv.klochkov.constructionwork.entity;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private CustomerEntity customer;

//    @JoinColumn(name = "cost_work")
//    private BigDecimal costWork;
//
//    @JoinColumn(name = "cost_material")
//    private BigDecimal costMaterial;
//
//    @JoinColumn(name = "cost_total")
//    private BigDecimal costTotal = costMaterial.add(costWork);



//
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinTable(name = "user_order", joinColumns = @JoinColumn(name = "order_id"),
//    inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<UserEntity> users = new ArrayList<UserEntity>();
//
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
//    @JoinColumn(name = "address_id")
//    private AddressEntity address;

//    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL}, orphanRemoval = true)
//    private List<WorkEntity> works = new ArrayList<WorkEntity>();
//

    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL}/*, orphanRemoval = true*/) //!!!!!!!!!!!!!!!!!
    private List<MaterialEntity> materials = new ArrayList<>();
}
