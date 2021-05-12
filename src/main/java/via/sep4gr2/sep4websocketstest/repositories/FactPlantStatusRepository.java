package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatusId;

import java.util.List;

public interface FactPlantStatusRepository extends JpaRepository<FactPlantStatus, FactPlantStatusId> {
    @Query("SELECT measurement_value FROM FactPlantStatus where measurement_type=(:measurement)")
    float getMeasurement(String measurement);
}
