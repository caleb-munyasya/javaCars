package caleb.javaoneforallchallenges.checkpoint5.domain;

import java.util.Random;

public class Automaker {
    private String name;
    private Integer id;

    public Automaker (String name) {
        this.name = name;
        Random random = new Random();
        int upperbound = 100000000;
        int int_random = random.nextInt(upperbound);
        this.id = int_random;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj ==null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        Automaker otherAutomaker = (Automaker) obj;
        return id != null && id.equals(otherAutomaker.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }


}
