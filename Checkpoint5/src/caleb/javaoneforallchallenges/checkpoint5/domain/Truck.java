package caleb.javaoneforallchallenges.checkpoint5.domain;

public class Truck extends Vehicle{

    public Truck(String model, String color, int year, Automaker automaker) {
        super(model, color, year, automaker);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.TRUCK;
    }
}
