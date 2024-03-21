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
@Table(name="cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @JsonIgnore
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddresses;

}
