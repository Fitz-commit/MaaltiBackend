package Postgres;

import User.User;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresUserManager {

    String databaseURL = "ec2-44-198-154-255.compute-1.amazonaws.com";
    String username = "uikohzgximdiqt";
    String password = "6291a8a304ee6f4bffa41fd499eeb93270c2edbf777392092cd5946339bc51d5";
    BasicDataSource basicDataSource;

    static PostgresUserManager postgresUserManager = null;

    private PostgresUserManager() {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(databaseURL);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
    }

    public static PostgresUserManager getPostgresUserManager() {
        if (postgresUserManager == null)
            postgresUserManager = new PostgresUserManager();
        return postgresUserManager;
    }

    public void addUser(User user) {

        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "INSERT into users (username, password, id) VALUES (" +
                    "'" + user.getUsername() + "', " +
                    "'" + user.getPassword() + "', " +
                    "'" + user.getId() + "')";

            stmt.executeUpdate(udapteSQL);

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
