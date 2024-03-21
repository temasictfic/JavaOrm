package java4a.pair6.orm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "seller_id", referencedColumnName = "id")
@Table(name="sellers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User{

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website")
    private String website;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "seller_products", joinColumns = @JoinColumn(name = "sellerId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private Set<Product> products = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;

}
