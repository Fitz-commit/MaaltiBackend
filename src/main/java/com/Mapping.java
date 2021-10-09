package com;

import com.User.User;
import com.YouTube.YTAPICall;
import com.YouTube.Youtuber;
import com.dataManager.PostgresUserManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1.0")
public class Mapping {


    @GetMapping("/channellistname")
    public Youtuber getYoutuberByName(@RequestParam String name) throws GeneralSecurityException, IOException {
        return YTAPICall.channelListUsername(name);
    }

    @GetMapping("/channellistid")
    public Youtuber getYoutuberById(@RequestParam String id) throws GeneralSecurityException, IOException {
        return YTAPICall.channelListID(id);
    }

    @PostMapping(path = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String addUser(@RequestBody String email, String password) {
        PostgresUserManager.getPostgresUserManager().addUser(new User(email,password));
        return "User ist registriert";
    }

    @GetMapping("/login")
    public String login(@RequestParam String email, String password) throws GeneralSecurityException, IOException {
        return PostgresUserManager.getPostgresUserManager().searchUser(email, password);
    }


}
