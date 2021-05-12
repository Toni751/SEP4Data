package via.sep4gr2.sep4websocketstest.services;

import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimPlant;

import java.util.List;

public interface PlantService
{
    void insertPlant(DimPlant dimPlant);
    List<EDWDimPlant> getAllPlants();
}
