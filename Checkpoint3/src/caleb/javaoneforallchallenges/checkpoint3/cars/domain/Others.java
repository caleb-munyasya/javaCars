package caleb.javaoneforallchallenges.checkpoint3.cars.domain;

public class Others extends Vehicle{

    public Others(String model, String color, int year, Automaker automaker) {
        super(model, color, year, automaker);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.OTHERS;
    }
}
