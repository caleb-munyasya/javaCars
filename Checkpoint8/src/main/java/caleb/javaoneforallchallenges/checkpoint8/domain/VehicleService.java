package caleb.javaoneforallchallenges.checkpoint8.domain;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class VehicleService {
    public VehicleRepository vehicleRepository = new VehicleRepository();
    AutomakerService automakerService = new AutomakerService();
    VehicleTypeService vehicleTypeService = new VehicleTypeService();

    public List<Vehicle> searchByAutomaker(String searchTermPassed) {
        return vehicleRepository.findByAutomaker(searchTermPassed);
    }

    public Vehicle searchByModel(String searchTermPassed) {
        return vehicleRepository.findByModel(searchTermPassed);
    }

    public void deleteVehicleByModel(String modelToDelete) {
        vehicleRepository.removeVehicleByModel(modelToDelete);
    }

    public Automaker checkAutomaker() {
        List<Automaker> allAutomakers = automakerService.findAllAutomakers();


        System.out.println("The current automakers in the database are: ");
        for (Automaker automaker: allAutomakers
             ) {
            System.out.println("* " + automaker.getName());
        }
            String automakerName = userInput();
            Boolean isAlreadyPresent = allAutomakers.stream()
                    .map(Automaker::getName)
                    .filter(automakerName::equalsIgnoreCase)
                    .findFirst()
                    .isPresent();

            if (isAlreadyPresent) {
                return automakerService.searchByName(automakerName);
            }
                automakerService.Save(ThreadLocalRandom.current().nextInt(0, 10000000), automakerName);
                return automakerService.searchByName(automakerName);
    }

    public String vehicleIsUnique() {
        Scanner searchScanner = new Scanner(System.in);
        String newModel = searchScanner.nextLine();
        Vehicle foundModel = searchByModel(newModel);
        while (foundModel != null) {
            System.out.println("This model is already in our database. Please enter a unique name");
            newModel = searchScanner.nextLine();
            foundModel = searchByModel(newModel);
        }
        return newModel;
    }

    public void updateVehicle() {

        Vehicle vehicleToUpdate = vehicleRepository.findByModel(userInput());
        Vehicle replacementVehicle = new Vehicle(vehicleToUpdate.getModel(), vehicleToUpdate.getColor(),
                vehicleToUpdate.getYear(), vehicleToUpdate.automaker, vehicleToUpdate.getVehicleType());

        if (vehicleToUpdate != null) {
            Scanner featureMenuScanner = new Scanner(System.in);
            Scanner vehicleTypeScanner = new Scanner(System.in);
            Scanner featureMenuInput = new Scanner(System.in);

            int featureToUpdate = 0;
            while (featureToUpdate < 1 || featureToUpdate > 5) {
                System.out.println("Please select attribute would you like to update:");
                System.out.println("1 - Model");
                System.out.println("2 - Color");
                System.out.println("3 - Year");
                System.out.println("4 - Automaker");
                System.out.println("5 - Vehicle Type");

                featureToUpdate = featureMenuScanner.nextInt();

            }

            if (featureToUpdate == 1) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Please enter the new Model name: ");
                replacementVehicle.setModel(featureMenuInput.nextLine());
                vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
            }
            if (featureToUpdate == 2) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Please enter the new color: ");
                String newColor = featureMenuInput.nextLine();
                replacementVehicle.setColor(newColor);
                vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
            }
            if (featureToUpdate == 3) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Please enter the new Manufacturing year");
                int newYear = featureMenuInput.nextInt();
                replacementVehicle.setYear(newYear);
                vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
            }
            if (featureToUpdate == 4) {
                System.out.println("-------------------------------------------------------------");
                Automaker newAutomaker = checkAutomaker();
                replacementVehicle.automaker = newAutomaker;
                vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
            }
            if (featureToUpdate == 5) {
                int newVehicleType = 0;
                while (newVehicleType < 1 || newVehicleType > 6) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Please enter the new vehicle Type: ");
                System.out.println("1 - Car");
                System.out.println("2 - Pickup");
                System.out.println("3 - Motorcycle");
                System.out.println("4 - Van");
                System.out.println("5 - Truck");
                System.out.println("6 - Others");

                newVehicleType = vehicleTypeScanner.nextInt();

                }

                if (newVehicleType == 1) {
                    System.out.println("-------------------------------------------------------------");
                    replacementVehicle.setVehicleType(vehicleTypeService.searchByName("CAR"));
                    System.out.println(replacementVehicle.getVehicleType().getVehicleType());
                    System.out.println(replacementVehicle.toString());
                    vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
                }
                if (newVehicleType == 2) {
                    System.out.println("-------------------------------------------------------------");
                    replacementVehicle.setVehicleType(vehicleTypeService.searchByName("Pickup"));
                    vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
                }
                if (newVehicleType == 3) {
                    System.out.println("-------------------------------------------------------------");
                    replacementVehicle.setVehicleType(vehicleTypeService.searchByName("Motorcycle"));
                    vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
                }
                if (newVehicleType == 4) {
                    System.out.println("-------------------------------------------------------------");
                    replacementVehicle.setVehicleType(vehicleTypeService.searchByName("Van"));
                    vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
                }
                if (newVehicleType == 5) {
                    System.out.println("-------------------------------------------------------------");
                    replacementVehicle.setVehicleType(vehicleTypeService.searchByName("Truck"));
                    vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
                }
                if (newVehicleType == 6) {
                    System.out.println("-------------------------------------------------------------");
                    replacementVehicle.setVehicleType(vehicleTypeService.searchByName("Others"));
                    vehicleRepository.replaceVehicle(replacementVehicle, vehicleToUpdate);
                }

            }
        }
    }

    public String userInput() {
        System.out.println("Please enter a search term: ");
        Scanner scanner = new Scanner(System.in);
        String userSearch = scanner.nextLine();
        return (userSearch);
    }

    public void printVehicleMenu() {
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

    public void generateReport(List<Vehicle> vehicleList) {

        for (Vehicle vehicle : vehicleList) {

            System.out.println("#-------------------------------------------------------------------#");
            System.out.println("Registration Date: " + vehicle.getCreatedAt());
            System.out.println("Automaker: " + vehicle.automaker.getName());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Type: " + vehicle.getVehicleType().getVehicleType());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Year: " + vehicle.getYear());
            System.out.println("ID: " + vehicle.getId());
        }
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
    }

    public void printFoundModels(List<Vehicle> foundVehicles) {
        if (foundVehicles.isEmpty()) {
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
        } else {
            System.out.println("Unfortunately we were unable to find this particular Vehicle");
        }

    }

    public void addNewVehicle() {

        Scanner sc3 = new Scanner(System.in);
        System.out.println("You are about to add a new Vehicle to the database. Enter a new model name.");
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
                vehicleRepository.saveToDatabase(new Vehicle(newModel, newColor, newYear, newAutomaker, vehicleTypeService.searchByName("CAR")));
            }
            if (vehicleType == 2) {
                vehicleRepository.saveToDatabase(new Vehicle(newModel, newColor, newYear, newAutomaker, vehicleTypeService.searchByName("MOTORCYCLE")));
            }
            if (vehicleType == 3) {
                vehicleRepository.saveToDatabase(new Vehicle(newModel, newColor, newYear, newAutomaker, vehicleTypeService.searchByName("VAN")));
            }
            if (vehicleType == 4) {
                vehicleRepository.saveToDatabase(new Vehicle(newModel, newColor, newYear, newAutomaker, vehicleTypeService.searchByName("TRUCK")));
            }
            if (vehicleType == 5) {
                vehicleRepository.saveToDatabase(new Vehicle(newModel, newColor, newYear, newAutomaker, vehicleTypeService.searchByName("PICKUP")));
            }
            if (vehicleType == 6) {
                vehicleRepository.saveToDatabase(new Vehicle(newModel, newColor, newYear, newAutomaker, vehicleTypeService.searchByName("OTHERS")));
            }
        }
    }
}





