package caleb.javaoneforallchallenges.checkpoint3.cars.test;

import caleb.javaoneforallchallenges.checkpoint3.cars.domain.Vehicle;
import caleb.javaoneforallchallenges.checkpoint3.cars.domain.VehicleService;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleService();
        Scanner sc = new Scanner(System.in);

        boolean exitProgram = false;
        while (!exitProgram) {

            int userMenuChoice = 10;
            while (userMenuChoice < 0 || userMenuChoice > 5) {
                vehicleService.printCarMenu();
                userMenuChoice = sc.nextInt();
            }
            if (userMenuChoice == 1) {
                vehicleService.searchByAutomaker(vehicleService.userInput());
            }
            if (userMenuChoice == 2) {
                Vehicle foundModel = vehicleService.searchByModel(vehicleService.userInput());
                foundModel.prettyPrint();
            }
            if (userMenuChoice == 3) {
                vehicleService.addNewVehicle();
            }
            if (userMenuChoice == 4) {
                vehicleService.updateVehicle();
            }
            if (userMenuChoice == 5) {
                vehicleService.deleteVehicleByModel();
            }
            if (userMenuChoice == 0) {
                exitProgram = true;
            }
        }
    }
}