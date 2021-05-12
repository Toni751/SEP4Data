package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.repositories.FactPlantStatusRepository;

import java.util.List;
@Service
public class MeasurementServiceImpl implements MeasurementService
{
    @Autowired
    private FactPlantStatusRepository factPlantStatusRepository;

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
        List<Double> measurements = factPlantStatusRepository.getMeasurementHistory(measurementType, id);
        return measurements;
    }
}
