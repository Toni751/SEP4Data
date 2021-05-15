package via.sep4gr2.sep4websocketstest.services;

import via.sep4gr2.sep4websocketstest.models.restnetworking.Measurement;

import java.util.List;

public interface EdwMeasurementService
{
    double getLatestMeasurement(String measurementType,int id);

    double getAverage(String measurementType,int id);

    List<Double> getTemperatureHistory(String measurementType,int id);

    List<Measurement> getMeasurementsForPlant(int plantId, String type, String measurementType);
}
