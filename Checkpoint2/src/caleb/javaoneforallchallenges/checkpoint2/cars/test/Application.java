package caleb.javaoneforallchallenges.checkpoint2.cars.test;

import caleb.javaoneforallchallenges.checkpoint2.cars.domain.Automaker;
import caleb.javaoneforallchallenges.checkpoint2.cars.domain.Vehicle;
import caleb.javaoneforallchallenges.checkpoint2.cars.domain.VehicleService;
import caleb.javaoneforallchallenges.checkpoint2.cars.domain.CarsMenu;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleService();
        CarsMenu carsMenu = new CarsMenu();
        Scanner sc = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {

            int userMenuChoice = 10;
            while (userMenuChoice != 0 && userMenuChoice != 1 && userMenuChoice != 2 && userMenuChoice != 3 && userMenuChoice != 4 && userMenuChoice != 5) {
                carsMenu.printCarMenu();
                userMenuChoice = sc.nextInt();
            }

            if (userMenuChoice == 1) {
                Vehicle[] searchResult = vehicleService.searchByAutomaker(vehicleService.vehicleRepository.vehicleArray, null);
                carsMenu.printAvailableModels(searchResult);
                if (!carsMenu.returnToMainMenu()) {
                    exitProgram = true;
                }
            }
            if (userMenuChoice == 2) {
                Vehicle vehicleSelection = vehicleService.searchByModel(vehicleService.vehicleRepository.vehicleArray, null);
                vehicleSelection.prettyPrint();

                if (!carsMenu.returnToMainMenu()){
                    exitProgram =true;
                }

            }

            if (userMenuChoice == 3) {
                Scanner sc3 = new Scanner(System.in);
                System.out.println("You are about to add a new vehicle to the database.");

                String newModel = vehicleService.vehicleIsUnique();

                System.out.println("Please enter the color of the " + newModel + ": ");
                String newColor = sc3.nextLine();
                int newYear = 1;
                while (!(newYear >= 1980 && newYear <= 2022)) {
                    System.out.println("Please enter the Year in which the " + newModel + " was made: ");
                    newYear = sc3.nextInt();
                }
                //Automaker existence Check
                Automaker newAutomaker = vehicleService.automakerCheck();

                Vehicle newVehicle = new Vehicle(newModel,newColor,newYear, newAutomaker);
                vehicleService.addVehicle(newVehicle);

                //Printing updated list of Automaker's model
                Vehicle[] searchResultNew = vehicleService.searchByAutomaker(vehicleService.vehicleRepository.vehicleArray, newVehicle.automaker.getName());
                carsMenu.printAvailableModels(searchResultNew);

                if (!carsMenu.returnToMainMenu()){
                    exitProgram =true;
                }

            }

            if (userMenuChoice == 4) {
                Scanner sc4 = new Scanner(System.in);
                Scanner sc5 = new Scanner(System.in);
                Vehicle vehicleSelection = vehicleService.searchByModel(vehicleService.vehicleRepository.vehicleArray, null);
                vehicleSelection.prettyPrint();
                Vehicle updateVehicle = new Vehicle(vehicleSelection.getModel(), vehicleSelection.getColor(), vehicleSelection.getYear(), vehicleSelection.automaker);
                String updatedModel = updateVehicle.getModel();


                int featureToUpdate = 100;
                while (!(featureToUpdate > 0 && featureToUpdate < 5)) {
                    System.out.println("Please select attribute would you like to update:");
                    System.out.println("1 - Model");
                    System.out.println("2 - Color");
                    System.out.println("3 - Year");
                    System.out.println("4 - Automaker");

                    featureToUpdate = sc4.nextInt();

                }

                if (featureToUpdate == 1) {
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Please enter the new Model name: ");
                    String newModel = vehicleService.vehicleIsUnique();
                    updatedModel = newModel;
                    updateVehicle.setModel(newModel);
                }
                if (featureToUpdate == 2) {
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Please enter the new color: ");
                    String newColor = sc5.nextLine();
                    updateVehicle.setColor(newColor);
                }
                if (featureToUpdate == 3) {
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Please enter the new Manufacturing year");
                    int newYear = sc5.nextInt();
                    updateVehicle.setYear(newYear);
                }
                if (featureToUpdate == 4) {
                    System.out.println("-------------------------------------------------------------");
                    Automaker newAutomaker = vehicleService.automakerCheck();
                    updateVehicle.automaker = newAutomaker;
                }

                vehicleService.updateVehicle(vehicleSelection, updateVehicle);

                System.out.println("Update successful... ");

                Vehicle searchResult = vehicleService.searchByModel(vehicleService.vehicleRepository.vehicleArray, updatedModel);
                searchResult.prettyPrint();

                if (!carsMenu.returnToMainMenu()){
                    exitProgram =true;
                }

            }

            if (userMenuChoice == 5) {
                Scanner sc6 = new Scanner(System.in);
                System.out.println("What is the model of the vehicle you would like to remove from the repository?");
                String modelToDelete = sc6.nextLine();
                vehicleService.deleteVehicleByModel(modelToDelete);

                if (!carsMenu.returnToMainMenu()){
                    exitProgram =true;
                }

            }

            if (userMenuChoice == 0) {
                exitProgram = true;
            }
        }
    }
}