package com.dataManager;

import com.User.User;
import com.YouTube.Youtuber;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
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

    public List<Youtuber> getAllFavorites(int user_id) {
        List<Youtuber> youtuber = new ArrayList<>();
        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT creator_id, name, profilbild " +
                    "FROM favorites " +
                    "INNER JOIN youtuber " +
                    "ON favorites.creator_id = youtuber.id "+
                    "WHERE user_id=" + user_id);
            while (rs.next()) {
                youtuber.add(
                        new Youtuber(
                                rs.getString("name"),
                                rs.getString("profilbild"),
                                rs.getString("creator_id")
                        )
                );
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


        return youtuber;
    }


    public void delCookie(String cookie){

        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "UPDATE users SET cookie=" + "'" + "'" +"WHERE cookie= " + "'" + cookie + "'";

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

    public void addCookie(int id, String cookie){

        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "UPDATE users SET cookie=" + "'" + cookie + "'" + "WHERE id= " + id;

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

    public boolean addUser(User user) {

        if (searchUser(user.getEmail())){
            return false;
        }


        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "INSERT into users (email, password, id, cookie) VALUES (" +
                    "'" + user.getEmail() + "', " +
                    "'" + user.getPassword() + "', " +
                    "'" + user.getId() + "', " +
                    "'" + "')";

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

    public int searchUser(String email, String password) {
        Statement stmt = null;
        Connection connection = null;
        int id = 0;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, email, password FROM users WHERE email=" + "'"+email+"' AND  password=" + "'" + password + "'" );
            while(rs.next()){
                id = rs.getInt("id");
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

    public String searchUser(int user_id) {
        Statement stmt = null;
        Connection connection = null;
        String email = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, email, password FROM users WHERE id=" +user_id);
            while(rs.next()){
                email = rs.getString("email");
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

        return email;

    }

    public int getId(String cookie) {
        Statement stmt = null;
        Connection connection = null;
        int id = 0;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM users WHERE cookie=" + "'"+cookie+"'");
            while(rs.next()){
                id = rs.getInt("id");
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

    public boolean checkFavor(String creator_id, int user_id) {
        Statement stmt = null;
        Connection connection = null;
        String id = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT creator_id, user_id FROM favorites WHERE creator_id=" + "'"+creator_id+"'"+ "AND user_id=" + user_id);;

            while(rs.next()){
                id = rs.getString("user_id");
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if(id == null){
            return false;
        };

        return true;

    }


    public boolean addFavor(String creator_id, int user_id) {
        Statement stmt = null;
        Connection connection = null;

        if (this.checkFavor(creator_id,user_id)){
          return true;
        }

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

    public void delFavor(int user_id, String creator_id){

        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "DELETE FROM favorites WHERE user_id= " + user_id +"AND creator_id=" + "'" + creator_id + "'" ;

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


    public void createTableUsers() {

        // Be carefull: It deletes data if table already exists.
        //
        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();

            // String dropTable = "DROP TABLE tasks";

            String createTable = "CREATE TABLE youtuber (" +
                    "id varchar(250) PRIMARY KEY, " +
                    "name varchar(200), " +
                    "profilbild varchar(250))";

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

    public void addYoutuber(String creator_id, String name, String profilbild) {

        //TODO TESTEN OB ZEILEN ÜBERSCHRIEBEN WERDEN

        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "INSERT into youtuber(id,name,profilbild) VALUES ("
                    +"'" + creator_id + "', " +
                    "'" + name + "', " +
                    "'" + profilbild + "')";

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
