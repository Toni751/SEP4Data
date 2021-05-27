package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.loriotconnection.LoriotControllerImpl;
import via.sep4gr2.sep4websocketstest.models.database.DimMeasurement;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimPlant;
import via.sep4gr2.sep4websocketstest.repositories.DimMeasurementRepository;
import via.sep4gr2.sep4websocketstest.repositories.DimPlantRepository;
import via.sep4gr2.sep4websocketstest.repositories.FactPlantStatusRepository;
import via.sep4gr2.sep4websocketstest.repositories.edw.EdwDimPlantRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

@Service
public class PlantServiceImpl implements PlantService {
    @Autowired
    private FactPlantStatusRepository factPlantStatusRepository;
    @Autowired
    private DimPlantRepository dimPlantRepository;
    @Autowired
    private EdwDimPlantRepository edwDimPlantRepository;
    @Autowired
    private DimMeasurementRepository measurementRepository;

    @Override
    public int insertPlant(DimPlant plant) {
        DimPlant savedPlant = dimPlantRepository.save(plant);
        generateMeasurementsForPlant(savedPlant);
        return savedPlant.getPlantID();
    }

    private void generateMeasurementsForPlant(DimPlant plant) {
        LocalDateTime triggerTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(Instant.now().toEpochMilli()), TimeZone
                        .getDefault().toZoneId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = formatter.format(triggerTime);

        String date = formatted.split(" ")[0];
        String time = formatted.split(" ")[1];
        time = time.substring(0, 6) + "00";

        FactPlantStatus fps = new FactPlantStatus();
        fps.setPlantID(plant);
        fps.setStatusDate(date);
        fps.setStatusTime(time);

        Random random = new Random();
        for (int j = 1; j <= 4; j++) {
            DimMeasurement measurement = measurementRepository.getDimMeasurementByMeasurementID(j);
            fps.setMeasurementID(measurement);

            int value = 0;
            switch (j) {
                case 1:
                    value = random.nextInt(25) + 20;
                    break;
                case 2:
                    value = random.nextInt(200) + 350;
                    break;
                case 3:
                    value = random.nextInt(12) + 20;
                    break;
                case 4:
                    value = random.nextInt(700) + 400;
                    break;
            }
            fps.setMeasurementValue(value);
            System.out.println("Saving measurement value " + value);
            factPlantStatusRepository.save(fps);
        }
    }

    @Override
    public void deletePlant(int plantId) {
        factPlantStatusRepository.deletePlant(plantId);
        dimPlantRepository.deletePlant(plantId);
    }

    @Override
    public List<EDWDimPlant> getPlantsByGardenName(String gardenName) {
        return edwDimPlantRepository.getPlantsByGardenName(gardenName);
    }

    @Override
    public void updatePlant(int id, String gardenName, int height, String soilType, String stageOfGrowth, int ownSoilVolume, String gardenLocation, LocalDate harvestedAt, String commonPlantName, String categoryName) {
        dimPlantRepository.updatePlant(id, gardenName, height, soilType, stageOfGrowth, ownSoilVolume, gardenLocation, harvestedAt, commonPlantName, categoryName);
    }

}
