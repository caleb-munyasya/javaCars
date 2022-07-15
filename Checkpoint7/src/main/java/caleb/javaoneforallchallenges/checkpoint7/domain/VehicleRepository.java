package caleb.javaoneforallchallenges.checkpoint7.domain;

import caleb.javaoneforallchallenges.checkpoint7.conn.ConnectionFactory;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRepository {
    public List<Vehicle> vehicleArrayList;
    public List<Automaker> automakerArray;

    public VehicleRepository() {

    }

    public List<Vehicle> findByAutomaker(String automakerName) {
        String sql = "SELECT * FROM vehicle v LEFT JOIN automaker a ON a.automakerID = v.automakerID WHERE Automaker = '%s';".formatted(automakerName);
        List<Vehicle> vehiclesFound = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Automaker currentAutomaker = new Automaker(rs.getInt("automakerID"),
                        (rs.getString("Automaker")));
                Car currentVehicle = new Car(rs.getString("model"),
                        rs.getString("color"), rs.getInt("year"), currentAutomaker);
                vehiclesFound.add(currentVehicle);
            }
        } catch (SQLException e) {
            System.out.println("Went wrong trying to find all vehicles by manufacturer");
            ;
        }
        return vehiclesFound;
    }

    public List<Vehicle> findAll() {
        String sql = "SELECT * FROM vehicle v LEFT JOIN automaker a ON a.automakerID = v.automakerID";
        List<Vehicle> vehiclesFound = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Automaker currentAutomaker = new Automaker(rs.getInt("automakerID"),
                        (rs.getString("Automaker")));
                Car currentVehicle = new Car(rs.getString("model"),
                        rs.getString("color"), rs.getInt("year"), currentAutomaker);
                vehiclesFound.add(currentVehicle);
            }
        } catch (SQLException e) {
            System.out.println("Went wrong trying to find all vehicles by manufacturer");
            ;
        }
        return vehiclesFound;
    }

    public Vehicle findByModel(String modelName) {
        String sql = "SELECT * FROM vehicle v LEFT JOIN automaker a ON a.automakerID = v.automakerID WHERE model = '%s';".formatted(modelName);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Automaker currentAutomaker = new Automaker(rs.getInt("automakerID"),
                        (rs.getString("Automaker")));
                Car currentVehicle = new Car(rs.getString("model"),
                        rs.getString("color"), rs.getInt("year"), currentAutomaker);
                return currentVehicle;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong trying to find " + modelName);
        }
        return null;
    }

    public void removeVehicleByModel(String modelName) {
        String sql = "DELETE FROM `auto_dealer`.`vehicle` WHERE (`model` = '%s');".formatted(modelName);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.printf("Deleted {} rows from the database", rowsAffected);
        } catch (SQLException ex) {
            System.out.println("The model " + modelName + " was not found in the database.");
        }
    }

    public void replaceVehicle(Vehicle replacementVehicle, Vehicle vehicleToUpdate) {

        if (vehicleToUpdate == null) {
            vehicleToUpdate = modelToReplace();
        }

        System.out.println();

        String sql = ("UPDATE `auto_dealer`.`vehicle` SET `model` = '%s', `automakerID` = '%d', `color` = '%s', " +
                "`year` = '%d' WHERE (`model` = '%s');")
                .formatted(replacementVehicle.getModel(), replacementVehicle.automaker.getId(),
                        replacementVehicle.getColor(), replacementVehicle.getYear(), vehicleToUpdate.getModel());
        try (
                Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println(rowsAffected + " rows have been affected.");
        } catch (SQLException e) {
            System.out.println("We couldn't update the Vehicle in the database");
        }
    }

    public Vehicle modelToReplace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which model whould you like to update?");
        String vehicleModelToSearchFor = scanner.nextLine();
        Vehicle vehicleToUpdate = findByModel(vehicleModelToSearchFor);
        return vehicleToUpdate;
    }
}