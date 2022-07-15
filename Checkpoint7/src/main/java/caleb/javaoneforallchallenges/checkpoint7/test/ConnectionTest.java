package caleb.javaoneforallchallenges.checkpoint7.test;

import caleb.javaoneforallchallenges.checkpoint7.conn.ConnectionFactory;

import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        System.out.println(ConnectionFactory.getConnection());
    }
}
