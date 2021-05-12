package via.sep4gr2.sep4websocketstest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthController {
    @GetMapping
    public String getHealth(){
        return "The application is up and running! *updated*";
    }
}
