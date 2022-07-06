package caleb.javaoneforallchallenges.checkpoint5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleRepository {
    public List<Vehicle> vehicleArrayList;
    public Automaker[] automakerArray;

    public VehicleRepository () {
        this.vehicleArrayList = init();
    }

    private List<Vehicle> init () {
        //initial dataset entry
        String[] automakerNames = {"GM", "Hyundai", "Volkswagen", "Audi", "Mercedes", "Peugeot"};
        String[] modelList = {"Suburban", "Malibu", "Silverado", "Azera", "Sonata", "Veloster",
                "Golf", "Jetta", "Polo", "A4", "Q7", "R8", "C 180", "C 200", "GLA 200", "206", "208", "2008"};
        String[] color = {"blue", "green", "yellow","brown","silver","white","orange","purple","red","black"};

        //populating automaker objects
        Automaker[] automakerObjects = new Automaker[automakerNames.length];
        for(int i = 0;i<automakerNames.length;i++) {
            automakerObjects[i] = new Automaker(automakerNames[i]);
        }

        this.automakerArray = automakerObjects;

        //populating vehicles objects
        List<Vehicle> vehicleObjects = new ArrayList<>();
        int vehicleObjectCounter = 0;
        for (int i = 0; i < modelList.length; i++) {
            if (i>=0 && i<3) {
                vehicleObjects.add(new Car (modelList[i], color[new Random().nextInt(color.length)], 2020, automakerObjects[0]));
            }
            if (i>=3 && i<6) {
                vehicleObjects.add(new Car (modelList[i], color[new Random().nextInt(color.length)], 2020, automakerObjects[1]));
            }
            if (i>=6 && i<9) {
                vehicleObjects.add(new Car (modelList[i], color[new Random().nextInt(color.length)], 2020, automakerObjects[2]));
            }
            if (i>=9 && i<12) {
                vehicleObjects.add(new Car (modelList[i], color[new Random().nextInt(color.length)], 2020, automakerObjects[3]));
            }
            if (i>=12 && i<15) {
                vehicleObjects.add(new Car (modelList[i], color[new Random().nextInt(color.length)], 2020, automakerObjects[4]));
            }
            if (i>=15 && i<18) {
                vehicleObjects.add(new Car (modelList[i], color[new Random().nextInt(color.length)], 2020, automakerObjects[5]));
            }
        }
        return vehicleObjects;
    }
}
