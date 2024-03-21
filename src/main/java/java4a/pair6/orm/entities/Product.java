package java4a.pair6.orm.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table(name="products")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Column(name="product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name="package_height")
    private String packageHeight;

    @Column(name="package_width")
    private String packageWidth;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_photo_url")
    private String productPhotoUrl;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="unit_in_stock")
    private int unitInStock;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();

    @ManyToMany(mappedBy = "products")
    private Set<Seller> sellers = new HashSet<>();
  
}
