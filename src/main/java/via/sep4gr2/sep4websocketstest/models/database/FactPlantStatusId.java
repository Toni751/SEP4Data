package via.sep4gr2.sep4websocketstest.models.database;

import java.io.Serializable;
import java.util.Objects;

public class FactPlantStatusId implements Serializable
{
    private int plantID;
    private String statusDate;
    private String statusTime;
    private int measurementID;

    public FactPlantStatusId()
    {
    }

    public FactPlantStatusId(int plantID, String statusDate, String statusTime, int measurementID)
    {
        this.plantID = plantID;
        this.statusDate = statusDate;
        this.statusTime = statusTime;
        this.measurementID = measurementID;
    }

    public int getPlantID()
    {
        return plantID;
    }


    public String getStatusDate()
    {
        return statusDate;
    }

    public String getStatusTime()
    {
        return statusTime;
    }

    public int getMeasurementID() {
        return measurementID;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactPlantStatusId that = (FactPlantStatusId) o;
        return plantID == that.plantID && statusDate.equals(that.statusDate) && statusTime.equals(that.statusTime) && measurementID == that.measurementID;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(plantID, statusDate, statusTime, measurementID);
    }
}
