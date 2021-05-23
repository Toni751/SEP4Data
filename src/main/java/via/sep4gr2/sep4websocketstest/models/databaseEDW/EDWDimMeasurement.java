package via.sep4gr2.sep4websocketstest.models.databaseEDW;

import javax.persistence.*;

@Entity
@Table(name="dim_measurement", schema = "edw")
public class EDWDimMeasurement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int M_ID;
    private  int measurement_ID;
    private String measurement_name;

    public int getM_ID()
    {
        return M_ID;
    }

    public void setM_ID(int m_ID)
    {
        M_ID = m_ID;
    }

    public int getMeasurement_ID()
    {
        return measurement_ID;
    }

    public void setMeasurement_ID(int measurement_ID)
    {
        this.measurement_ID = measurement_ID;
    }

    public String getMeasurement_name()
    {
        return measurement_name;
    }

    public void setMeasurement_name(String measurement_name)
    {
        this.measurement_name = measurement_name;
    }
}
