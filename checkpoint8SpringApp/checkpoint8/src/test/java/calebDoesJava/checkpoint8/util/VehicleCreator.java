package calebDoesJava.checkpoint8.util;

import calebDoesJava.checkpoint8.domain.Automaker;
import calebDoesJava.checkpoint8.domain.Vehicle;
import calebDoesJava.checkpoint8.domain.VehicleSort;

public class VehicleCreator {
    public static Vehicle createVehicle () {
        return Vehicle.builder()
                .model("Giulia")
                .color("Blue")
                .year(2020)
                .automaker(new Automaker(784515782, "Alfa Romeo"))
                .vehicleSort(new VehicleSort(987654321, "CAR"))
                .modified("2021-09-09T18:50:08Z")
                .build();
    }
    public static Vehicle createUpdatedVehicle () {
        return Vehicle.builder()
                .model("F150")
                .color("Blue")
                .year(2020)
                .automaker(new Automaker(784515782, "Laferrari"))
                .vehicleSort(new VehicleSort(987654321, "CAR"))
                .modified("2021-09-09T18:50:08Z")
                .build();
    }


}
