package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import via.sep4gr2.sep4websocketstest.models.database.DimMeasurement;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatusId;

import java.util.List;

public interface FactPlantStatusRepository extends JpaRepository<FactPlantStatus, FactPlantStatusId> {
    @Transactional
    @Modifying
    @Query("DELETE FROM FactPlantStatus p WHERE p.plantID.plant_ID = :plant_ID")
    void deletePlant(int plant_ID);
}
