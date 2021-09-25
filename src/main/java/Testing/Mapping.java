package Testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1.0")
public class Mapping {

    @GetMapping("/getYoutuber")
    public Youtuber getTasks(@RequestParam(value = "YouTuber", defaultValue = "Student") String Youtuber) {

    return null;
    }


}
