package via.sep4gr2.sep4websocketstest.services;

import via.sep4gr2.sep4websocketstest.models.restnetworking.Measurement;

import java.util.List;

public interface EdwMeasurementService
{
    List<Measurement> getMeasurementsForPlant(int plantId, String type, String measurementType);
}
