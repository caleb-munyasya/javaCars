package caleb.javaoneforallchallenges.checkpoint8.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Automaker {
    private Integer id;
    private String name;
}
