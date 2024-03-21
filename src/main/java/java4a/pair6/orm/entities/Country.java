package java4a.pair6.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="countries")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "country_name")
    private String countryName;

    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Region> regions;

    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddresses;

}
