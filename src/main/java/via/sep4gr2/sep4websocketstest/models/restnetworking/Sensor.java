package via.sep4gr2.sep4websocketstest.models.restnetworking;

public class Sensor {
    private int lightSensorId;
    private int co2SensorId;
    private int tempHumiditySensorId;

    public Sensor(int lightSensorId, int co2SensorId, int tempHumiditySensorId) {
        this.lightSensorId = lightSensorId;
        this.co2SensorId = co2SensorId;
        this.tempHumiditySensorId = tempHumiditySensorId;
    }

    public int getLightSensorId() {
        return lightSensorId;
    }

    public int getCo2SensorId() {
        return co2SensorId;
    }

    public int getTempHumiditySensorId() {
        return tempHumiditySensorId;
    }
}
