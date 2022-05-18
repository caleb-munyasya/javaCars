package caleb.javaoneforallchallenges.checkpoint3.cars.domain;

import java.util.Scanner;

public class VehicleService {
    public VehicleRepository vehicleRepository = new VehicleRepository();

    public void searchByAutomaker(String searchTermPassed) {
        Vehicle[] foundVehiclesFromAutomaker = new Vehicle[vehicleRepository.vehicleArray.length];
        int foundVehicles = 0;

        for (int i = 0; i < this.vehicleRepository.vehicleArray.length; i++) {
            if (vehicleRepository.vehicleArray[i].automaker.getName().equalsIgnoreCase(searchTermPassed)) {
                foundVehiclesFromAutomaker[foundVehicles] = vehicleRepository.vehicleArray[i];
                foundVehicles++;
            }
        }

        if (foundVehiclesFromAutomaker[0] == null) {
            System.out.println("Sorry we could not find any vehicles from that automaker");
            return;
        }

        System.out.println("The models available for the automaker " + foundVehiclesFromAutomaker[0].automaker.getName() + " are: ");
        for (Vehicle vehicle : foundVehiclesFromAutomaker) {
            if (vehicle != null) {
                System.out.println("* " + vehicle.getModel());
            }
        }
    }

    public Vehicle searchByModel(String searchTermPassed) {
        for (Vehicle vehicle : this.vehicleRepository.vehicleArray) {
            if (vehicle.getModel().equalsIgnoreCase(searchTermPassed)) {
                return vehicle;
            }
        }
        return null;
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

    public void deleteVehicleByModel() {
        Scanner sc6 = new Scanner(System.in);
        System.out.println("Please (re)enter the model of the vehicle you would like to remove from the repository?");
        String modelToDelete = sc6.nextLine();
        int vehicleArrayPosition = 100;
        Vehicle[] updatedArray = new Vehicle[1];
        int newArrayInsertionPosition = 0;
        boolean modelIsNotInRepository = true;

        for (int i = 0; i < vehicleRepository.vehicleArray.length; i++) {
            if (vehicleRepository.vehicleArray[i].getModel().equalsIgnoreCase(modelToDelete)) {
                vehicleArrayPosition = i;
                modelIsNotInRepository = false;
                updatedArray = new Vehicle[vehicleRepository.vehicleArray.length - 1];
            }
        }

        if (modelIsNotInRepository == true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("It appears that the model you want to delete is not in the repository");
            return;
        }

        for (int i = 0; i < vehicleRepository.vehicleArray.length; i++) {
            if (!(vehicleRepository.vehicleArray[i].getModel().equalsIgnoreCase(modelToDelete))) {
                updatedArray[newArrayInsertionPosition] = vehicleRepository.vehicleArray[i];
                newArrayInsertionPosition++;
            }

        }

        vehicleRepository.vehicleArray = updatedArray;

    }

    public Automaker checkAutomaker() {
        //Making sure the car model is made by an existing Automaker
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

        //Setting Vehicle's automaker equal to one in database
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

            for (int i = 0; i < vehicleRepository.vehicleArray.length; i++) {
                if (vehicleRepository.vehicleArray[i].getModel().equals(newModel)) {
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
        //Checking if Automaker is a part of the Database
        Automaker newAutomaker = checkAutomaker();

        //Adding new Vehicle to the Repository
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
        //Printing updated list of Automaker's model
        searchByAutomaker(newVehicle.automaker.getName());
    }

    public void addVehicle(Vehicle newVehicle) {


        //Replacing current Vehicle Array with an updated one which includes the new Vehicle
        int sizeOfCurrentVehicleArray = vehicleRepository.vehicleArray.length;
        Vehicle[] newVehicleArray = new Vehicle[vehicleRepository.vehicleArray.length + 1];

        for (int i = 0; i < vehicleRepository.vehicleArray.length; i++) {
            newVehicleArray[i] = vehicleRepository.vehicleArray[i];
        }
        newVehicleArray[sizeOfCurrentVehicleArray] = newVehicle;
        vehicleRepository.vehicleArray = newVehicleArray;
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
        vehicleSelection.prettyPrint();
        Vehicle updateVehicle = new Car(vehicleSelection.getModel(), vehicleSelection.getColor(),
                vehicleSelection.getYear(), vehicleSelection.automaker);

        String updatedModel = updateVehicle.getModel();

        //Allowing selection for which vehicle attribute to update
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

        for (Vehicle vehicle : vehicleRepository.vehicleArray) {

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
}

