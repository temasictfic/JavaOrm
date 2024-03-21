package java4a.pair6.orm.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private int regionId;

    @Column(name = "region_name")
    private String regionName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddresses;
}
