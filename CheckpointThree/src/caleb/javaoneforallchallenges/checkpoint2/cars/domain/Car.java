package caleb.javaoneforallchallenges.checkpoint2.cars.domain;

public class Car extends Vehicle{

    public Car(String model, String color, int year, Automaker automaker) {
        super(model, color, year, automaker);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.CAR;
    }
}
