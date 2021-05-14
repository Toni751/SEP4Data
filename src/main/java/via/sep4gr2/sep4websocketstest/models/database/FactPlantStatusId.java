package via.sep4gr2.sep4websocketstest.models.database;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class FactPlantStatusId implements Serializable
{
    private int plant_ID;
    private String status_date;
    private String status_time;
    private String measurement_type;

    public FactPlantStatusId()
    {
    }

    public FactPlantStatusId(int plant_ID, String status_date, String status_time, String measurement_type)
    {
        this.plant_ID = plant_ID;
        this.status_date = status_date;
        this.status_time = status_time;
        this.measurement_type = measurement_type;
    }

    public int getPlant_ID()
    {
        return plant_ID;
    }


    public String getStatus_date()
    {
        return status_date;
    }

    public String getStatus_time()
    {
        return status_time;
    }

    public String getMeasurement_type() {
        return measurement_type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactPlantStatusId that = (FactPlantStatusId) o;
        return plant_ID == that.plant_ID && status_date.equals(that.status_date) && status_time.equals(that.status_time) && measurement_type.equals(that.measurement_type);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(plant_ID, status_date, status_time, measurement_type);
    }
}
