package via.sep4gr2.sep4websocketstest.models.databaseEDW;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "FactPlantStatus", schema = "edw")
@IdClass(FactPlantStatusId.class)
public class FactPlantStatus
{
    @ManyToOne
    @Id
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    private DimPlant plant_ID;

    @ManyToOne
    @Id
    @JoinColumn(name = "D_ID", referencedColumnName = "D_ID")
    private DimDate D_ID;

    @ManyToOne
    @Id
    @JoinColumn(name = "T_ID", referencedColumnName = "T_ID")
    private DimTime T_ID;


    private double MeasurementValue;
    private String MeasurementType;

    public String getMeasurementType()
    {
        return MeasurementType;
    }

    public void setMeasurementType(String measurement_type)
    {
        this.MeasurementType = measurement_type;
    }

    public DimPlant getPlant_ID()
    {
        return plant_ID;
    }

    public void setPlant_ID(DimPlant plant_ID)
    {
        this.plant_ID = plant_ID;
    }

    public double getMeasurementValue()
    {
        return MeasurementValue;
    }

    public DimDate getD_ID()
    {
        return D_ID;
    }

    public void setD_ID(DimDate d_ID)
    {
        D_ID = d_ID;
    }

    public DimTime getT_ID()
    {
        return T_ID;
    }

    public void setT_ID(DimTime t_ID)
    {
        T_ID = t_ID;
    }

    public void setMeasurementValue(double measurement_value)
    {
        this.MeasurementValue = measurement_value;
    }
}
