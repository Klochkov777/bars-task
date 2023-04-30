package priv.klochkov.constructionwork.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
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
    private String surname;

    @Column(name = "name_by_father")
    private String nameByFather;

    @Column(name = "passport_number")
    private String passportNumber;

//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "email_id")
    private EmailEntity emailEntity;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> numbersPhone = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<OrderEntity> orders = new ArrayList<OrderEntity>();

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
