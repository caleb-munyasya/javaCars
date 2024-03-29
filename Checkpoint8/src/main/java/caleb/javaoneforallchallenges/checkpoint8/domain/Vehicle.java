package caleb.javaoneforallchallenges.checkpoint8.domain;

import java.time.Instant;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Vehicle implements VehicleInterface{
    private String model;
    private String color;
    private int year;
    protected Automaker automaker;
    protected String createdAt;
    private Integer id;
    protected VehicleType vehicleType;


    protected Vehicle (String model, String color, int year, Automaker automaker, VehicleType vehicleType) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.automaker = automaker;
        this.id = ThreadLocalRandom.current().nextInt(0,100000000);
        this.createdAt = Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt(1531485427,1657715827)).toString();
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return  "------------------------------------------------------------------------------" + "\n" +
                "------------------------------------------------------------------------------" + "\n" +
                "Below are this vehicle's attributes:" + "\n" +
                "------------------------------------" + "\n" +
                "The model is: " + getModel() + "\n" +
                "The color of this vehicle is: "+ getColor() + "\n" +
                "This vehicle was built in the year: " + getYear() + "\n" +
                "The automaker for this model is: " + automaker.getName() + "\n" +
                "This vehicle is a: " + vehicleType.getVehicleType() + "\n" +
                "This vehicle was added to the Database at: " + getCreatedAt() + "\n" +
                "The Vehicle ID is: " + getId() ;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Vehicle otherVehicle = (Vehicle) obj;
        return id != null && id.equals(otherVehicle.id);
    }

    @Override
    public int hashCode() {
        return id == 0 ? null : id.hashCode();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
