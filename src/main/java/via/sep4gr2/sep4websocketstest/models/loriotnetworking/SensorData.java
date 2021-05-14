package via.sep4gr2.sep4websocketstest.models.loriotnetworking;

public class SensorData {
    private String date;
    private String time;
    private int humidity;
    private int temperature;
    private int light;
    private int co2;
    private int plantId;


    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                ", light=" + light +
                ", co2=" + co2 +
                ", plantId=" + plantId +
                '}';
    }
}
