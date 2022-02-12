package caleb.javaoneforallchallenges.checkpoint2.cars.domain;

import caleb.javaoneforallchallenges.checkpoint2.cars.test.CarsMenu;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleService();
        CarsMenu carsMenu = new CarsMenu();
        Scanner sc = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {

            int userMenuChoice = 10;
            while (userMenuChoice != 0 && userMenuChoice != 1 && userMenuChoice != 2 && userMenuChoice != 3) {
                carsMenu.printCarMenu();
                userMenuChoice = sc.nextInt();
            }

            if (userMenuChoice == 1) {
                Vehicle[] searchResult = vehicleService.searchByAutomaker(vehicleService.vehicleRepository.vehicleArray);
                carsMenu.printAvailableModels(searchResult);
                if (!carsMenu.returnToMainMenu()) {
                    exitProgram = true;
                }
            }
            if (userMenuChoice == 2) {
                Vehicle vehicleSelection = vehicleService.searchByModel(vehicleService.vehicleRepository.vehicleArray);
                vehicleSelection.prettyPrint();

                if (!carsMenu.returnToMainMenu()){
                    exitProgram =true;
                }

            }

            if (userMenuChoice == 3) {
                Scanner sc3 = new Scanner(System.in);
                System.out.println("You are about to add a new vehicle to the database.");
                System.out.println("Please enter the vehicle model: ");
                String newModel = sc3.nextLine();
                System.out.println("Please enter the color of the " + newModel + ": ");
                String newColor = sc3.nextLine();
                System.out.println("Please enter the Year in which the " + newModel + " was made: ");
                int newYear = sc3.nextInt();

                //Making sure the car model is made by an existing Automaker
                int newAutomakerSelection = 100;
                while (!(newAutomakerSelection > 0 && newAutomakerSelection < 7)) {
                    System.out.println("Please select which automaker created this model:");
                    System.out.println("1 - GM");
                    System.out.println("2 - Hyundai");
                    System.out.println("3 - Volkswagon");
                    System.out.println("4 - Audi");
                    System.out.println("5 - Mercedes");
                    System.out.println("6 - Peugeot");

                    newAutomakerSelection = sc.nextInt();
                }

                //Setting Vehicle's automaker equal to one in database
                Automaker newAutomaker = null;

                if (newAutomakerSelection == 1) {
                    newAutomaker = vehicleService.vehicleRepository.automakerArray[0];
                }
                if (newAutomakerSelection == 2) {
                    newAutomaker = vehicleService.vehicleRepository.automakerArray[1];
                }
                if (newAutomakerSelection == 3) {
                    newAutomaker = vehicleService.vehicleRepository.automakerArray[2];
                }
                if (newAutomakerSelection == 4) {
                    newAutomaker = vehicleService.vehicleRepository.automakerArray[3];
                }
                if (newAutomakerSelection == 5) {
                    newAutomaker = vehicleService.vehicleRepository.automakerArray[4];
                }
                if (newAutomakerSelection == 6) {
                    newAutomaker = vehicleService.vehicleRepository.automakerArray[5];
                }

                Vehicle newVehicle = new Vehicle(newModel,newColor,newYear, newAutomaker);
                vehicleService.addVehicle(newVehicle);

                //Printing updated list of Automaker's model
                Vehicle[] searchResultNew = vehicleService.searchByAutomaker(vehicleService.vehicleRepository.vehicleArray);
                carsMenu.printAvailableModels(searchResultNew);


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