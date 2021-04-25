package via.sep4gr2.sep4websocketstest.loriotconnection;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import via.sep4gr2.sep4websocketstest.models.Command;
import via.sep4gr2.sep4websocketstest.models.DownLinkMessage;
import via.sep4gr2.sep4websocketstest.models.SensorData;
import via.sep4gr2.sep4websocketstest.models.UpLinkMessage;

import java.beans.PropertyChangeEvent;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import org.apache.commons.codec.binary.Hex;

@Component
public class LoriotControllerImpl implements LoriotController{
    private final Gson gson = new Gson();
    private LoriotWebSocketClient socketClient;

    public LoriotControllerImpl() {
        socketClient = new LoriotWebSocketClient();
        socketClient.addPropertyChangeListener("RECEIVED_DATA", this::receiveData);
        send(new Command("tx", "pulanpizda", 109)); // produces null pointer exception because the websocket instance in the client is null
    }

    private void send(Command command) {
        System.out.println("Sending command " + command.toString());
        String string = processCommand(command);
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
    }

    private SensorData processData(UpLinkMessage message) {
        //source
        SensorData sensorData = new SensorData();
        sensorData.setSource(message.getEUI());

        //timestamp
        long timestampS = message.getTs();
        LocalDateTime triggerTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampS), TimeZone
                        .getDefault().toZoneId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = formatter.format(triggerTime);

        //data
        Iterable<String> result = Splitter.fixedLength(4).split(message.getData());
        String[] parts = Iterables.toArray(result, String.class);

        String tempSHex = parts[0];
        String humSHex = parts[1];
        String co2Hex = parts[2];
        String soundHex = parts[3];


        int temp = Integer.parseInt(tempSHex, 16);
        int tempR = temp / 10;
        int hum = Integer.parseInt(humSHex, 16);
        int humR = hum / 10;
        int co2 = Integer.parseInt(co2Hex, 16);
        int soundR = Integer.parseInt(soundHex, 16);
        int light = soundR / 10;

        sensorData.setTimeStamp(formatted);
        sensorData.setHumidity(humR);
        sensorData.setTemperature(tempR);
        sensorData.setCo2(co2);
        sensorData.setLight(light);

        return sensorData;
    }

    private String processCommand(Command command) {
        String data = "" + command.getCommandId() + command.getValue();
        String hex = Hex.encodeHexString(data.getBytes());

        DownLinkMessage message = new DownLinkMessage(command.getDestinationPort(), true, hex);
        String json = gson.toJson(message);
        return json;
    }
}
