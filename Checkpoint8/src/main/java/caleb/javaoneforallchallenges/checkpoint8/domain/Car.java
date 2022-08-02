package caleb.javaoneforallchallenges.checkpoint8.domain;

public class Car extends Vehicle{

    public Car(String model, String color, int year, Automaker automakerID) {
        super(model, color, year, automakerID);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.CAR;
    }
}
