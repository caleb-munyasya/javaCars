package calebDoesJava.checkpoint8.domain;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @NotNull
    @NotEmpty(message = "The model name cannot be empty")
    @Column (name = "model")
    @Schema(description = "Vehicle model name", example = "Corola")
    private String model;

    @NotNull
    @NotEmpty(message = "The color cannot be empty")
    @Column (name = "color")
    @Schema(description = "Vehicle color", example = "yellow")
    private String color;

    @NotNull
    @Column (name = "year")
    @Schema(description = "The year the vehicle was built", example = "2020")
    private Integer year;

    @NotNull
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="automakerID", referencedColumnName = "automakerID")
    @Schema(description = "The Vehicle Automaker including the AutomakerID and AutomakerName")
    protected Automaker automaker;

    @NotNull
    @NotEmpty(message = "The  modified timestamp field cannot be empty")
    @Column (name = "modified")
    @Schema(description = "The timestamp at which the Vehicle was added to the Database", example = "2022-06-04T21:20:33Z")
    protected String modified;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "vehicleID")
    @Schema(description = "The VehicleID can be left blank at the System will generate this on it's own")
    private Integer id;

    @NotNull
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "sortID", referencedColumnName = "id")
    @Schema(description = "The type of Vehicle this model is")
    protected VehicleSort vehicleSort;
}
