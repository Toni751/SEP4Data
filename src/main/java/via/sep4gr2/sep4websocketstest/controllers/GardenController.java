package via.sep4gr2.sep4websocketstest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import via.sep4gr2.sep4websocketstest.models.database.DimGarden;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.restnetworking.GardenNetworking;
import via.sep4gr2.sep4websocketstest.models.restnetworking.PlantNetworking;
import via.sep4gr2.sep4websocketstest.services.GardenService;

import java.util.List;

@RestController
@RequestMapping("/gardens")
public class GardenController {
    @Autowired
    private GardenService gardenService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public void addGarden(@RequestBody DimGarden garden) throws Exception {
        System.out.println("Controller adding garden");
        try{
            gardenService.addGarden(garden);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{ownerId}")
    public @ResponseBody
    GardenNetworking getGardenByOwnerId(@PathVariable String ownerId) {
        System.out.println("Controller getting garden for owner id " + ownerId);
        try{
            return gardenService.getGardenByOwnerId(ownerId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{gardenName}")
    public @ResponseBody
    List<PlantNetworking> getPlantsByGardenName(@PathVariable String gardenName) {
        System.out.println("Controller getting plants for garden name " + gardenName);
        try{
            return gardenService.getPlantsByGardenName(gardenName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
