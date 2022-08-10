package calebDoesJava.checkpoint8.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "automaker")
@Builder
public class Automaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "automakerID")
    @Schema(description = "The automaker ID", example = "78221788")
    private Integer automakerID;
    @Column(name = "automaker")
    @Schema(description = "The automaker name", example = "Volkswagen")
    private String name;
}
