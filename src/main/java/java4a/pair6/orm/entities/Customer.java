package java4a.pair6.orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "customer_id", referencedColumnName = "id")
@Table(name="customers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
    
}
