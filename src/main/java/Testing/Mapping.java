package Testing;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1.0")
public class Mapping {

    @GetMapping("/getYoutuber")
    public Youtuber getTasks(@RequestParam(value = "YouTuber", defaultValue = "Student") String Youtuber) {
        String descritption = "Test";
        String subcount = "444";
        Youtuber test = new Youtuber(Youtuber,descritption,subcount);

    return null;
    }


}
