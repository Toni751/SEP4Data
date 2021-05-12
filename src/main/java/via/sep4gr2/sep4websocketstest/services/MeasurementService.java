package via.sep4gr2.sep4websocketstest.services;

import java.util.List;

public interface MeasurementService
{
    double getLatestMeasurement(String measurementType,int id);

    double getAverage(String measurementType,int id);

    List<Double> getTemperatureHistory(String measurementType,int id);
}
