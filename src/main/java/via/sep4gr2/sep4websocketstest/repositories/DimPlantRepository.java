package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

public interface DimPlantRepository extends JpaRepository<DimPlant, Integer>{
    @Query("SELECT p FROM DimPlant p WHERE p.plantID = :id")
    DimPlant getPlantById(int id);
    @Query("DELETE FROM DimPlant WHERE plantID =:id")
    void deletePlant(int id);
}
