package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep4gr2.sep4websocketstest.models.database.DimMeasurement;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatusId;

import java.util.List;

public interface FactPlantStatusRepository extends JpaRepository<FactPlantStatus, FactPlantStatusId> {
    @Query("SELECT fs.measurementValue FROM FactPlantStatus fs WHERE fs.plantID.plantID = (:id) and fs.measurementID.measurementName = (:measurement)")
    List<Double> getMeasurementHistory(String measurement, int id);

    @Query("SELECT AVG(fs.measurementValue) FROM FactPlantStatus fs WHERE fs.plantID.plantID = (:id) and fs.measurementID.measurementName = (:measurement)")
    double getAverageMeasurement(String measurement, int id);

    @Query("SELECT fs FROM FactPlantStatus fs WHERE fs.plantID.plantID = (:id) and fs.measurementID.measurementName = (:measurement)")
    List<FactPlantStatus> getMeasurementHistoryForPlant(String measurement, int id);

    FactPlantStatus findFirstByMeasurementIDAndPlantID(DimMeasurement measurement_type, DimPlant plant_ID);

//    @Query("SELECT AVG(fs.measurement_value) FROM FactPlantStatus fs WHERE fs.plant_ID.plant_ID = (:id) and fs.measurement_type = (:measurement)")
//    List<FactPlantStatus> getAverageMeasurement(String measurement, int id);
}
