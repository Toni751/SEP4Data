package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import via.sep4gr2.sep4websocketstest.models.database.DimGarden;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

import java.util.List;

public interface DimGardenRepository extends JpaRepository<DimGarden, Integer> {

    @Query("SELECT g FROM DimGarden g WHERE g.owner_google_id = ?1")
    List<DimGarden> findByOwner_google_id(String ownerId);

    @Query("SELECT g.sensor_ID FROM DimGarden g WHERE g.name = ?1")
    List<Integer> findAllSensorIdsByName(String name);

    // no idea if we should query with the ? like above or with :attribute, but if both work, I think the ? version is more secure (sql injection-proof)
    @Query("SELECT DISTINCT 1 AS gardens FROM DimGarden g WHERE EXISTS (SELECT 1 FROM DimGarden gr WHERE gr.name = :name)")
    List<Integer> checkIfGardenExistsByName(String name);

}
