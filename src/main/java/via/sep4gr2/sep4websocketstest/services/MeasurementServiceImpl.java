package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;
import via.sep4gr2.sep4websocketstest.repositories.FactPlantStatusRepository;

import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService{

    @Autowired
    private FactPlantStatusRepository repository;

    @Override
    public void add(List<FactPlantStatus> factPlantStatuses) {
        repository.saveAll(factPlantStatuses);
    }
}
