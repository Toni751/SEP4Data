package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimMeasurement;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWDimPlant;
import via.sep4gr2.sep4websocketstest.models.databaseEDW.EDWFactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.restnetworking.Measurement;
import via.sep4gr2.sep4websocketstest.repositories.edw.EdwDimMeasurementRepository;
import via.sep4gr2.sep4websocketstest.repositories.edw.EdwDimPlantRepository;
import via.sep4gr2.sep4websocketstest.repositories.edw.EdwFactPlantStatusRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EdwMeasurementServiceImpl implements EdwMeasurementService {
    @Autowired
    private EdwFactPlantStatusRepository factPlantStatusRepository;

    @Autowired
    private EdwDimPlantRepository plantRepository;

    @Autowired
    private EdwDimMeasurementRepository measurementRepository;

    @Override
    public List<Measurement> getMeasurementsForPlant(int plantId, String type, String measurementType) {
        switch (type) {
            case "latest":
                return calculateLatestMeasurement(plantId, measurementType);
            case "average":
                return calculateAverageMeasurement(plantId, measurementType);
            case "history":
                return calculateHistoryMeasurement(plantId, measurementType);
            default:
                return null;
        }
    }

    private List<Measurement> calculateHistoryMeasurement(int plantId, String measurementType) {
        List<EDWFactPlantStatus> factPlantStatuses = factPlantStatusRepository.getMeasurementHistoryForPlant(measurementType, plantId);
        List<Measurement> measurements = new ArrayList<>();
        for (EDWFactPlantStatus fps : factPlantStatuses) {
            measurements.add(new Measurement(fps.getDID().getDate(), fps.getTID().getTime(), fps.getMeasurementValue(), fps.getMID().getMeasurementName()));
        }
        return measurements;
    }

    private List<Measurement> calculateAverageMeasurement(int plantId, String measurementType) {
        double averageMeasurement = factPlantStatusRepository.getAverageMeasurement(measurementType, plantId);
        List<Measurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(null, null, averageMeasurement, measurementType));
        return measurements;
    }

    private List<Measurement> calculateLatestMeasurement(int plantId, String measurementType) {
        List<Measurement> measurements = new ArrayList<>();
        EDWFactPlantStatus fps;
        EDWDimMeasurement measurement;
        EDWDimPlant plant = plantRepository.getPlantByPlantId(plantId);
        if (!measurementType.equals("ALL")) {
            fps = factPlantStatusRepository.findFirstByMIDAndPIDOrderByDIDDescTIDDesc(measurementRepository.getEDWDimMeasurementByMeasurementName(measurementType), plant);

            measurements.add(new Measurement(fps.getDID().getDate(), fps.getTID().getTime(), fps.getMeasurementValue(), fps.getMID().getMeasurementName()));
        } else {
            measurement = measurementRepository.getEDWDimMeasurementByMeasurementName("LIGHT");
            System.out.println(measurement);
            System.out.println(plant);
            fps = factPlantStatusRepository.findFirstByMIDAndPIDOrderByDIDDescTIDDesc(measurement, plant);
            measurements.add(new Measurement(fps.getDID().getDate(), fps.getTID().getTime(), fps.getMeasurementValue(), fps.getMID().getMeasurementName()));

            measurement = measurementRepository.getEDWDimMeasurementByMeasurementName("CO2");
            fps = factPlantStatusRepository.findFirstByMIDAndPIDOrderByDIDDescTIDDesc(measurement, plant);
            measurements.add(new Measurement(fps.getDID().getDate(), fps.getTID().getTime(), fps.getMeasurementValue(), fps.getMID().getMeasurementName()));

            measurement = measurementRepository.getEDWDimMeasurementByMeasurementName("HUM");
            fps = factPlantStatusRepository.findFirstByMIDAndPIDOrderByDIDDescTIDDesc(measurement, plant);
            measurements.add(new Measurement(fps.getDID().getDate(), fps.getTID().getTime(), fps.getMeasurementValue(), fps.getMID().getMeasurementName()));

            measurement = measurementRepository.getEDWDimMeasurementByMeasurementName("TEMP");
            fps = factPlantStatusRepository.findFirstByMIDAndPIDOrderByDIDDescTIDDesc(measurement, plant);
            measurements.add(new Measurement(fps.getDID().getDate(), fps.getTID().getTime(), fps.getMeasurementValue(), fps.getMID().getMeasurementName()));
        }

        return measurements;
    }
}
