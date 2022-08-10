package calebDoesJava.checkpoint8.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sort")
@Builder
public class VehicleSort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Schema(description = "The ID for the type of Vehicle", example = "875412569")
    Integer vehicleSortID;
    @Column(name = "sort")
    @Schema(description = "The name for the type of Vehicle", example = "CAR")
    String vehicleSort;
}
