package calebDoesJava.checkpoint8.domain;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sort")
public class VehicleSort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer vehicleSortID;
    @Column(name = "sort")
    String vehicleSort;
}
