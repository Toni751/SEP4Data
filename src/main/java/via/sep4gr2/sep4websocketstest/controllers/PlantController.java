package via.sep4gr2.sep4websocketstest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimPlant;
import via.sep4gr2.sep4websocketstest.services.PlantService;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController
{
    @Autowired
    private PlantService plantService;

    @CrossOrigin(origins = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    int insertPlant(@RequestBody DimPlant plant)
    {
        try
        {
            return plantService.insertPlant(plant);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    void removePlant(@PathVariable int id) {
        try
        {
            plantService.deletePlant(id);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/garden")
    public @ResponseBody
    List<EDWDimPlant> getPlantsByGarden(@RequestParam String gardenName)
    {
        try
        {
            return plantService.getPlantsByGardenName(gardenName);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @CrossOrigin(origins = "*")
    @PutMapping(value = "/{id}")
    public @ResponseBody
    void updatePlant(@PathVariable int id, @RequestBody DimPlant plant)
    {
        try
        {
            plantService.updatePlant(id, plant.getGarden_name(), plant.getHeight(),  plant.getSoil_type(), plant.getStage_of_growth(), plant.getOwn_soil_volume(), plant.getGarden_location(), plant.getHarvested_at(), plant.getCommon_plant_name(), plant.getCategory_name());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
