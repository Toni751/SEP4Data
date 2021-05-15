package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.stereotype.Repository;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DimPlantRepositoryImpl
{
    @PersistenceContext
    private EntityManager entityManager;


    public void insertPlant(DimPlant plant)
    {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("INSERT INTO stage.DimPlant values (?,?,?,?,?,?,?,?,?,?,?,?)")
                .setParameter(1, plant.getPlantID())
                .setParameter(2, plant.getGardenName())
                .setParameter(3, plant.getHeight())
                .setParameter(4, plant.getWidth())
                .setParameter(5, plant.getStageOfGrowth())
                .setParameter(6, plant.getSoilType())
                .setParameter(7, plant.getOwnSoilVolume())
                .setParameter(8, plant.getGardenLocation())
                .setParameter(9, plant.getSeededAt())
                .setParameter(10, plant.getHarvestedAt())
                .setParameter(11, plant.getCommonPlantName())
                .setParameter(12, plant.getCategoryName()).executeUpdate();
        entityManager.getTransaction().commit();

    }
}
