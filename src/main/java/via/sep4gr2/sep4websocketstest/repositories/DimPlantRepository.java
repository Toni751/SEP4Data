package via.sep4gr2.sep4websocketstest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

import java.time.LocalDate;
import java.util.List;

public interface DimPlantRepository extends JpaRepository<DimPlant, Integer>{
    @Query("SELECT p FROM DimPlant p WHERE p.plant_ID = :plant_ID")
    DimPlant getPlantById(int plant_ID);

    @Transactional
    @Modifying
    @Query("DELETE FROM DimPlant p WHERE p.plant_ID = :plant_ID")
    void deletePlant(int plant_ID);

   //List<DimPlant> getDimPlantsByGarden_name(String garden_name); FIX IT IF WE NEED THIS ANYTIME

    @Transactional
    @Modifying
    @Query("UPDATE DimPlant SET garden_name = :garden_name, soil_type = :soil_type, height = :height, stage_of_growth = :stage_of_growth, own_soil_volume = :own_soil_volume, garden_location = :garden_location, harvested_at = :harvested_at, common_plant_name = :common_plant_name, category_name = :category_name WHERE plant_ID = :plant_ID")
    void updatePlant(int plant_ID, String garden_name, int height, String soil_type, String stage_of_growth, int own_soil_volume, String garden_location, LocalDate harvested_at, String common_plant_name, String category_name);



}
