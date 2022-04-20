package caleb.javaoneforallchallenges.checkpoint2.cars.domain;

public abstract class Vehicle implements VehicleInterface{
    private String model;
    private String color;
    private int year;
    public Automaker automaker;

    public Vehicle (String model, String color, int year, Automaker automaker) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.automaker = automaker;
    }

    public void prettyPrint(){
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("Below are this vehicle's attributes:");
        System.out.println("The model is: " + getModel());
        System.out.println("The color of this vehicle is: "+ getColor());
        System.out.println("This vehicle was built in the year: " + getYear());
        System.out.println("The automaker for this model is: " + automaker.getName());
        System.out.println("This vehicle is a " + getVehicleType());
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
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
}
