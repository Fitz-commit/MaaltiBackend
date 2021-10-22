package com.dataManager;

import com.User.User;
import com.YouTube.Youtuber;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public String addUser(User user) {

        if (searchUser(user.getEmail())){
            return "User bereits registriert!";
        }


        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "INSERT into users (email, password, id) VALUES (" +
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


        return "User wurde registriert";
    }

    public long getDatabaseID(){
        Statement stmt = null;
        Connection connection = null;
        long id = 0;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM users");
            while(rs.next()){
                id = rs.getLong(1);
            }


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

    public boolean searchUser(String email, String password) {
        Statement stmt = null;
        Connection connection = null;
        String id = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, email, password FROM users WHERE email=" + "'"+email+"' AND  password=" + "'" + password + "'" );
            while(rs.next()){
                id = rs.getString("id");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (id == null){
            return false;
        }

        return true;
        
    }

    public boolean searchUser(String email) {
        Statement stmt = null;
        Connection connection = null;
        String id = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, email, password FROM users WHERE email=" + "'"+email+"'");
            while(rs.next()){
                id = rs.getString("id");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (id == null){
            return false;
        }

        return true;

    }

    public boolean addFavorite(String creator_id, int user_id) {
        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "INSERT into favorites(user_id, creator_id) VALUES ("
                    +"'" + user_id + "', " +
                    "'" + creator_id + "')";

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

        return true;

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

            String createTable = "CREATE TABLE favorites (" +
                    "user_id int , " +
                    "creator_id varchar(250))";

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


            String createTable = "DROP TABLE favorites";


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
