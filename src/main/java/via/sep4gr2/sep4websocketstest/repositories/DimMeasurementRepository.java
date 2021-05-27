package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep4gr2.sep4websocketstest.models.database.DimMeasurement;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

public interface DimMeasurementRepository extends JpaRepository<DimMeasurement, Integer> {
    DimMeasurement getDimMeasurementByMeasurementID(int id);
}
