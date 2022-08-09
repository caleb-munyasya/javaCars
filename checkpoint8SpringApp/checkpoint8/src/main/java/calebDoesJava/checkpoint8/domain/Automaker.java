package calebDoesJava.checkpoint8.domain;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "automaker")
public class Automaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "automakerID")
    private Integer automakerID;
    @Column(name = "automaker")
    private String name;
}
