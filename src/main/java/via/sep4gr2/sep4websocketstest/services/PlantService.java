package via.sep4gr2.sep4websocketstest.services;

import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.restnetworking.PlantWithSensor;

import java.util.List;

public interface PlantService
{
    int insertPlant(PlantWithSensor dimPlant);
    List<DimPlant> getAllPlants();
    void deletePlant(int plantId);
}
