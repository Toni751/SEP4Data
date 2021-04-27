package via.sep4gr2.sep4websocketstest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import via.sep4gr2.sep4websocketstest.models.database.DimGarden;
import via.sep4gr2.sep4websocketstest.repositories.DimGardenRepository;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private DimGardenRepository gardenRepo;

    @PostMapping
    public void addGarden(@RequestBody DimGarden garden) {
        gardenRepo.save(garden);
    }

    @GetMapping
    public @ResponseBody List<DimGarden> getGreeting() {
        return gardenRepo.findAll();
    }
}
