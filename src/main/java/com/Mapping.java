package com;

import com.User.CookieGenerator;
import com.User.User;
import com.YouTube.YTAPICall;
import com.YouTube.Youtuber;
import com.dataManager.PostgresUserManager;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.api.services.youtube.model.SearchResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1.0")
public class Mapping {


    @GetMapping("/channellistname")
    public Youtuber getYoutuberByName(@RequestParam String name) throws GeneralSecurityException, IOException {
        return YTAPICall.channelListUsername(name);
    }

    @GetMapping(value = "/channellistid", params = {"id"})
    public Youtuber getYoutuberById(@RequestParam String id) throws GeneralSecurityException, IOException {
        return YTAPICall.channelListID(id);
    }

    @GetMapping(value = "/channellistid", params = { "id", "order"})
    public Youtuber getYoutuberById(@RequestParam String id, String order) throws GeneralSecurityException, IOException {
        return YTAPICall.channelListID(id,order);
    }


    @GetMapping("/searchlistname")
    public List<Youtuber> searchYoutuberByName(@RequestParam String name) throws GeneralSecurityException, IOException {
        return YTAPICall.searchChannel(name);

    }

    @GetMapping(value ="/searchlistname", params = {"name", "country"})
    public List<Youtuber> searchYoutuberByName(@RequestParam String name, String country) throws GeneralSecurityException, IOException {
        return YTAPICall.searchChannel(name,country);
    }

    @PostMapping(path = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public boolean addUser(@RequestBody User user) {
        return PostgresUserManager.getPostgresUserManager().addUser(user);
    }

    @PostMapping(path= "/login" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody ObjectNode objectNode){

        String email = objectNode.get("email").asText();
        String password = objectNode.get("password").asText();

        int id = PostgresUserManager.getPostgresUserManager().searchUser(email, password);

        if(id == 0 ){
           return null;
        }
        String cookie = CookieGenerator.generateCookie();
        PostgresUserManager.getPostgresUserManager().addCookie(id, cookie);
        return cookie;
    }

    @GetMapping("/logout")
    public void logout(@RequestParam String cookie) throws GeneralSecurityException, IOException {
        PostgresUserManager.getPostgresUserManager().delCookie(cookie);
    }

    @PostMapping(path = "/addfavor", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void addfavor(@RequestBody ObjectNode objectNode) {

        //TODO Cookie einbauen

        String creator_id = objectNode.get("creator_id").asText();
        int user_id = objectNode.get("user_id").asInt();
        String name = objectNode.get("name").asText();
        String profilbild = objectNode.get("profilbild").asText();

        PostgresUserManager.getPostgresUserManager().addFavorite(creator_id, user_id);
        PostgresUserManager.getPostgresUserManager().addYoutuber(creator_id,name, profilbild);
    }

    @GetMapping("/delfavor")
    public void delfavor(@RequestParam String cookie, String creator_id) throws GeneralSecurityException, IOException {
        //TODO testen

        int user_id = PostgresUserManager.getPostgresUserManager().getId(cookie);

        PostgresUserManager.getPostgresUserManager().delFavor(user_id,creator_id);

    }

    @GetMapping("/profil")
    public void getProfil(@RequestParam int user_id) throws GeneralSecurityException, IOException {

    }




}
