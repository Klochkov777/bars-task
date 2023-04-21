package priv.klochkov.constructionwork.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "emails")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    CustomerEntity customer;

//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinColumn(name = "user_id")
//    UserEntity user;


}
