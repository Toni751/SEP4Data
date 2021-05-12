package via.sep4gr2.sep4websocketstest.services;

import java.util.List;

public interface MeasurementService
{
    float getLatestTemperature();

    List<String> getTemperatureHistory();
}
