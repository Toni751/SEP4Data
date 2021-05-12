package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.stereotype.Repository;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class DimPlantRepositoryImpl
{
    @PersistenceContext
    private EntityManager entityManager;


    public void insertPlant(DimPlant plant)
    {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("INSERT INTO stage.DimPlant values (?,?,?,?,?,?,?,?,?,?,?,?)")
                .setParameter(1, plant.getPlant_ID())
                .setParameter(2, plant.getGarden_name())
                .setParameter(3, plant.getHeight())
                .setParameter(4, plant.getWidth())
                .setParameter(5, plant.getStage_of_growth())
                .setParameter(6, plant.getSoil_type())
                .setParameter(7, plant.getOwn_soil_volume())
                .setParameter(8, plant.getGarden_location())
                .setParameter(9, plant.getSeeded_at())
                .setParameter(10, plant.getHarvested_at())
                .setParameter(11, plant.getCommon_plant_name())
                .setParameter(12, plant.getCategory_name()).executeUpdate();
        entityManager.getTransaction().commit();

    }
}
