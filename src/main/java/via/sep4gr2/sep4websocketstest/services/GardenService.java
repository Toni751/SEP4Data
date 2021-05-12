package via.sep4gr2.sep4websocketstest.services;

import via.sep4gr2.sep4websocketstest.models.restnetworking.GardenNetworking;
import via.sep4gr2.sep4websocketstest.models.restnetworking.PlantNetworking;

import java.util.List;

public interface GardenService {
    void addGarden(DimGarden garden) throws Exception;
    GardenNetworking getGardenByOwnerId(String ownerId) throws Exception;
    List<PlantNetworking> getPlantsByGardenName(String gardenName) throws Exception;
}
