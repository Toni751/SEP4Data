package via.sep4gr2.sep4websocketstest.models.databaseEDW;

import javax.persistence.*;

@Entity
@Table(name = "fact_plant_status", schema = "edw")
@IdClass(EDWFactPlantStatusId.class)
public class EDWFactPlantStatus
{
    @ManyToOne
    @Id
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    private EDWDimPlant PID;

    @ManyToOne
    @Id
    @JoinColumn(name = "D_ID", referencedColumnName = "D_ID")
    private EDWDimDate DID;

    @ManyToOne
    @Id
    @JoinColumn(name = "T_ID", referencedColumnName = "T_ID")
    private EDWDimTime TID;

    @ManyToOne
    @Id
    @JoinColumn(name = "M_ID", referencedColumnName = "M_ID")
    private EDWDimMeasurement MID;

    private double MeasurementValue;

    public EDWDimMeasurement getMID()
    {
        return MID;
    }

    public void setMID(EDWDimMeasurement measurement_type)
    {
        this.MID = measurement_type;
    }

    public EDWDimPlant getPID()
    {
        return PID;
    }

    public void setPID(EDWDimPlant PID)
    {
        this.PID = PID;
    }

    public double getMeasurementValue()
    {
        return MeasurementValue;
    }

    public EDWDimDate getDID()
    {
        return DID;
    }

    public void setDID(EDWDimDate DID)
    {
        this.DID = DID;
    }

    public EDWDimTime getTID()
    {
        return TID;
    }

    public void setTID(EDWDimTime TID)
    {
        this.TID = TID;
    }

    public void setMeasurementValue(double measurement_value)
    {
        this.MeasurementValue = measurement_value;
    }
}
