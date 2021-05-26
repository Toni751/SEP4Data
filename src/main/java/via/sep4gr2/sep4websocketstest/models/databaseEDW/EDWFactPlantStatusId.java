package via.sep4gr2.sep4websocketstest.models.databaseEDW;

import java.io.Serializable;
import java.util.Objects;

public class EDWFactPlantStatusId implements Serializable
{
    private int PID;
    private int DID;
    private int TID;
    private int MID;

    public EDWFactPlantStatusId()
    {
    }

    public EDWFactPlantStatusId(int PID, int DID, int TID, int MID)
    {
        this.PID = PID;
        this.DID = DID;
        this.TID = TID;
        this.MID = MID;
    }

    public int getPID()
    {
        return PID;
    }

    public void setPID(int PID)
    {
        this.PID = PID;
    }

    public int getDID()
    {
        return DID;
    }

    public void setDID(int DID)
    {
        this.DID = DID;
    }

    public int getTID()
    {
        return TID;
    }

    public void setTID(int TID)
    {
        this.TID = TID;
    }

    public int getMID()
    {
        return MID;
    }

    public void setMID(int MID)
    {
        this.MID = MID;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EDWFactPlantStatusId that = (EDWFactPlantStatusId) o;
        return PID == that.PID && DID == that.DID && TID == that.TID && MID == that.MID;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(PID, DID, TID, MID);
    }
}
