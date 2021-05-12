package via.sep4gr2.sep4websocketstest.models.databaseEDW;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "DimTime", schema = "edw")
public class EDWDimTime
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int T_ID;
    @Column(columnDefinition = "TIME")
    private LocalTime time;
    private int Hour;
    private int Minute;
    private int Second;
    private String DayPeriod;

    public int getT_ID()
    {
        return T_ID;
    }

    public void setT_ID(int t_ID)
    {
        T_ID = t_ID;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    public int getHour()
    {
        return Hour;
    }

    public void setHour(int hour)
    {
        Hour = hour;
    }

    public int getMinute()
    {
        return Minute;
    }

    public void setMinute(int minute)
    {
        Minute = minute;
    }

    public int getSecond()
    {
        return Second;
    }

    public void setSecond(int second)
    {
        Second = second;
    }

    public String getDayPeriod()
    {
        return DayPeriod;
    }

    public void setDayPeriod(String dayPeriod)
    {
        DayPeriod = dayPeriod;
    }
}
