package caleb.javaoneforallchallenges.checkpoint8.domain;

import caleb.javaoneforallchallenges.checkpoint8.conn.ConnectionFactory;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRepository {
    protected List<Vehicle> vehicleArrayList;
    protected List<Automaker> automakerArray;

    public List<Vehicle> findByAutomaker(String automakerName) {
        String sql = "SELECT * FROM vehicle LEFT JOIN automaker ON automaker.automakerID = vehicle.automakerID LEFT JOIN vehicleType ON vehicle.vehicleTypeID = vehicleType.vehicleTypeID WHERE Automaker = ?;";
        List<Vehicle> vehiclesFound = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = createPreparedStatementFindByAutomaker(conn, sql, automakerName);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Automaker currentAutomaker = new Automaker(rs.getInt("automakerID"),
                        (rs.getString("Automaker")));
                VehicleType vehicleType = new VehicleType(rs.getInt("vehicleTypeID"), rs.getString("vehicleType"));
                Vehicle currentVehicle = new Vehicle(rs.getString("model"),
                        rs.getString("color"), rs.getInt("year"), currentAutomaker, vehicleType);
                vehiclesFound.add(currentVehicle);
            }
        } catch (SQLException e) {
            System.out.println("Went wrong trying to find all vehicles by manufacturer");
        }
        return vehiclesFound;
    }

    public List<Vehicle> findAll() {
        String sql = "SELECT * FROM vehicle LEFT JOIN automaker ON automaker.automakerID = vehicle.automakerID LEFT JOIN vehicleType ON vehicle.vehicleTypeID = vehicleType.vehicleTypeID";
        List<Vehicle> vehiclesFound = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Automaker currentAutomaker = new Automaker(rs.getInt("automakerID"),
                        (rs.getString("Automaker")));
                VehicleType vehicleType = new VehicleType(rs.getInt("vehicleTypeID"), rs.getString("vehicleType"));
                Vehicle currentVehicle = new Vehicle(rs.getString("model"),
                        rs.getString("color"), rs.getInt("year"), currentAutomaker, vehicleType);
                vehiclesFound.add(currentVehicle);
            }
        } catch (SQLException e) {
            System.out.println("Went wrong trying to find all vehicles by manufacturer");
        }
        return vehiclesFound;
    }

    public Vehicle findByModel(String modelName) {
        String sql = "SELECT * FROM vehicle LEFT JOIN automaker ON automaker.automakerID = vehicle.automakerID LEFT JOIN vehicleType ON vehicle.vehicleTypeID = vehicleType.vehicleTypeID WHERE model = ?;";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = createPreparedStatementFindByModel(conn, sql, modelName);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Automaker currentAutomaker = new Automaker(rs.getInt("automakerID"),
                        (rs.getString("Automaker")));
                VehicleType vehicleType = new VehicleType(rs.getInt("vehicleTypeID"), rs.getString("vehicleType"));

                return new Vehicle(rs.getString("model"),
                        rs.getString("color"), rs.getInt("year"), currentAutomaker, vehicleType);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong trying to find " + modelName);
        }
        return null;
    }

    public void removeVehicleByModel(String modelName) {
        String sql = "DELETE FROM `auto_dealer`.`vehicle` WHERE (`model` = ?);";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = createPreparedStatementRemoveVehicleByModel(conn, sql, modelName)) {
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.printf("Deleted %s rows from the database", rowsAffected);
        } catch (SQLException ex) {
            System.out.println("The model " + modelName + " was not found in the database.");
        }
    }

    public void replaceVehicle(Vehicle replacementVehicle, Vehicle vehicleToUpdate) {

        if (vehicleToUpdate == null) {
            vehicleToUpdate = modelToReplace();
        }

        String sql = ("UPDATE `auto_dealer`.`vehicle` SET `model` = ?, `automakerID` = ?, `color` = ?, " +
                "`year` = ?, `vehicleTypeID` = ? WHERE (`model` = ?);");
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement preparedStatement = createPreparedStatementReplaceVehicle(conn, sql, replacementVehicle.getModel(), replacementVehicle.automaker.getId(),
                replacementVehicle.getColor(), replacementVehicle.getYear(), replacementVehicle.vehicleType.getId(), vehicleToUpdate.getModel())) {
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " rows have been affected.");
        } catch (SQLException e) {
            System.out.println("We couldn't update the Vehicle in the database");
        }
    }

    public Vehicle modelToReplace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which model would you like to update?");
        String vehicleModelToSearchFor = scanner.nextLine();
        return findByModel(vehicleModelToSearchFor);
    }

    public void saveToDatabase(Vehicle newVehicle) {
        System.out.println(newVehicle.toString());
        String sql = ("INSERT INTO `auto_dealer`.`vehicle` (`vehicleID`, `automakerID`, `model`," +
                " `color`, `year`, `createdAt`, `vehicleTypeID`) VALUES (?,?,?,?,?,?,?);");
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement preparedStatement = createPreparedStatementSaveToDatabase(conn, sql, newVehicle.getId(), newVehicle.automaker.getId(),
                        newVehicle.getModel(), newVehicle.getColor(), newVehicle.getYear(), newVehicle.getCreatedAt(), newVehicle.vehicleType.getId())) {
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) have been affected.");
            newVehicle.toString();
        } catch (SQLException e) {
            System.out.println("We couldn't update the Vehicle in the database");
        }
    }

    private static PreparedStatement createPreparedStatementFindByModel(Connection connection, String sql, String modelName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, modelName);
        return preparedStatement;
    }

    private static PreparedStatement createPreparedStatementRemoveVehicleByModel(Connection connection, String sql, String modelName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, modelName);
        return preparedStatement;
    }

    private static PreparedStatement createPreparedStatementFindByAutomaker(Connection connection, String sql, String automakerName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, automakerName);
        return preparedStatement;
    }

    private static PreparedStatement createPreparedStatementReplaceVehicle(Connection connection, String sql, String replacementModel,
                                                                           Integer automakerID, String Color, Integer year, Integer vehicleTypeID, String currentModel) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, replacementModel);
        preparedStatement.setInt(2, automakerID);
        preparedStatement.setString(3, Color);
        preparedStatement.setInt(4, year);
        preparedStatement.setInt(5, vehicleTypeID);
        preparedStatement.setString(6, currentModel);
        return preparedStatement;
    }

    private static PreparedStatement createPreparedStatementSaveToDatabase(Connection connection, String sql, Integer modelID, Integer automakerID, String model,
                                                                           String Color, Integer year, String createdAt, Integer vehicleType) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, modelID);
        preparedStatement.setInt(2, automakerID);
        preparedStatement.setString(3, model);
        preparedStatement.setString(4, Color);
        preparedStatement.setInt(5, year);
        preparedStatement.setString(6, createdAt);
        preparedStatement.setInt(7, vehicleType);
        return preparedStatement;
    }
}