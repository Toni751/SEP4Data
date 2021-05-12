package via.sep4gr2.sep4websocketstest.models.databaseEDW;

import java.io.Serializable;
import java.util.Objects;

public class EDWFactPlantStatusId implements Serializable
{
    private int P_ID;
    private int D_ID;
    private int T_ID;

    public EDWFactPlantStatusId()
    {
    }

    public EDWFactPlantStatusId(int p_ID, int d_ID, int t_ID)
    {
        P_ID = p_ID;
        D_ID = d_ID;
        T_ID = t_ID;
    }

    public int getP_ID()
    {
        return P_ID;
    }

    public void setP_ID(int p_ID)
    {
        P_ID = p_ID;
    }

    public int getD_ID()
    {
        return D_ID;
    }

    public void setD_ID(int d_ID)
    {
        D_ID = d_ID;
    }

    public int getT_ID()
    {
        return T_ID;
    }

    public void setT_ID(int t_ID)
    {
        T_ID = t_ID;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EDWFactPlantStatusId that = (EDWFactPlantStatusId) o;
        return P_ID == that.P_ID && D_ID == that.D_ID && T_ID == that.T_ID;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(P_ID, D_ID, T_ID);
    }
}
