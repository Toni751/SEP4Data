package via.sep4gr2.sep4websocketstest.models.database;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class FactPlantStatusId implements Serializable {
    private int plant_ID;
    private int garden_ID;
    private LocalDate status_date;
    private LocalTime status_time;

    public FactPlantStatusId() {
    }

    public FactPlantStatusId(int plant_ID, int garden_ID, LocalDate status_date, LocalTime status_time) {
        this.plant_ID = plant_ID;
        this.garden_ID = garden_ID;
        this.status_date = status_date;
        this.status_time = status_time;
    }

    public int getPlant_ID() {
        return plant_ID;
    }

    public int getGarden_ID() {
        return garden_ID;
    }

    public LocalDate getStatus_date() {
        return status_date;
    }

    public LocalTime getStatus_time() {
        return status_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactPlantStatusId that = (FactPlantStatusId) o;
        return plant_ID == that.plant_ID && garden_ID == that.garden_ID && status_date.equals(that.status_date) && status_time.equals(that.status_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plant_ID, garden_ID, status_date, status_time);
    }
}
