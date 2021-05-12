package via.sep4gr2.sep4websocketstest.models.databaseEDW;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DimDate", schema = "edw")
public class EDWDimDate
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int D_ID;
    @Column(columnDefinition = "DATE")
    private LocalDate Date;
    private int Day;
    private int Month;
    private String MonthName;
    private String Season;
    private int Week;
    private int Quarter;
    private int Year;
    private int DayOfWeek;
    private String WeekdayName;

    public int getD_ID()
    {
        return D_ID;
    }

    public void setD_ID(int d_ID)
    {
        D_ID = d_ID;
    }

    public LocalDate getDate()
    {
        return Date;
    }

    public void setDate(LocalDate date)
    {
        Date = date;
    }

    public int getDay()
    {
        return Day;
    }

    public void setDay(int day)
    {
        Day = day;
    }

    public int getMonth()
    {
        return Month;
    }

    public void setMonth(int month)
    {
        Month = month;
    }

    public String getMonthName()
    {
        return MonthName;
    }

    public void setMonthName(String monthName)
    {
        MonthName = monthName;
    }

    public String getSeason()
    {
        return Season;
    }

    public void setSeason(String season)
    {
        Season = season;
    }

    public int getWeek()
    {
        return Week;
    }

    public void setWeek(int week)
    {
        Week = week;
    }

    public int getQuarter()
    {
        return Quarter;
    }

    public void setQuarter(int quarter)
    {
        Quarter = quarter;
    }

    public int getYear()
    {
        return Year;
    }

    public void setYear(int year)
    {
        Year = year;
    }

    public int getDayOfWeek()
    {
        return DayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek)
    {
        DayOfWeek = dayOfWeek;
    }

    public String getWeekdayName()
    {
        return WeekdayName;
    }

    public void setWeekdayName(String weekdayName)
    {
        WeekdayName = weekdayName;
    }
}
