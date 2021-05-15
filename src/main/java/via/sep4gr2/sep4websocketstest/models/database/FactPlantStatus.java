package via.sep4gr2.sep4websocketstest.models.database;

import javax.persistence.*;

@Entity
@Table(name = "fact_plant_status", schema = "stage")
@IdClass(FactPlantStatusId.class)
public class FactPlantStatus
{
    @ManyToOne
    @Id
    @JoinColumn(name = "plant_ID", referencedColumnName = "plant_ID")
    private DimPlant plantID;

    @Id
    @Column(name = "status_date", columnDefinition = "DATE")
    private String statusDate;

    @Id
    @Column(name = "status_time", columnDefinition = "TIME")
    private String statusTime;

    @Column(name = "measurement_value")
    private double measurementValue;

    @Id
    @Column(name = "measurement_type")
    private String measurementType;

    public String getMeasurementType()
    {
        return measurementType;
    }

    public void setMeasurementType(String measurement_type)
    {
        this.measurementType = measurement_type;
    }

    public DimPlant getPlantID()
    {
        return plantID;
    }

    public void setPlantID(DimPlant plant_ID)
    {
        this.plantID = plant_ID;
    }


    public String getStatusDate()
    {
        return statusDate;
    }

    public void setStatusDate(String status_date)
    {
        this.statusDate = status_date;
    }

    public String getStatusTime()
    {
        return statusTime;
    }

    public void setStatusTime(String status_time)
    {
        this.statusTime = status_time;
    }

    public double getMeasurementValue()
    {
        return measurementValue;
    }

    public void setMeasurementValue(double measurement_value)
    {
        this.measurementValue = measurement_value;
    }

    @Override
    public String toString() {
        return "FactPlantStatus{" +
                "plant_ID=" + plantID +
                ", status_date='" + statusDate + '\'' +
                ", status_time='" + statusTime + '\'' +
                ", measurement_value=" + measurementValue +
                ", measurement_type='" + measurementType + '\'' +
                '}';
    }
}
