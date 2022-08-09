package calebDoesJava.checkpoint8.domain;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;

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
    private String model;

    @NotNull
    @NotEmpty(message = "The color cannot be empty")
    @Column (name = "color")
    private String color;

    @NotNull
    @Column (name = "year")
    private Integer year;

    @NotNull
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="automakerID", referencedColumnName = "automakerID")
    protected Automaker automaker;

    @NotNull
    @NotEmpty(message = "The  modified timestamp field cannot be empty")
    @Column (name = "modified")
    protected String modified;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "vehicleID")
    private Integer id;

    @NotNull
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "sortID", referencedColumnName = "id")
    protected VehicleSort vehicleSort;
}
