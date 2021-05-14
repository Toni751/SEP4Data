package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.loriotconnection.LoriotControllerImpl;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.loriotnetworking.Command;
import via.sep4gr2.sep4websocketstest.models.restnetworking.PlantWithSensor;
import via.sep4gr2.sep4websocketstest.repositories.DimPlantRepository;
import via.sep4gr2.sep4websocketstest.repositories.edw.EdwDimPlantRepository;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService
{
    @Autowired
    private DimPlantRepository dimPlantRepository;

    @Autowired
    private EdwDimPlantRepository edwDimPlantRepository;

    @Autowired
    private LoriotControllerImpl loriotController;

    @Override
    public int insertPlant(PlantWithSensor plantWithSensor)
    {
        DimPlant savedPlant = dimPlantRepository.save(plantWithSensor.getPlant());
        int plantId = savedPlant.getPlant_ID();
        String finalString = "";
        finalString += convertIntTo4DigitHexString(plantId);
        finalString += convertIntTo4DigitHexString(plantWithSensor.getSensor().getTemp_humidity_sensor_id());
        finalString += convertIntTo4DigitHexString(plantWithSensor.getSensor().getLight_sensor_id());
        finalString += convertIntTo4DigitHexString(plantWithSensor.getSensor().getCo2_sensor_id());
        loriotController.send(new Command(finalString, 2));
        return plantId;
    }

    private String convertIntTo4DigitHexString(int integer){
        String hex = Integer.toHexString(integer);
        String string = "";
        for (int i = 0; i < 4 - hex.length(); i++) {
            string += "0";
        }
        string += hex;
        return string;
    }

    @Override
    public List<DimPlant> getAllPlants() {
        //return edwDimPlantRepository.findAll();
        return dimPlantRepository.findAll();
    }
}
