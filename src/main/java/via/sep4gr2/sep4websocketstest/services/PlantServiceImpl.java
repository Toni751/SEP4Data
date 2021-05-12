package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimPlant;
import via.sep4gr2.sep4websocketstest.repositories.DimPlantRepository;
import via.sep4gr2.sep4websocketstest.repositories.edw.EdwDimPlantRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PlantServiceImpl implements PlantService
{
    @Autowired
    private DimPlantRepository dimPlantRepository;

    @Autowired
    private EdwDimPlantRepository edwDimPlantRepository;

    @Override
    public void insertPlant(DimPlant dimPlant)
    {
        dimPlantRepository.save(dimPlant);
    }

    @Override
    public List<EDWDimPlant> getAllPlants() {
        return edwDimPlantRepository.findAll();
    }
}
