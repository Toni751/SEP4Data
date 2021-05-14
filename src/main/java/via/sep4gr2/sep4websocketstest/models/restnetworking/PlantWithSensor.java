package via.sep4gr2.sep4websocketstest.models.restnetworking;

import via.sep4gr2.sep4websocketstest.models.database.DimPlant;

public class PlantWithSensor {
    private DimPlant plant;
    private Sensor sensor;

    public PlantWithSensor(DimPlant plant, Sensor sensor) {
        this.plant = plant;
        this.sensor = sensor;
    }

    public DimPlant getPlant() {
        return plant;
    }

    public Sensor getSensor() {
        return sensor;
    }
}
