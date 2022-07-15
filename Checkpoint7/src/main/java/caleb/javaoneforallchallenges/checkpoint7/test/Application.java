package caleb.javaoneforallchallenges.checkpoint7.test;

import caleb.javaoneforallchallenges.checkpoint7.domain.*;

import javax.crypto.spec.PSource;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleService();
        Scanner sc = new Scanner(System.in);
        boolean exitProgram = false;
        while (!exitProgram) {
            int userMenuChoice = 10;
            while (userMenuChoice < 0 || userMenuChoice > 6 ) {
                vehicleService.printCarMenu();
                try {
                    userMenuChoice = sc.nextInt();
                } catch (InputMismatchException e) {
                    sc.next();
                }
            }
            if (userMenuChoice == 1) {
                vehicleService.printFoundModels(vehicleService.searchByAutomaker(vehicleService.userInput()));
            }
            if (userMenuChoice == 2) {
                vehicleService.printFoundVehicle(vehicleService.searchByModel(vehicleService.userInput()));
            }
            if (userMenuChoice == 3) {
                vehicleService.addNewVehicle();
            }
            if (userMenuChoice == 4) {
                vehicleService.updateVehicle();
            }
            if (userMenuChoice == 5) {
                vehicleService.deleteVehicleByModel(vehicleService.userInput());
            }
            if (userMenuChoice == 6) {
                vehicleService.generateReport(vehicleService.vehicleRepository.findAll());
            }
            if (userMenuChoice == 0) {
                exitProgram = true;
            }
        }
    }
}