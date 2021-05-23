package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.restnetworking.Measurement;
import via.sep4gr2.sep4websocketstest.repositories.DimPlantRepository;
import via.sep4gr2.sep4websocketstest.repositories.FactPlantStatusRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class EdwMeasurementServiceImpl implements EdwMeasurementService
{
    @Autowired
    private FactPlantStatusRepository factPlantStatusRepository;

    @Autowired
    private DimPlantRepository plantRepository;

    @Override
    public double getLatestMeasurement(String measurementType, int id)
    {
        List<Double> measurements = factPlantStatusRepository.getMeasurementHistory(measurementType, id);
        return measurements.get(measurements.size() - 1);
    }

    @Override
    public double getAverage(String measurementType, int id)
    {
        return factPlantStatusRepository.getAverageMeasurement(measurementType, id);
    }

    @Override
    public List<Double> getTemperatureHistory(String measurementType, int id)
    {
        return factPlantStatusRepository.getMeasurementHistory(measurementType, id);
    }

    @Override
    public List<Measurement> getMeasurementsForPlant(int plantId, String type, String measurementType) {
        switch (type){
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
        List<FactPlantStatus> factPlantStatuses = factPlantStatusRepository.getMeasurementHistoryForPlant(measurementType, plantId);
        List<Measurement> measurements = new ArrayList<>();
        for (FactPlantStatus fps: factPlantStatuses) {
            measurements.add(new Measurement(fps.getStatusDate(), fps.getStatusTime(), fps.getMeasurementValue(), fps.getMeasurementID()));
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
        FactPlantStatus fps;
        if(!measurementType.equals("ALL")){
//            List<Double> temp = factPlantStatusRepository.getMeasurementHistory(measurementType, plantId);
//            measurements.add(new Measurement());
            fps = factPlantStatusRepository.findFirstByMeasurementTypeAndPlantID(measurementType, plantRepository.getPlantById(plantId));
            // System.out.println("Fps after query " + fps);
            measurements.add(new Measurement(fps.getStatusDate(), fps.getStatusTime(), fps.getMeasurementValue(), fps.getMeasurementID()));
        } else {
            fps = factPlantStatusRepository.findFirstByMeasurementTypeAndPlantID("LIGHT", plantRepository.getPlantById(plantId));
            measurements.add(new Measurement(fps.getStatusDate(), fps.getStatusTime(), fps.getMeasurementValue(), fps.getMeasurementID()));

            fps = factPlantStatusRepository.findFirstByMeasurementTypeAndPlantID("CO2", plantRepository.getPlantById(plantId));
            measurements.add(new Measurement(fps.getStatusDate(), fps.getStatusTime(), fps.getMeasurementValue(), fps.getMeasurementID()));

            fps = factPlantStatusRepository.findFirstByMeasurementTypeAndPlantID("HUM", plantRepository.getPlantById(plantId));
            measurements.add(new Measurement(fps.getStatusDate(), fps.getStatusTime(), fps.getMeasurementValue(), fps.getMeasurementID()));

            fps = factPlantStatusRepository.findFirstByMeasurementTypeAndPlantID("TEMP", plantRepository.getPlantById(plantId));
            measurements.add(new Measurement(fps.getStatusDate(), fps.getStatusTime(), fps.getMeasurementValue(), fps.getMeasurementID()));
        }

        return measurements;
    }
}
