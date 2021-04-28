package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.models.database.DimGarden;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.restnetworking.GardenNetworking;
import via.sep4gr2.sep4websocketstest.models.restnetworking.PlantNetworking;
import via.sep4gr2.sep4websocketstest.repositories.DimGardenRepository;
import via.sep4gr2.sep4websocketstest.repositories.DimPlantRepository;

import java.util.List;

@Service
public class GardenServiceImpl implements GardenService{
    @Autowired
    private DimGardenRepository gardenRepo;

    @Autowired
    private DimPlantRepository plantRepo;

    @Override
    public void addGarden(DimGarden garden) throws Exception {
        try {
            List<Integer> gardenExists = gardenRepo.checkIfGardenExistsByName(garden.getName());
            System.out.println("Garden exists " + gardenExists);
            if(gardenExists == null || gardenExists.size() == 0){
                gardenRepo.save(garden);
            }
            else {
                throw new Exception("Garden with the given name already exists");
            }
        } catch (Exception e) {
            System.out.println("Adding garden threw exception");
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public GardenNetworking getGardenByOwnerId(String ownerId) throws Exception {
        if(ownerId == null || ownerId.length() == 0)
            throw new Exception("Invalid owner id");
        try {
            List<DimGarden> gardenWithSensors = gardenRepo.findByOwner_google_id(ownerId);
            // maybe do something here and create one custom object for return or idk
            if(gardenWithSensors == null || gardenWithSensors.size() == 0)
                return null;

            // add
            // return gardenWithSensors.get(0);
            return null;
        } catch (Exception e) {
            System.out.println("Getting garden by owner id threw exception");
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<PlantNetworking> getPlantsByGardenName(String gardenName) throws Exception {
        if(gardenName == null || gardenName.length() == 0)
            throw new Exception("Invalid garden name");
        try {
            List<Integer> sensorIds = gardenRepo.findAllSensorIdsByName(gardenName);
            List<DimPlant> plantsWithSensors = plantRepo.findPlantsBySensorIds(sensorIds);

            //there are some duplicates or idk, you probably need to group the plants by unique_plant_name and create some new (networking) objects
            // return plantsWithSensors;
            return null;
        } catch (Exception e) {
            System.out.println("Getting plants by garden name threw exception");
            throw new Exception(e.getMessage());
        }
    }
}
