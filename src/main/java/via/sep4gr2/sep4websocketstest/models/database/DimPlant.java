package via.sep4gr2.sep4websocketstest.models.database;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dim_plant", schema = "stage")
public class DimPlant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_ID")
    private int plant_ID;

    @Column(name = "garden_name")
    private String garden_name;

    private int height;

    @Column(name = "stage_of_growth")
    private String stage_of_growth;

    @Column(name = "soil_type")
    private String soil_type;

    @Column(name = "own_soil_volume")
    private int own_soil_volume;

    @Column(name = "garden_location")
    private String garden_location;

    @Column(name = "seeded_at", columnDefinition = "DATE")
    private LocalDate seeded_at;

    @Column(name = "harvested_at", columnDefinition = "DATE")
    private LocalDate harvested_at;

    @Column(name = "common_plant_name")
    private String common_plant_name;

    @Column(name = "category_name")
    private String category_name;

    public String getGarden_name() {
        return garden_name;
    }

    public void setGarden_name(String garden_name) {
        this.garden_name = garden_name;
    }

    public int getPlant_ID() {
        return plant_ID;
    }

    public void setPlant_ID(int plant_ID) {
        this.plant_ID = plant_ID;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getStage_of_growth() {
        return stage_of_growth;
    }

    public void setStage_of_growth(String stage_of_growth) {
        this.stage_of_growth = stage_of_growth;
    }

    public String getSoil_type() {
        return soil_type;
    }

    public void setSoil_type(String soil_type) {
        this.soil_type = soil_type;
    }

    public int getOwn_soil_volume() {
        return own_soil_volume;
    }

    public void setOwn_soil_volume(int own_soil_volume) {
        this.own_soil_volume = own_soil_volume;
    }

    public String getGarden_location() {
        return garden_location;
    }

    public void setGarden_location(String garden_location) {
        this.garden_location = garden_location;
    }

    public LocalDate getSeeded_at() {
        return seeded_at;
    }

    public void setSeeded_at(LocalDate seeded_at) {
        this.seeded_at = seeded_at;
    }

    public LocalDate getHarvested_at() {
        return harvested_at;
    }

    public void setHarvested_at(LocalDate harvested_at) {
        this.harvested_at = harvested_at;
    }

    public String getCommon_plant_name() {
        return common_plant_name;
    }

    public void setCommon_plant_name(String common_plant_name) {
        this.common_plant_name = common_plant_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
