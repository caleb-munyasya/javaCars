package caleb.javaoneforallchallenges.checkpoint4.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

public abstract class Vehicle implements VehicleInterface{
    private String model;
    private String color;
    private int year;
    public Automaker automaker;
    public LocalDateTime createdAt;
    public String reportFormCreatedAt;

    public Vehicle (String model, String color, int year, Automaker automaker) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.automaker = automaker;
        setCreateAt();
    }

    public void setCreateAt () {
        String createdAt;
        double randomMonths = Math.floor(Math.random()*(10.0+1)+0);
        double randomDays = Math.floor(Math.random()*(30)+1);
        LocalDateTime now = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime randomTime = now.plusDays((int)randomDays).plusYears(-1).plusMonths((int)(randomMonths));
        this.createdAt = randomTime;

        String shortMonth = randomTime.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int dayOfTheMonth = randomTime.getDayOfMonth();
        int year = randomTime.getYear();
        int hour = randomTime.getHour();
        int minute = randomTime.getMinute();
        int seconds = randomTime.getSecond();
        String lessThan10seconds = "";
        String lessThan10minutes = "";
        if (minute < 10) {
            lessThan10minutes = "0";
        }
        if (seconds < 10) {
            lessThan10seconds = "0";
        }
        this.reportFormCreatedAt = shortMonth + " " + dayOfTheMonth + ", " + year + ", " + hour + ":" + lessThan10minutes + minute + ":" + lessThan10seconds + seconds;
    }

    public void prettyPrint(){
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("Below are this vehicle's attributes:");
        System.out.println("The model is: " + getModel());
        System.out.println("The color of this vehicle is: "+ getColor());
        System.out.println("This vehicle was built in the year: " + getYear());
        System.out.println("The automaker for this model is: " + automaker.getName());
        System.out.println("This vehicle is a " + getVehicleType().toString().toLowerCase(Locale.ROOT));
        System.out.println("This vehicle was added to the Database at: " + this.reportFormCreatedAt);
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
