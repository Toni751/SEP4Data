package via.sep4gr2.sep4websocketstest.repositories.edw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimPlant;

public interface EdwDimPlantRepository extends JpaRepository<EDWDimPlant, Integer> {
    @Query("SELECT p FROM EDWDimPlant p WHERE p.plant_ID = :plantID AND p.ValidTo = '9999-01-01 00:00:00.000'")
    EDWDimPlant getPlantByPlantId(int plantID);
}
