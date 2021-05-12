package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimPlant;
import via.sep4gr2.sep4websocketstest.repositories.DimPlantRepository;
import via.sep4gr2.sep4websocketstest.repositories.edw.EdwDimPlantRepository;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService
{
    @Autowired
    private DimPlantRepository dimPlantRepository;

    @Autowired
    private EdwDimPlantRepository edwDimPlantRepository;

    @Override
    public int insertPlant(DimPlant dimPlant)
    {
        DimPlant savedPlant = dimPlantRepository.save(dimPlant);
        return savedPlant.getPlant_ID();
    }

    @Override
    public List<DimPlant> getAllPlants() {
        //return edwDimPlantRepository.findAll();
        return dimPlantRepository.findAll();
    }
}
