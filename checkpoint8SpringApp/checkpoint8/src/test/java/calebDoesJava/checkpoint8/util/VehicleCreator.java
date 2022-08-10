package calebDoesJava.checkpoint8.util;

import calebDoesJava.checkpoint8.domain.Automaker;
import calebDoesJava.checkpoint8.domain.Vehicle;
import calebDoesJava.checkpoint8.domain.VehicleSort;

public class VehicleCreator {
    public static Automaker createAutomaker () {
        return Automaker.builder()
                .automakerID(784515782)
                .name("Alfa Romeo")
                .build();
    }
    public static VehicleSort createVehicleSort() {
        return VehicleSort.builder()
                .vehicleSortID(987654321)
                .vehicleSort("CAR")
                .build();
    }
    public static Vehicle createVehicle () {
        return Vehicle.builder()
                .model("Giulia")
                .color("Blue")
                .year(2020)
                .automaker(createAutomaker())
                .vehicleSort(createVehicleSort())
                .modified("2021-09-09T18:50:08Z")
                .build();
    }
    public static Vehicle createUpdatedVehicle () {
        return Vehicle.builder()
                .model("F150")
                .color("Blue")
                .year(2020)
                .automaker(createAutomaker())
                .vehicleSort(createVehicleSort())
                .modified("2021-09-09T18:50:08Z")
                .build();
    }


}
