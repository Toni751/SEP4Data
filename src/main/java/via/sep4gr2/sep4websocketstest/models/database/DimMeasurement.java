package via.sep4gr2.sep4websocketstest.models.database;

import javax.persistence.*;

@Entity
@Table(name = "dim_measurement", schema = "stage")
public class DimMeasurement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_ID")
    private int measurementID;

    @Column(name = "measurement_name")
    private String measurementName;

    public int getMeasurementID()
    {
        return measurementID;
    }

    public void setMeasurementID(int measurementID)
    {
        this.measurementID = measurementID;
    }

    public String getMeasurementName()
    {
        return measurementName;
    }

    public void setMeasurementName(String measurementName)
    {
        this.measurementName = measurementName;
    }
}
