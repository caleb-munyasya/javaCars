package caleb.javaoneforallchallenges.checkpoint5.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public abstract class Vehicle implements VehicleInterface{
    private String model;
    private String color;
    private int year;
    public Automaker automaker;
    public LocalDateTime createdAt;
    public String reportFormCreatedAt;
    private Integer id;


    public Vehicle (String model, String color, int year, Automaker automaker) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.automaker = automaker;
        Random random = new Random();
        int upperbound = 100000000;
        int int_random = random.nextInt(upperbound);
        this.id = int_random;
        setCreateAt();
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
                "This vehicle is a: " + getVehicleType().toString().toLowerCase(Locale.ROOT) + "\n" +
                "This vehicle was added to the Database at: " + this.reportFormCreatedAt + "\n" +
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

    public void setCreateAt () {
        String createdAt;
        double randomMonths = Math.floor(Math.random()*(10.0+1)+0);
        double randomDays = Math.floor(Math.random()*(30)+1);
        double randomClock = Math.floor(Math.random()*(60)+1);

        LocalDateTime now = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime randomTime = now.plusDays((int)randomDays).plusYears(-1).plusMonths((int)(randomMonths))
                .plusHours((int)(randomClock)).plusMinutes((int)(randomClock)).plusSeconds((int)(randomClock));
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
