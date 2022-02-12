package caleb.javaoneforallchallenges.checkpoint2.cars.domain;

import java.util.Scanner;

public class VehicleService {
    public VehicleRepository vehicleRepository = new VehicleRepository();

    public Vehicle[] searchByAutomaker(Vehicle[] vehicles, String searchTermPassed) {
        Scanner sc = new Scanner(System.in);
        String userSearchTerm = searchTermPassed;
        boolean validAutomaker = false;
        String[] automaker = new String[6];
        Vehicle[] userSearchResultArray = new Vehicle[3];

        while (!validAutomaker) {
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
                System.out.println("What Automaker's vehicles are you searching for?");
                System.out.println("** tip: Try capitalizing only the first letter if you spell out the automaker name");
                userSearchTerm = sc.nextLine();
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

    public Vehicle searchByModel(Vehicle[] vehicles, String searchModel) {
        Scanner sc = new Scanner(System.in);
        CarsMenu carsMenu = new CarsMenu();
        String userSearchTerm = searchModel;
        boolean validModel = false;
        Vehicle vehicleSelection = null;


        while (!validModel) {

            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(userSearchTerm)) {
                    validModel = true;
                    vehicleSelection = vehicle;
                }
            }
            if (!validModel) {
                System.out.println("What model are you looking for?");
                System.out.println("** tip: Try to only capitalize the first letter");
                userSearchTerm = sc.nextLine();
            }
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
        System.out.println("-------------------------------------------------------------");
        System.out.println("Here is the updated list for the vehicles made by " + newVehicle.automaker.getName() + ":");
        System.out.println("-------------------------------------------------------------");
    }

    public void updateVehicle(Vehicle currentVehicle, Vehicle replacementVehicle) {

        int vehicleArrayPosition = 100;

        for (int i = 0; i < vehicleRepository.vehicleArray.length; i++) {
            if (vehicleRepository.vehicleArray[i].getModel().equals(currentVehicle.getModel())) {
                vehicleArrayPosition = i;
            }
        }

        vehicleRepository.vehicleArray[vehicleArrayPosition] = replacementVehicle;

    }

    public void deleteVehicleByModel (String modelToDelete) {
        int vehicleArrayPosition = 100;
        Vehicle[] updatedArray = new Vehicle[1];
        int newArrayInsertionPosition = 0;
        boolean modelIsNotInRepository = true;

        for (int i = 0; i < vehicleRepository.vehicleArray.length; i++) {
            if (vehicleRepository.vehicleArray[i].getModel().equals(modelToDelete)) {
                vehicleArrayPosition = i;
                modelIsNotInRepository = false;
                updatedArray = new Vehicle[vehicleRepository.vehicleArray.length - 1];
            }
        }

        for (int i = 0; i < vehicleRepository.vehicleArray.length; i++) {
            if (!(vehicleRepository.vehicleArray[i].getModel().equals(modelToDelete))) {
                updatedArray[newArrayInsertionPosition] = vehicleRepository.vehicleArray[i];
                newArrayInsertionPosition ++;
            }

        }

        System.out.println(vehicleRepository.vehicleArray.length);
        System.out.println(updatedArray.length);

        vehicleRepository.vehicleArray = updatedArray;

        if (modelIsNotInRepository == true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("It appears that the model you want to delete is not in the repository");
            System.out.println("------------------------------------------------------------------------------");
        }


    }
}
