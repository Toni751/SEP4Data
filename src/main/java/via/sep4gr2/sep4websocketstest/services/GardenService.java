package via.sep4gr2.sep4websocketstest.services;

import via.sep4gr2.sep4websocketstest.models.database.DimGarden;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

import java.util.List;

public interface GardenService {
    void addGarden(DimGarden garden) throws Exception;
    DimGarden getGardenByOwnerId(String ownerId) throws Exception;
    List<DimPlant> getPlantsByGardenName(String gardenName) throws Exception;
}
