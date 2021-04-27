package via.sep4gr2.sep4websocketstest.models.networking;

public class SensorData {
    private String source;
    private String timeStamp;
    private int humidity;
    private int temperature;
    private int light;
    private int co2;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
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
                "source='" + source + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                ", light=" + light +
                ", co2=" + co2 +
                '}';
    }
}
