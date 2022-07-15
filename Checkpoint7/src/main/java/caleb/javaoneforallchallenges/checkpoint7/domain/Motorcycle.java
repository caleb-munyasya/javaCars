package caleb.javaoneforallchallenges.checkpoint7.domain;

public class Motorcycle extends Vehicle{

    public Motorcycle(String model, String color, int year, Automaker automaker) {
        super(model, color, year, automaker);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.MOTORCYCLE;
    }
}
