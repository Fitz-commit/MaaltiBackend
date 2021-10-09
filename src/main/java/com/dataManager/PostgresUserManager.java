package com.dataManager;

import com.User.User;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgresUserManager {

    String databaseURL = "jdbc:postgresql://ec2-44-198-154-255.compute-1.amazonaws.com:5432/d7qge5jkshgd2d";
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
                    "'" + user.getEmail() + "', " +
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

    public String searchUser(String email, String password) {
        Statement stmt = null;
        Connection connection = null;
        String id = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE email= " + email + "AND  password=" + password);
            id = rs.getString("id");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return id;
        
    }


    public void createTableUsers() {

        // Be carefull: It deletes data if table already exists.
        //
        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();

            // String dropTable = "DROP TABLE tasks";

            String createTable = "CREATE TABLE users (" +
                    "id SERIAL PRIMARY KEY, " +
                    "username varchar(100) NOT NULL, " +
                    "password varchar(250) NOT NULL)";

            // stmt.executeUpdate(dropTable);

            stmt.executeUpdate(createTable);

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

    public void deleteTableUsers() {


        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();


            String createTable = "DROP TABLE users";


            stmt.executeUpdate(createTable);

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
