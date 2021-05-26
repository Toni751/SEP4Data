package via.sep4gr2.sep4websocketstest.repositories.edw;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep4gr2.sep4websocketstest.models.database.DimMeasurement;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimMeasurement;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimPlant;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWFactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWFactPlantStatusId;

import java.util.List;

public interface EdwFactPlantStatusRepository extends JpaRepository<EDWFactPlantStatus, EDWFactPlantStatusId> {
    @Query("SELECT AVG(fs.MeasurementValue) FROM EDWFactPlantStatus fs WHERE fs.PID.plant_ID = (:id) and fs.MID.measurementName = (:measurement)")
    double getAverageMeasurement(String measurement, int id);

    @Query("SELECT fs FROM EDWFactPlantStatus fs WHERE fs.PID.plant_ID = (:id) and fs.MID.measurementName = (:measurement)")
    List<EDWFactPlantStatus> getMeasurementHistoryForPlant(String measurement, int id);

    EDWFactPlantStatus findFirstByMIDAndPIDOrderByDIDDescTIDDesc(EDWDimMeasurement measurement, EDWDimPlant plant);
}
