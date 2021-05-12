package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import via.sep4gr2.sep4websocketstest.repositories.FactPlantStatusRepository;

import java.util.List;

public class MeasurementServiceImpl implements MeasurementService
{
    @Autowired
    private FactPlantStatusRepository factPlantStatusRepository;

    @Override
    public float getLatestTemperature()
    {
        return 0;
    }

    @Override
    public List<String> getTemperatureHistory()
    {
        return null;
    }
}
