package via.sep4gr2.sep4websocketstest.models.restnetworking;

public class Sensor {
    private int light_sensor_id;
    private int co2_sensor_id;
    private int temp_humidity_sensor_id;

    public Sensor(int light_sensor_id, int co2_sensor_id, int temp_humidity_sensor_id) {
        this.light_sensor_id = light_sensor_id;
        this.co2_sensor_id = co2_sensor_id;
        this.temp_humidity_sensor_id = temp_humidity_sensor_id;
    }

    public int getLight_sensor_id() {
        return light_sensor_id;
    }

    public int getCo2_sensor_id() {
        return co2_sensor_id;
    }

    public int getTemp_humidity_sensor_id() {
        return temp_humidity_sensor_id;
    }
}
