package caleb.javaoneforallchallenges.checkpoint7.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleService {
    public VehicleRepository vehicleRepository = new VehicleRepository();
    AutomakerService automakerService = new AutomakerService();

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
        Scanner sc7 = new Scanner(System.in);
        int newAutomakerSelection = 100;
        while (!(newAutomakerSelection > 0 && newAutomakerSelection < 7)) {
            System.out.println("Please select which automaker created this model:");
            System.out.println("1 - GM");
            System.out.println("2 - Hyundai");
            System.out.println("3 - Volkswagen");
            System.out.println("4 - Audi");
            System.out.println("5 - Mercedes");
            System.out.println("6 - Peugeot");

            newAutomakerSelection = sc7.nextInt();
        }

        Automaker newAutomaker = null;

        if (newAutomakerSelection == 1) {
            newAutomaker = automakerService.searchByName("GM");
        }
        if (newAutomakerSelection == 2) {
            newAutomaker = automakerService.searchByName("Hyundai");

        }
        if (newAutomakerSelection == 3) {
            newAutomaker = automakerService.searchByName("Volkswagen");

        }
        if (newAutomakerSelection == 4) {
            newAutomaker = automakerService.searchByName("Audi");

        }
        if (newAutomakerSelection == 5) {
            newAutomaker = automakerService.searchByName("Mercedes");

        }
        if (newAutomakerSelection == 6) {
            newAutomaker = automakerService.searchByName("Peugeot");

        }

        return newAutomaker;
    }

    public String vehicleIsUnique() {
        Scanner searchScanner = new Scanner(System.in);
        String newModel = searchScanner.nextLine();
        Vehicle foundModel = searchByModel(newModel);
        while (foundModel!=null) {
            System.out.println("This model is already in our database. Please enter a unique name");
            newModel = searchScanner.nextLine();
            foundModel = searchByModel(newModel);
        }
        return newModel;
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

    public Vehicle updateVehicle() {

        Vehicle vehicleToUpdate = vehicleRepository.findByModel(userInput());
        Vehicle replacementVehicle = new Car(vehicleToUpdate.getModel(),vehicleToUpdate.getColor(),
                vehicleToUpdate.getYear(), vehicleToUpdate.automaker);

        if (vehicleToUpdate != null) {
            Scanner featureMenuScanner = new Scanner(System.in);
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
                vehicleRepository.replaceVehicle(replacementVehicle,vehicleToUpdate);
            }
            if (featureToUpdate == 2) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Please enter the new color: ");
                String newColor = featureMenuInput.nextLine();
                replacementVehicle.setColor(newColor);
                vehicleRepository.replaceVehicle(replacementVehicle,vehicleToUpdate);
            }
            if (featureToUpdate == 3) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Please enter the new Manufacturing year");
                int newYear = featureMenuInput.nextInt();
                replacementVehicle.setYear(newYear);
                vehicleRepository.replaceVehicle(replacementVehicle,vehicleToUpdate);
            }
            if (featureToUpdate == 4) {
                System.out.println("-------------------------------------------------------------");
                Automaker newAutomaker = checkAutomaker();
                replacementVehicle.automaker = newAutomaker;
                vehicleRepository.replaceVehicle(replacementVehicle,vehicleToUpdate);
            }
            if (featureToUpdate == 5) {
                int proceed = 3;
                Scanner proceedCheck = new Scanner(System.in);
                while (proceed != 0 && proceed != 1) {
                    System.out.println("If you would like to update the Vehicle type, you will have to re-enter all features.");
                    System.out.println("Press 1 to delete " + replacementVehicle.getModel() + " or press 0 to return to the main menu");
                    proceed = proceedCheck.nextInt();
                }

                if (proceed == 1) {
                    deleteVehicleByModel(userInput());
                    addNewVehicle();
                }

            }
        } else {
            System.out.println("Sorry,we couldn't find this model in the database");
        }
            return null;
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

    public void generateReport(List <Vehicle> vehicleList) {

        for (Vehicle vehicle : vehicleList) {

            System.out.println("#-------------------------------------------------------------------#");
            System.out.println("Registration Date: " + vehicle.getCreatedAt());
            System.out.println("Automaker: " + vehicle.automaker.getName());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Type: " + vehicle.getVehicleType());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Year: " + vehicle.getYear());
            System.out.println("ID: " +vehicle.getId());
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
}



