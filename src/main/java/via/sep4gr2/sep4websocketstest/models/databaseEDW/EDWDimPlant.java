package via.sep4gr2.sep4websocketstest.models.databaseEDW;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DimPlant", schema = "edw")
public class EDWDimPlant
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int P_ID;
    private int plant_ID;
    private String garden_name;
    private int height;
    private int width;
    private String stage_of_growth;
    private String soil_type;
    private int own_soil_volume;
    private String garden_location;

    @Column(columnDefinition = "DATE")
    private LocalDate seeded_at;

    @Column(columnDefinition = "DATE")
    private LocalDate harvested_at;

    private String common_plant_name;
    private String category_name;
    private int ValidFrom;
    private int ValidTo;

    public int getP_ID()
    {
        return P_ID;
    }

    public void setP_ID(int p_ID)
    {
        P_ID = p_ID;
    }

    public int getValidFrom()
    {
        return ValidFrom;
    }

    public void setValidFrom(int validFrom)
    {
        ValidFrom = validFrom;
    }

    public int getValidTo()
    {
        return ValidTo;
    }

    public void setValidTo(int validTo)
    {
        ValidTo = validTo;
    }

    public String getGarden_name()
    {
        return garden_name;
    }

    public void setGarden_name(String garden_name)
    {
        this.garden_name = garden_name;
    }

    public int getPlant_ID()
    {
        return plant_ID;
    }

    public void setPlant_ID(int plant_ID)
    {
        this.plant_ID = plant_ID;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public String getStage_of_growth()
    {
        return stage_of_growth;
    }

    public void setStage_of_growth(String stage_of_growth)
    {
        this.stage_of_growth = stage_of_growth;
    }

    public String getSoil_type()
    {
        return soil_type;
    }

    public void setSoil_type(String soil_type)
    {
        this.soil_type = soil_type;
    }

    public int getOwn_soil_volume()
    {
        return own_soil_volume;
    }

    public void setOwn_soil_volume(int own_soil_volume)
    {
        this.own_soil_volume = own_soil_volume;
    }

    public String getGarden_location()
    {
        return garden_location;
    }

    public void setGarden_location(String garden_location)
    {
        this.garden_location = garden_location;
    }

    public LocalDate getSeeded_at()
    {
        return seeded_at;
    }

    public void setSeeded_at(LocalDate seeded_at)
    {
        this.seeded_at = seeded_at;
    }

    public LocalDate getHarvested_at()
    {
        return harvested_at;
    }

    public void setHarvested_at(LocalDate harvested_at)
    {
        this.harvested_at = harvested_at;
    }

    public String getCommon_plant_name()
    {
        return common_plant_name;
    }

    public void setCommon_plant_name(String common_plant_name)
    {
        this.common_plant_name = common_plant_name;
    }

    public String getCategory_name()
    {
        return category_name;
    }

    public void setCategory_name(String category_name)
    {
        this.category_name = category_name;
    }
}
