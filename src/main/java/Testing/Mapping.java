package Testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1.0")
public class Mapping {

    @GetMapping("/getYoutuber")
    public Youtuber getYoutuber() throws GeneralSecurityException, IOException {
    return ApiExample.doThing();
    }


}
