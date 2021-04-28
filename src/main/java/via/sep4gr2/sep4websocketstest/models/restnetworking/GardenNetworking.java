package via.sep4gr2.sep4websocketstest.models.restnetworking;

public class GardenNetworking {
    private String name;
    private double land_area;
    private String city;
    private String street;
    private int number;

    private double averageTemperature;
    private double averageHumidity;
    private double averageLight;
    private double averageCO2;

    public GardenNetworking(String name, double land_area, String city, String street, int number, double averageTemperature, double averageHumidity, double averageLight, double averageCO2) {
        this.name = name;
        this.land_area = land_area;
        this.city = city;
        this.street = street;
        this.number = number;
        this.averageTemperature = averageTemperature;
        this.averageHumidity = averageHumidity;
        this.averageLight = averageLight;
        this.averageCO2 = averageCO2;
    }

    public String getName() {
        return name;
    }

    public double getLand_area() {
        return land_area;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public double getAverageHumidity() {
        return averageHumidity;
    }

    public double getAverageLight() {
        return averageLight;
    }

    public double getAverageCO2() {
        return averageCO2;
    }
}
