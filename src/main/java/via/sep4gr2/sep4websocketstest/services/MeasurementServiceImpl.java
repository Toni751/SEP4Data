package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import via.sep4gr2.sep4websocketstest.repositories.FactPlantStatusRepository;

import java.util.List;

public class MeasurementServiceImpl implements MeasurementService
{
    @Autowired
    private FactPlantStatusRepository factPlantStatusRepository;

    @Override
    public double getLatestTemperature()
    {
        return 0;
    }

    @Override
    public double getAverageTemperature()
    {
        return 0;
    }

    @Override
    public List<Double> getTemperatureHistory()
    {
        return null;
    }
}
