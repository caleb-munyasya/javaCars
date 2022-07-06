package caleb.javaoneforallchallenges.checkpoint5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleService {
    public VehicleRepository vehicleRepository = new VehicleRepository();

    public List<Vehicle> searchByAutomaker(String searchTermPassed) {
        List<Vehicle> foundVehicles = vehicleRepository.vehicleArrayList.stream()
                .filter(vehicle -> vehicle.automaker.getName().equalsIgnoreCase(searchTermPassed))
                .collect(Collectors.toList());
        return foundVehicles;
    }

    public Vehicle searchByModel(String searchTermPassed) {
        for (Vehicle vehicle : this.vehicleRepository.vehicleArrayList) {
            if (vehicle.getModel().equalsIgnoreCase(searchTermPassed)) {
                return vehicle;
            }
        }
        return null;
    }

    public void updateVehicle(Vehicle currentVehicle, Vehicle replacementVehicle) {
        int vehicleArrayPosition = 100;
        for (int i = 0; i < vehicleRepository.vehicleArrayList.size(); i++) {
            if (vehicleRepository.vehicleArrayList.get(i).getModel().equals(currentVehicle.getModel())) {
                vehicleArrayPosition = i;
            }
        }
        vehicleRepository.vehicleArrayList.set(vehicleArrayPosition, replacementVehicle);
    }

    public void deleteVehicleByModel() {
        Scanner sc6 = new Scanner(System.in);
        System.out.println("Please (re)enter the model of the vehicle you would like to remove from the repository?");
        String modelToDelete = sc6.nextLine();

        Vehicle vehicleToRemove = searchByModel(modelToDelete);

        if (vehicleRepository.vehicleArrayList.contains(vehicleToRemove)) {
            vehicleRepository.vehicleArrayList.remove(vehicleToRemove);
        }
        else {
            System.out.println("It appears that the model you want to delete is not in the repository");
        }
    }

    public Automaker checkAutomaker() {
        Scanner sc7 = new Scanner(System.in);
        int newAutomakerSelection = 100;
        while (!(newAutomakerSelection > 0 && newAutomakerSelection < 7)) {
            System.out.println("Please select which automaker created this model:");
            System.out.println("1 - GM");
            System.out.println("2 - Hyundai");
            System.out.println("3 - Volkswagon");
            System.out.println("4 - Audi");
            System.out.println("5 - Mercedes");
            System.out.println("6 - Peugeot");

            newAutomakerSelection = sc7.nextInt();
        }

        Automaker newAutomaker = null;

        if (newAutomakerSelection == 1) {
            newAutomaker = vehicleRepository.automakerArray[0];
        }
        if (newAutomakerSelection == 2) {
            newAutomaker = vehicleRepository.automakerArray[1];
        }
        if (newAutomakerSelection == 3) {
            newAutomaker = vehicleRepository.automakerArray[2];
        }
        if (newAutomakerSelection == 4) {
            newAutomaker = vehicleRepository.automakerArray[3];
        }
        if (newAutomakerSelection == 5) {
            newAutomaker = vehicleRepository.automakerArray[4];
        }
        if (newAutomakerSelection == 6) {
            newAutomaker = vehicleRepository.automakerArray[5];
        }

        return newAutomaker;
    }

    public String vehicleIsUnique() {
        Scanner scInput = new Scanner(System.in);
        boolean duplicateFound = false;
        boolean passsedDuplicateCheck = false;
        String newModel = "";

        while (!passsedDuplicateCheck) {
            duplicateFound = false;
            System.out.println("-------------------------------------------------------------");
            System.out.println("Please enter a UNIQUE model of the vehicle you would like to add: ");
            newModel = scInput.nextLine();

            for (int i = 0; i < vehicleRepository.vehicleArrayList.size(); i++) {
                if (vehicleRepository.vehicleArrayList.get(i).getModel().equals(newModel)) {
                    duplicateFound = true;
                }
            }

            if (duplicateFound == true) {
                passsedDuplicateCheck = false;
            } else {
                passsedDuplicateCheck = true;
            }
        }
        return newModel;
    }

    public void addNewVehicle() {
        Scanner sc3 = new Scanner(System.in);

        System.out.println("You are about to add a new Vehicle to the database.");
        String newModel = vehicleIsUnique();

        System.out.println("Please enter the color of the " + newModel + ": ");
        String newColor = sc3.nextLine();

        int newYear = 1;
        while (!(newYear >= 1980 && newYear <= 2022)) {
            System.out.println("Please enter the Year in which the " + newModel + " was made: ");
            newYear = sc3.nextInt();
        }
        Automaker newAutomaker = checkAutomaker();

        int vehicleType = 0;
        Vehicle newVehicle = new Car(newModel, newColor, newYear, newAutomaker);
        Scanner vehicleTypeInput = new Scanner(System.in);

        while (vehicleType < 1 || vehicleType > 6) {
            System.out.println("What type of vehicle is this?");
            System.out.println("Choose one of the below options: ");
            System.out.println("1 - Car");
            System.out.println("2 - Motorcycle");
            System.out.println("3 - Van");
            System.out.println("4 - Truck");
            System.out.println("5 - Pickup");
            System.out.println("6 - Others");

            vehicleType = vehicleTypeInput.nextInt();
            if (vehicleType == 1) {
                newVehicle = new Car(newModel, newColor, newYear, newAutomaker);
            }
            if (vehicleType == 2) {
                newVehicle = new Motorcycle(newModel, newColor, newYear, newAutomaker);
            }
            if (vehicleType == 3) {
                newVehicle = new Van(newModel, newColor, newYear, newAutomaker);
            }
            if (vehicleType == 4) {
                newVehicle = new Truck(newModel, newColor, newYear, newAutomaker);
            }
            if (vehicleType == 5) {
                newVehicle = new Pickup(newModel, newColor, newYear, newAutomaker);
            }
            if (vehicleType == 6) {
                newVehicle = new Others(newModel, newColor, newYear, newAutomaker);
            }
        }
        addVehicle(newVehicle);
        searchByAutomaker(newVehicle.automaker.getName());
    }

    public void addVehicle(Vehicle newVehicle) {


        vehicleRepository.vehicleArrayList.add(newVehicle);
        System.out.println("Thank you for registering this new Vehicle in our database...");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Here is the updated list for the vehicles made by " + newVehicle.automaker.getName() + ":");
        System.out.println("-------------------------------------------------------------");
    }

    public void updateVehicle() {
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);
        System.out.println("Please enter a model to search for: ");
        Scanner scanner = new Scanner(System.in);
        String modelSearch = scanner.nextLine();
        Vehicle vehicleSelection = searchByModel(modelSearch);
        vehicleSelection.toString();
        Vehicle updateVehicle = new Car(vehicleSelection.getModel(), vehicleSelection.getColor(),
                vehicleSelection.getYear(), vehicleSelection.automaker);

        String updatedModel = updateVehicle.getModel();

        int featureToUpdate = 0;
        while (featureToUpdate < 1 || featureToUpdate > 5) {
            System.out.println("Please select attribute would you like to update:");
            System.out.println("1 - Model");
            System.out.println("2 - Color");
            System.out.println("3 - Year");
            System.out.println("4 - Automaker");
            System.out.println("5 - Vehicle Type");

            featureToUpdate = sc4.nextInt();

        }

        if (featureToUpdate == 1) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Please enter the new Model name: ");
            String newModel = vehicleIsUnique();
            updatedModel = newModel;
            updateVehicle.setModel(newModel);
            updateVehicle(vehicleSelection, updateVehicle);
        }
        if (featureToUpdate == 2) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Please enter the new color: ");
            String newColor = sc5.nextLine();
            updateVehicle.setColor(newColor);
            updateVehicle(vehicleSelection, updateVehicle);
        }
        if (featureToUpdate == 3) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Please enter the new Manufacturing year");
            int newYear = sc5.nextInt();
            updateVehicle.setYear(newYear);
            updateVehicle(vehicleSelection, updateVehicle);
        }
        if (featureToUpdate == 4) {
            System.out.println("-------------------------------------------------------------");
            Automaker newAutomaker = checkAutomaker();
            updateVehicle.automaker = newAutomaker;
            updateVehicle(vehicleSelection, updateVehicle);
        }
        if (featureToUpdate == 5) {
            int proceed = 3;
            Scanner proceedCheck = new Scanner(System.in);
            while (proceed != 0 && proceed != 1) {
                System.out.println("If you would like to update the Vehicle type, you will have to re-enter all features.");
                System.out.println("Press 1 to delete " + updateVehicle.getModel() + " or press 0 to return to the main menu");
                proceed = proceedCheck.nextInt();
            }

            if (proceed == 1) {
                deleteVehicleByModel();
                addNewVehicle();
            }

        }
        System.out.println("Update successful... ");

        searchByModel(updatedModel);
    }

    public String userInput() {
        System.out.println("Please enter a search term: ");
        Scanner scanner = new Scanner(System.in);
        String userSearch = scanner.nextLine();
        return (userSearch);
    }

    public void printCarMenu() {
        String mainCarMenu = ("------------------------------------------------------------------------------\n" +
                "------------------------------------------------------------------------------\n" +
                "Welcome to the Car Selection Menu\n" +
                "------------------------------------------------------------------------------\n" +
                "------------------------------------------------------------------------------\n" +
                "1 - Search by Automaker\n" +
                "2 - Search by Model\n" +
                "3 - Add new Vehicle model to Vehicle Repository\n" +
                "4 - Update Vehicle\n" +
                "5 - Delete Vehicle\n" +
                "6 - Generate Report File\n" +
                "\n------------------------------------------------------------------------------" +
                "\n*** (You can also press '0' to exit the program) ***" +
                "\n------------------------------------------------------------------------------" +
                "\n------------------------------------------------------------------------------");

        System.out.println(mainCarMenu);

    }

    public void generateReport() {

        for (Vehicle vehicle : vehicleRepository.vehicleArrayList) {

            System.out.println("#-------------------------------------------------------------------#");
            System.out.println("Registration Date: " + vehicle.reportFormCreatedAt);
            System.out.println("Automaker: " + vehicle.automaker.getName());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Type: " + vehicle.getVehicleType());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Year: " + vehicle.getYear());
        }
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
    }

    public void printFoundModels(List<Vehicle> foundVehicles) {
        if (foundVehicles.isEmpty()){
            System.out.println("No Vehicles found from this automaker");
        } else {
            System.out.println("Found the following Vehicle(s): ");
            for (Vehicle vehicle : foundVehicles) {
                System.out.println("* " + vehicle.getModel());
            }
        }
    }

    public void printFoundVehicle(Vehicle foundVehicle) {
        if (foundVehicle != null) {
            System.out.println(foundVehicle.toString());
        }
        else {
            System.out.println("Unfortunately we were unable to find this particular Vehicle");
        }

    }
}



