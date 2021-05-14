package via.sep4gr2.sep4websocketstest.services;

import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;

import java.util.List;

public interface MeasurementService {
    void add(List<FactPlantStatus> factPlantStatuses);
}
