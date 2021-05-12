package via.sep4gr2.sep4websocketstest.models.databaseEDW;

import javax.persistence.*;

@Entity
@Table(name = "FactPlantStatus", schema = "edw")
@IdClass(EDWFactPlantStatusId.class)
public class EDWFactPlantStatus
{
    @ManyToOne
    @Id
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    private EDWDimPlant P_ID;

    @ManyToOne
    @Id
    @JoinColumn(name = "D_ID", referencedColumnName = "D_ID")
    private EDWDimDate D_ID;

    @ManyToOne
    @Id
    @JoinColumn(name = "T_ID", referencedColumnName = "T_ID")
    private EDWDimTime T_ID;


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

    public EDWDimPlant getP_ID()
    {
        return P_ID;
    }

    public void setP_ID(EDWDimPlant p_ID)
    {
        this.P_ID = p_ID;
    }

    public double getMeasurementValue()
    {
        return MeasurementValue;
    }

    public EDWDimDate getD_ID()
    {
        return D_ID;
    }

    public void setD_ID(EDWDimDate d_ID)
    {
        D_ID = d_ID;
    }

    public EDWDimTime getT_ID()
    {
        return T_ID;
    }

    public void setT_ID(EDWDimTime t_ID)
    {
        T_ID = t_ID;
    }

    public void setMeasurementValue(double measurement_value)
    {
        this.MeasurementValue = measurement_value;
    }
}
