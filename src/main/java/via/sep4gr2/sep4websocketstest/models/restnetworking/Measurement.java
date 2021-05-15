package via.sep4gr2.sep4websocketstest.models.restnetworking;

public class Measurement {
    private String date;
    private String time;
    private double measurementValue;
    private String measurementType;

    public Measurement(String date, String time, double measurementValue, String measurementType) {
        this.date = date;
        this.time = time;
        this.measurementValue = measurementValue;
        this.measurementType = measurementType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }
}
