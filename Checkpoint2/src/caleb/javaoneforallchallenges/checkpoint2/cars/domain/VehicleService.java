package caleb.javaoneforallchallenges.checkpoint2.cars.domain;

import caleb.javaoneforallchallenges.checkpoint2.cars.test.CarsMenu;

import java.util.Scanner;

public class VehicleService {
    public VehicleRepository vehicleRepository = new VehicleRepository();

    public Vehicle[] searchByAutomaker(Vehicle[] vehicles) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What automaker's vehicles are you searching for? ");
        String userSearchTerm;
        boolean validAutomaker = false;
        String[] automaker = new String[6];
        Vehicle[] userSearchResultArray = new Vehicle[3];

        while (!validAutomaker) {
            userSearchTerm = sc.nextLine();

            int newArraySize = 0;

            //Loop to determine size of new array
            for (int i = 0; i < vehicles.length; i++) {
                if (vehicles[i].automaker.getName().equals(userSearchTerm)) {
                    newArraySize++;
                }
            }

            userSearchResultArray = new Vehicle[newArraySize];


            int vehicleCounter = 0;
            //Adding the models to the new array
            for (int j = 0; j < vehicles.length; j++) {
                if (vehicles[j].automaker.getName().equals(userSearchTerm)) {
                    userSearchResultArray[vehicleCounter] = vehicles[j];
                    vehicleCounter++;
                    validAutomaker = true;
                }
            }
            if (!validAutomaker) {
                System.out.println("It seems you have entered a automaker not found in our database. Please try again:");
                System.out.println("** tip: Try capitalizing only the first letter if you spell out the automaker name");
            }
        }



//        int finalArraySize = 0;
//        for (int i = 0; i < userSearchResultArray.length; i++) {
//            if (!userSearchResultArray[i].equals(null)) {
//                finalArraySize ++;
//            } else {
//                continue;
//            }
//        }

//        System.out.println(finalArraySize);
//
//        Vehicle[] finalArray = new Vehicle[finalArraySize];
//        for (int i = 0; i < finalArraySize; i++) {
//            finalArray[i] = userSearchResultArray[i];
//        }

        return userSearchResultArray;
}

    public Vehicle searchByModel(Vehicle[] vehicles) {
        Scanner sc = new Scanner(System.in);
        CarsMenu carsMenu = new CarsMenu();
        String userSearchTerm;
        boolean validModel = false;
        Vehicle vehicleSelection = null;


        while (!validModel) {
            System.out.println("What model car are you searching for? ");
            userSearchTerm = sc.nextLine();

            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(userSearchTerm)) {
                    validModel = true;
                    vehicleSelection = vehicle;
                }
            }
            System.out.println("It appears you have not entered a valid model.");
            System.out.println("** tip: Try to only capitalize the first letter");
        }
        return vehicleSelection;
    }

    public void addVehicle(Vehicle newVehicle) {


        //Replacing current Vehicle Array with an updated one which includes the new vehicle
        int sizeOfCurrentVehicleArray = vehicleRepository.vehicleArray.length;
        Vehicle[] newVehicleArray = new Vehicle[vehicleRepository.vehicleArray.length + 1];

        for (int i = 0; i < vehicleRepository.vehicleArray.length; i++) {
            newVehicleArray[i] = vehicleRepository.vehicleArray[i];
        }
        newVehicleArray[sizeOfCurrentVehicleArray] = newVehicle;
        vehicleRepository.vehicleArray = newVehicleArray;
        System.out.println("Thank you for registering this new vehicle in our database...");
        System.out.println("Here is the updated list for the vehicles made by " + newVehicle.automaker.getName() + ":");
        System.out.println("-------------------------------------------------------------");


    }

    public void updateVehicle() {

    }
}

