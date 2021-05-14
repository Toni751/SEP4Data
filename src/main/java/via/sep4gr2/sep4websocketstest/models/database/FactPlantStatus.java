package via.sep4gr2.sep4websocketstest.models.database;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "fact_plant_status", schema = "stage")
@IdClass(FactPlantStatusId.class)
public class FactPlantStatus
{
    @ManyToOne
    @Id
    @JoinColumn(name = "plant_ID", referencedColumnName = "plant_ID")
    private DimPlant plant_ID;

    @Id
    @Column(columnDefinition = "DATE")
    private String status_date;

    @Id
    @Column(columnDefinition = "TIME")
    private String status_time;

    private double measurement_value;

    @Id
    private String measurement_type;

    public String getMeasurement_type()
    {
        return measurement_type;
    }

    public void setMeasurement_type(String measurement_type)
    {
        this.measurement_type = measurement_type;
    }

    public DimPlant getPlant_ID()
    {
        return plant_ID;
    }

    public void setPlant_ID(DimPlant plant_ID)
    {
        this.plant_ID = plant_ID;
    }


    public String getStatus_date()
    {
        return status_date;
    }

    public void setStatus_date(String status_date)
    {
        this.status_date = status_date;
    }

    public String getStatus_time()
    {
        return status_time;
    }

    public void setStatus_time(String status_time)
    {
        this.status_time = status_time;
    }

    public double getMeasurement_value()
    {
        return measurement_value;
    }

    public void setMeasurement_value(double measurement_value)
    {
        this.measurement_value = measurement_value;
    }
}
