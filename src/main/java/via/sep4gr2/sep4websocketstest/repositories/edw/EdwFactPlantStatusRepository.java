package via.sep4gr2.sep4websocketstest.repositories.edw;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWFactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWFactPlantStatusId;

import java.util.List;

public interface EdwFactPlantStatusRepository extends JpaRepository<EDWFactPlantStatus, EDWFactPlantStatusId>
{
    /* @Query("SELECT MeasurementValue FROM EDWFactPlantStatus WHERE plant_ID IN (SELECT P_ID FROM EDWDimPlant " +
            "WHERE plant_ID = (:id)) and MeasurementType=(:measurement) ")
    List<Double> getMeasurement(String measurement, int id); */

//    @Query("SELECT fs.MeasurementValue FROM EDWFactPlantStatus fs WHERE fs.P_ID IN (SELECT P_ID FROM EDWDimPlant " +
//            "WHERE plant_ID = (:id)) and fs.MeasurementType=(:measurement) ")
//    List<Double> getMeasurementHistory(String measurement, int id);
//
//    @Query("SELECT AVG(fs.MeasurementValue) FROM EDWFactPlantStatus fs WHERE fs.P_ID IN (SELECT P_ID FROM EDWDimPlant " +
//            "WHERE plant_ID = (:id)) and fs.MeasurementType=(:type) ")
//    double getAverageMeasurement(String type, int id);
}
