package caleb.javaoneforall.checkpointchallenges;

import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        String[][] carList = {{"GM", "Suburban", "Malibu", "Silverado"}, {"Hyundai", "Azera", "Sonata", "Veloster"},
                {"Volkswagen", "Golf", "Jetta", "Polo"}, {"Audi", "A4", "Q7", "R8"},
                {"Mercedes", "C 180", "C 200", "GLA 200"}, {"Peugeot", "206", "208", "2008"}};

        Scanner sc = new Scanner(System.in);

        boolean exitProgram = false;

        String mainCarMenu = ("------------------------------------------------------------------------------\n" +
                "------------------------------------------------------------------------------\n" +
                "Welcome to the Car Selection Menu\n" +
                "Please select one of the Car Brands below to show the available cars in stock\n" +
                "You can do this by inputting the corresponding number\n" +
                "------------------------------------------------------------------------------\n" +
                "------------------------------------------------------------------------------\n" +
                "1 -" + carList[0][0] +
                "\n2 -" + carList[1][0] +
                "\n3 -" + carList[2][0] +
                "\n4 -" + carList[3][0] +
                "\n5 -" + carList[4][0] +
                "\n6 -" + carList[5][0] +
                "\n------------------------------------------------------------------------------" +
                "\n*** (You can also press '0' to exit the program) ***" +
                "\n------------------------------------------------------------------------------" +
                "\nI would like to see number: " +
                "\n------------------------------------------------------------------------------");


        while (!exitProgram) {

            int userSelection = 123;

            //Presenting main menu to user
            while (userSelection != 0 && userSelection != 1 && userSelection != 2 && userSelection != 3 && userSelection != 4 && userSelection != 5 && userSelection != 6) {
                System.out.println(mainCarMenu);
                userSelection = sc.nextInt();
            }

            if (userSelection == 0) {
                exitProgram = true;
                break;
            }

            String availableCars = ("\n------------------------------------------------------------------------------" +
                    "\n------------------------------------------------------------------------------" +
                    "\nThe Available cars for " + carList[userSelection - 1][0] + " are the following vehicles:" +
                    "\n" + carList[userSelection - 1][1] + "\n" + carList[userSelection - 1][2] + "\n" + carList[userSelection - 1][3] +
                    "\n------------------------------------------------------------------------------" +
                    "\n------------------------------------------------------------------------------" +
                    "\n Is there any other way we can assist you?" +
                    "\n Enter '0' for No and to exit the program" +
                    "\n Enter '1' for Yes and to return to the main Car Selection Menu");

            //Resetting user selection
            userSelection = 123;

            //Presenting cars available menu
            while (userSelection != 0 && userSelection != 1) {
                System.out.println(availableCars);
                userSelection = sc.nextInt();
            }

            if (userSelection == 0) {
                exitProgram = true;
            } else if (userSelection == 1) {
                userSelection = 123;
            }

        }
    }
}
