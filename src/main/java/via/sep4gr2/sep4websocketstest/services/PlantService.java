package via.sep4gr2.sep4websocketstest.services;

import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

import java.time.LocalDate;
import java.util.List;

public interface PlantService
{
    int insertPlant(DimPlant dimPlant);
    List<DimPlant> getAllPlants();
    void deletePlant(int plantId);
    List<DimPlant> getPlantsByGardenName(String gardenName);
    void updatePlant(int id, String gardenName, int height, String soilType, String stageOfGrowth, int ownSoilVolume, String gardenLocation, LocalDate harvestedAt, String commonPlantName, String categoryName);
}
