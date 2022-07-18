package caleb.javaoneforallchallenges.checkpoint7.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Automaker {
    private Integer id;
    private String name;
}
