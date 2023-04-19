package priv.klochkov.constructionwork.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "name_by_father")
    String nameByFather;

//
//    @JoinColumn(name = "name_by_father")
//    private String nameByFather;
//
//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
//    private EmailEntity emailEntity;

//    @ElementCollection(fetch = FetchType.EAGER)
//    private List<String> numbersPhone = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<OrderEntity> orders = new ArrayList<OrderEntity>();
}
