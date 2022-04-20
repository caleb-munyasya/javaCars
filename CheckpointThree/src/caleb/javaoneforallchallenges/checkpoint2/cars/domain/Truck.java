package caleb.javaoneforallchallenges.checkpoint2.cars.domain;

public class Truck extends Vehicle{

    public Truck(String model, String color, int year, Automaker automaker) {
        super(model, color, year, automaker);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.TRUCK;
    }
}
