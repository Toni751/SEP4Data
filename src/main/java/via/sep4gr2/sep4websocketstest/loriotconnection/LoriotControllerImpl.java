package via.sep4gr2.sep4websocketstest.loriotconnection;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import via.sep4gr2.sep4websocketstest.models.database.DimMeasurement;
import via.sep4gr2.sep4websocketstest.models.database.DimPlant;
import via.sep4gr2.sep4websocketstest.models.database.FactPlantStatus;
import via.sep4gr2.sep4websocketstest.models.loriotnetworking.Command;
import via.sep4gr2.sep4websocketstest.models.loriotnetworking.DownLinkMessage;
import via.sep4gr2.sep4websocketstest.models.loriotnetworking.SensorData;
import via.sep4gr2.sep4websocketstest.models.loriotnetworking.UpLinkMessage;

import java.beans.PropertyChangeEvent;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import via.sep4gr2.sep4websocketstest.repositories.DimMeasurementRepository;
import via.sep4gr2.sep4websocketstest.repositories.DimPlantRepository;
import via.sep4gr2.sep4websocketstest.services.MeasurementService;

@Component
public class LoriotControllerImpl{
    private final Gson gson = new Gson();
    private final LoriotWebSocketClient socketClient;

    private final MeasurementService measurementService;

    private final DimPlantRepository plantRepository;

    private final DimMeasurementRepository measurementRepository;

    public LoriotControllerImpl(DimPlantRepository plantRepository, MeasurementService measurementService, DimMeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
        socketClient = new LoriotWebSocketClient();
        socketClient.addPropertyChangeListener("RECEIVED_DATA", this::receiveData);
        // send(new Command("tx", "hello there?", 109)); // produces null pointer exception because the websocket instance in the client is null
        this.plantRepository = plantRepository;
        this.measurementService = measurementService;
        // receiveMessage(new UpLinkMessage(Instant.now().toEpochMilli(), true, 123, 1027, "10313016211c42ac"));
    }

    public void send(Command command) {
        System.out.println("Sending command " + command.toString());
        String string = processCommand(command);
        System.out.println("Sending downlink " + string);
        socketClient.sendDownLink(string);
    }

    public void receiveData(PropertyChangeEvent event) {
        String receivedString = event.getNewValue().toString();
        System.out.println("Received data " + receivedString);
        UpLinkMessage message = gson.fromJson(receivedString, UpLinkMessage.class);
        if (message.getCmd().equals("rx")) {
             receiveMessage(message);
        }
    }

    private void receiveMessage(UpLinkMessage message) {
        SensorData sensorData = processData(message);
        System.out.println("Received message: " + sensorData);
        // DimPlant plant = plantRepository.getPlantById(sensorData.getPlantId());
        List<DimPlant> allPlants = plantRepository.findAll();
        List<DimMeasurement> measurements = measurementRepository.findAll();

        List<FactPlantStatus> statuses = new ArrayList<>();

        DimMeasurement tempMeasurement = new DimMeasurement();
        DimMeasurement humMeasurement = new DimMeasurement();
        DimMeasurement lightMeasurement = new DimMeasurement();
        DimMeasurement co2Measurement = new DimMeasurement();

        for (DimMeasurement measurement : measurements) {
            switch (measurement.getMeasurementName()){
                case "TEMP":
                    tempMeasurement = measurement;
                    break;
                case "LIGHT":
                    lightMeasurement = measurement;
                    break;
                case "CO2":
                    co2Measurement = measurement;
                    break;
                case "HUM":
                    humMeasurement = measurement;
                    break;
            }
        }

        for (DimPlant plant : allPlants) {
            if(sensorData.getTemperature() > 0){
                FactPlantStatus plantStatus = new FactPlantStatus();
                plantStatus.setPlantID(plant);
                plantStatus.setStatusDate(sensorData.getDate());
                plantStatus.setStatusTime(sensorData.getTime());
                plantStatus.setMeasurementID(tempMeasurement);
                plantStatus.setMeasurementValue(sensorData.getTemperature());
                statuses.add(plantStatus);
            }
            if(sensorData.getHumidity() > 0){
                FactPlantStatus plantStatus = new FactPlantStatus();
                plantStatus.setPlantID(plant);
                plantStatus.setStatusDate(sensorData.getDate());
                plantStatus.setStatusTime(sensorData.getTime());
                plantStatus.setMeasurementID(humMeasurement);
                plantStatus.setMeasurementValue(sensorData.getHumidity());
                statuses.add(plantStatus);
            }
            if(sensorData.getLight() > 0){
                FactPlantStatus plantStatus = new FactPlantStatus();
                plantStatus.setPlantID(plant);
                plantStatus.setStatusDate(sensorData.getDate());
                plantStatus.setStatusTime(sensorData.getTime());
                plantStatus.setMeasurementID(lightMeasurement);
                plantStatus.setMeasurementValue(sensorData.getLight());
                statuses.add(plantStatus);
            }
            if(sensorData.getCo2() > 0){
                FactPlantStatus plantStatus = new FactPlantStatus();
                plantStatus.setPlantID(plant);
                plantStatus.setStatusDate(sensorData.getDate());
                plantStatus.setStatusTime(sensorData.getTime());
                plantStatus.setMeasurementID(co2Measurement);
                plantStatus.setMeasurementValue(sensorData.getCo2());
                statuses.add(plantStatus);
            }
        }

        System.out.println("Statues length " + statuses.size());
        measurementService.add(statuses);
    }

    private SensorData processData(UpLinkMessage message) {
        SensorData sensorData = new SensorData();

        long timestampS = message.getTs();
        LocalDateTime triggerTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampS), TimeZone
                        .getDefault().toZoneId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = formatter.format(triggerTime);
        System.out.println("Formatted date " + formatted);
        String date = formatted.split(" ")[0];
        String time = formatted.split(" ")[1];
        time = time.substring(0, 6) + "00";

        System.out.println("Date " + date);
        System.out.println("Time " + time);
        //data
        System.out.println("Splitting message with data " + message.getData());
        Iterable<String> result = Splitter.fixedLength(4).split(message.getData());
        String[] parts = Iterables.toArray(result, String.class);
        System.out.println("Got message data parts " + Arrays.toString(parts));
//  102a 301c 2012 405c
        int temp = 0;
        int hum = 0;
        int co2 = 0;
        int light = 0;

        for (String part : parts) {
            String tempString = part.substring(1);
            switch (part.charAt(0)) {
                case '1':
                    hum = Integer.parseInt(tempString, 16);
                    break;
                case '2':
                    co2 = Integer.parseInt(tempString, 16);
                    break;
                case '3':
                    temp = Integer.parseInt(tempString, 16);
                    break;
                case '4':
                    light = Integer.parseInt(tempString, 16);
                    break;
            }
        }

        sensorData.setDate(date);
        sensorData.setTime(time);
        sensorData.setHumidity(hum);
        sensorData.setTemperature(temp);
        sensorData.setCo2(co2);
        sensorData.setLight(light);

        return sensorData;
    }

    private String processCommand(Command command) {
        String data = command.getValue();
        //String hex = Hex.encodeHexString(data.getBytes());

        DownLinkMessage message = new DownLinkMessage(command.getDestinationPort(), true, data);
        return gson.toJson(message);
    }
}
