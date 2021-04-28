package via.sep4gr2.sep4websocketstest.models.restnetworking;

import javax.persistence.Column;
import java.time.LocalDate;

public class PlantNetworking {
    private String unique_plant_name;
    private int height;
    private int width;
    private String stage_of_growth;
    private String soil_type;
    private int own_soil_volume;
    private String garden_location;
    private LocalDate seeded_at;
    private LocalDate harvested_at;
    private String common_plant_name;
    private String category_name;

    private double latestTemperature;
    private double latestLight;
    private double latestHumidity;
    private double latestCO2;

    public PlantNetworking(String unique_plant_name, int height, int width, String stage_of_growth, String soil_type, int own_soil_volume, String garden_location, LocalDate seeded_at, LocalDate harvested_at, String common_plant_name, String category_name, double latestTemperature, double latestLight, double latestHumidity, double latestCO2) {
        this.unique_plant_name = unique_plant_name;
        this.height = height;
        this.width = width;
        this.stage_of_growth = stage_of_growth;
        this.soil_type = soil_type;
        this.own_soil_volume = own_soil_volume;
        this.garden_location = garden_location;
        this.seeded_at = seeded_at;
        this.harvested_at = harvested_at;
        this.common_plant_name = common_plant_name;
        this.category_name = category_name;
        this.latestTemperature = latestTemperature;
        this.latestLight = latestLight;
        this.latestHumidity = latestHumidity;
        this.latestCO2 = latestCO2;
    }

    public String getUnique_plant_name() {
        return unique_plant_name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getStage_of_growth() {
        return stage_of_growth;
    }

    public String getSoil_type() {
        return soil_type;
    }

    public int getOwn_soil_volume() {
        return own_soil_volume;
    }

    public String getGarden_location() {
        return garden_location;
    }

    public LocalDate getSeeded_at() {
        return seeded_at;
    }

    public LocalDate getHarvested_at() {
        return harvested_at;
    }

    public String getCommon_plant_name() {
        return common_plant_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public double getLatestTemperature() {
        return latestTemperature;
    }

    public double getLatestLight() {
        return latestLight;
    }

    public double getLatestHumidity() {
        return latestHumidity;
    }

    public double getLatestCO2() {
        return latestCO2;
    }
}
