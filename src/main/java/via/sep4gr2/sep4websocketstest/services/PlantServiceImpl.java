package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.loriotconnection.LoriotControllerImpl;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.repositories.DimPlantRepository;
import via.sep4gr2.sep4websocketstest.repositories.FactPlantStatusRepository;
import via.sep4gr2.sep4websocketstest.repositories.edw.EdwDimPlantRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlantServiceImpl implements PlantService
{
    @Autowired
    private FactPlantStatusRepository factPlantStatusRepository;
    @Autowired
    private DimPlantRepository dimPlantRepository;

    @Autowired
    private EdwDimPlantRepository edwDimPlantRepository;

    @Autowired
    private LoriotControllerImpl loriotController;

    @Override
    public int insertPlant(DimPlant plant)
    {
        DimPlant savedPlant = dimPlantRepository.save(plant);
        int plantId = savedPlant.getPlantID();
        return plantId;
    }

    @Override
    public List<DimPlant> getAllPlants() {
        return dimPlantRepository.findAll();
    }

    @Override
    public void deletePlant(int plantId) {
        factPlantStatusRepository.deletePlant(plantId);
        dimPlantRepository.deletePlant(plantId);
    }

    @Override
    public List<DimPlant> getPlantsByGardenName(String gardenName) {
        return dimPlantRepository.getDimPlantsByGardenName(gardenName);
    }

    @Override
    public void updatePlant(int id, String gardenName, int height, String soilType, String stageOfGrowth, int ownSoilVolume, String gardenLocation, LocalDate harvestedAt, String commonPlantName, String categoryName) {
        dimPlantRepository.updatePlant(id, gardenName, height, soilType, stageOfGrowth, ownSoilVolume, gardenLocation, harvestedAt, commonPlantName, categoryName);
    }

}
