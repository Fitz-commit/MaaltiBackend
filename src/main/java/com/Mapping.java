package com;

import com.YouTube.YTAPICall;
import com.YouTube.Youtuber;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1.0")
public class Mapping {

    //TODO
    //Abklären was wir von der API brauchen.
    //Theoretisch alles möglich mit API KEY?

    @GetMapping("/channellist")
    public Youtuber getYoutuber(@RequestParam String name) throws GeneralSecurityException, IOException {
        return YTAPICall.channelListUsername(name);
    }


}
