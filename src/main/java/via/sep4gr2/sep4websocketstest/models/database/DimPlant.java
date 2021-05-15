package via.sep4gr2.sep4websocketstest.models.database;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dim_plant", schema = "stage")
public class DimPlant
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_ID")
    private int plantID;

    @Column(name = "garden_name")
    private String gardenName;

    private int height;
    private int width;

    @Column(name = "stage_of_growth")
    private String stageOfGrowth;

    @Column(name = "soil_type")
    private String soilType;

    @Column(name = "own_soil_volume")
    private int ownSoilVolume;

    @Column(name = "garden_location")
    private String gardenLocation;

    @Column(name = "seeded_at", columnDefinition = "DATE")
    private LocalDate seededAt;

    @Column(name = "harvested_at", columnDefinition = "DATE")
    private LocalDate harvestedAt;

    @Column(name = "common_plant_name")
    private String commonPlantName;

    @Column(name = "category_name")
    private String categoryName;

    public String getGardenName()
    {
        return gardenName;
    }

    public void setGardenName(String garden_name)
    {
        this.gardenName = garden_name;
    }

    public int getPlantID()
    {
        return plantID;
    }

    public void setPlantID(int plant_ID)
    {
        this.plantID = plant_ID;
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

    public String getStageOfGrowth()
    {
        return stageOfGrowth;
    }

    public void setStageOfGrowth(String stage_of_growth)
    {
        this.stageOfGrowth = stage_of_growth;
    }

    public String getSoilType()
    {
        return soilType;
    }

    public void setSoilType(String soil_type)
    {
        this.soilType = soil_type;
    }

    public int getOwnSoilVolume()
    {
        return ownSoilVolume;
    }

    public void setOwnSoilVolume(int own_soil_volume)
    {
        this.ownSoilVolume = own_soil_volume;
    }

    public String getGardenLocation()
    {
        return gardenLocation;
    }

    public void setGardenLocation(String garden_location)
    {
        this.gardenLocation = garden_location;
    }

    public LocalDate getSeededAt()
    {
        return seededAt;
    }

    public void setSeededAt(LocalDate seeded_at)
    {
        this.seededAt = seeded_at;
    }

    public LocalDate getHarvestedAt()
    {
        return harvestedAt;
    }

    public void setHarvestedAt(LocalDate harvested_at)
    {
        this.harvestedAt = harvested_at;
    }

    public String getCommonPlantName()
    {
        return commonPlantName;
    }

    public void setCommonPlantName(String common_plant_name)
    {
        this.commonPlantName = common_plant_name;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String category_name)
    {
        this.categoryName = category_name;
    }
}
