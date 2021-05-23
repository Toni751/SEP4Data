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
    @Query("SELECT p FROM DimPlant p WHERE p.plantID = :id")
    DimPlant getPlantById(int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM DimPlant p WHERE p.plantID = :id")
    void deletePlant(int id);

    List<DimPlant> getDimPlantsByGardenName(String gardenName);

    @Transactional
    @Modifying
    @Query("UPDATE DimPlant SET gardenName = :gardenName, soilType = :soilType, height = :height, stageOfGrowth = :stageOfGrowth, ownSoilVolume = :ownSoilVolume, gardenLocation = :gardenLocation, harvestedAt = :harvestedAt, commonPlantName = :commonPlantName, categoryName = :categoryName WHERE plantID = :id")
    void updatePlant(int id, String gardenName, int height, String soilType, String stageOfGrowth, int ownSoilVolume, String gardenLocation, LocalDate harvestedAt, String commonPlantName, String categoryName);



}
