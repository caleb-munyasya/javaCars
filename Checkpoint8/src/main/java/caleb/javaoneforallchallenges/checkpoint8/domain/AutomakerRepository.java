package caleb.javaoneforallchallenges.checkpoint8.domain;

import caleb.javaoneforallchallenges.checkpoint8.conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutomakerRepository {
    public Automaker findByName(String automakerName){
        String sql = "SELECT * FROM auto_dealer.automaker WHERE automaker = '%s'".formatted(automakerName);
        try (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return new Automaker(rs.getInt("automakerID")
                        ,(rs.getString("automaker")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Integer automakerID, String automakerName){
        String sql = "INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES ('%d', '%s');".formatted(automakerID,automakerName);
        try (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            Integer rowsUpdated = stmt.executeUpdate(sql);
            System.out.println(rowsUpdated + " row(s) have been updated with ID: " + automakerID + " and name: " + automakerName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Automaker> findAll () {
        String sql = "SELECT * FROM auto_dealer.automaker;";
        List<Automaker> allAutomakers = new ArrayList<>();
        try (
                Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Automaker automaker = new Automaker(rs.getInt("automakerID")
                        ,(rs.getString("automaker")));
                allAutomakers.add(automaker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allAutomakers;
    }
}
