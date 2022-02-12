package caleb.javaoneforallchallenges.checkpoint2.cars.test;

import caleb.javaoneforallchallenges.checkpoint2.cars.domain.Automaker;
import caleb.javaoneforallchallenges.checkpoint2.cars.domain.Vehicle;
import caleb.javaoneforallchallenges.checkpoint2.cars.domain.VehicleService;

import java.util.Scanner;

public class CarsMenu {

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
                "\n------------------------------------------------------------------------------" +
                "\n*** (You can also press '0' to exit the program) ***" +
                "\n------------------------------------------------------------------------------" +
                "\n------------------------------------------------------------------------------");

        System.out.println(mainCarMenu);

    }

    public boolean returnToMainMenu () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to return to main menu or 0 to exit the program");

        int returnToMainMenu = 2;
        while (returnToMainMenu != 0 && returnToMainMenu != 1) {
            returnToMainMenu = sc.nextInt();

            if (returnToMainMenu == 0) {
                return false;
            }

            System.out.println("Please enter a valid choice. Press 1 to return to main menu or 0 to exit the program : ");
        }
        return true;
    }

    public void printAvailableModels (Vehicle[] searchResult) {
        System.out.println("The models available for the automaker " + searchResult[0].automaker.getName() + " are: ");
        for (Vehicle vehicles : searchResult) {
            System.out.println("* " + vehicles.getModel());
        }
    }
}



