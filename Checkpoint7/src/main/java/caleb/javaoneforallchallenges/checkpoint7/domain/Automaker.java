package caleb.javaoneforallchallenges.checkpoint7.domain;

import lombok.Builder;
import lombok.Value;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Value
@Builder
public class Automaker {
    private Integer id;
    private String name;
}
