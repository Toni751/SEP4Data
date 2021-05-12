package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.repositories.DimPlantRepository;

import javax.persistence.EntityManager;

@Service
public class PlantServiceImpl implements PlantService
{
    @Autowired
    private DimPlantRepository dimPlantRepository;

    @Override
    public void insertPlant(DimPlant dimPlant)
    {

        dimPlantRepository.save(dimPlant);
    }
}
