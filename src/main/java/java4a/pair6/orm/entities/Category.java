package java4a.pair6.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Table(name="categories")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Column(name="category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    
    @Column(name="category_name")
    private String name;
    
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
