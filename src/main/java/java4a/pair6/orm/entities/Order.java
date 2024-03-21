package java4a.pair6.orm.entities;

import java.util.HashSet;
import java.util.Set;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table(name="orders")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Column(name="order_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name="shipped_date")
    private LocalDate shippedDate;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name="shipping_address_id")
    private ShippingAddress shippingAddress;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "order_products", 
        joinColumns = { @JoinColumn(name = "order_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private Set<Product> products = new HashSet<>();
}
