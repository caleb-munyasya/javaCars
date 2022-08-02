package caleb.javaoneforallchallenges.checkpoint8.domain;

import caleb.javaoneforallchallenges.checkpoint8.conn.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutomakerRepository {
    public Automaker findByName(String automakerName){
        String sql = "SELECT * FROM auto_dealer.automaker WHERE automaker = ?";
        try (
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = createPreparedStatementFindByName(conn, sql, automakerName)){
            ResultSet rs = preparedStatement.executeQuery();
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
        String sql = "INSERT INTO `auto_dealer`.`automaker` (`automakerID`, `automaker`) VALUES (?, ?);";
        try (
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = createPreparedStatementSave(conn, sql, automakerID, automakerName)){
            Integer rowsUpdated = preparedStatement.executeUpdate();
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

    public PreparedStatement createPreparedStatementSave (Connection connection, String sql, Integer AutomakerID, String automakerName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, AutomakerID);
        preparedStatement.setString(2, automakerName);
        return preparedStatement;
    }

    public PreparedStatement createPreparedStatementFindByName (Connection connection, String sql, String automakerName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, automakerName);
        return preparedStatement;
    }
}
