package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

import java.util.List;

public interface DimPlantRepository extends JpaRepository<DimPlant, Integer> {

    // here it may be just ":sensorIds", without the (), not sure
    @Query("SELECT p FROM DimPlant p WHERE p.sensor_ID IN (:sensorIds)")
    List<DimPlant> findPlantsBySensorIds(List<Integer> sensorIds);

}
