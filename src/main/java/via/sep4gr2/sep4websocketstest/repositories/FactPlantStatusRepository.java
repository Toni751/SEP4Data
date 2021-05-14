package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatusId;

public interface FactPlantStatusRepository extends JpaRepository<FactPlantStatus, FactPlantStatusId> {
}
