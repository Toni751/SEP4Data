package via.sep4gr2.sep4websocketstest.models.database;

import javax.persistence.*;

@Entity
@Table(name = "dim_garden", schema = "stage")
public class DimGarden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int garden_ID;
    private String name;
    private String owner_google_id;
    private String assistant_google_id;
    private double land_area;
    private String city;
    private String street;
    private String number;

    public String getOwner_google_id() {
        return owner_google_id;
    }

    public void setOwner_google_id(String owner_google_id) {
        this.owner_google_id = owner_google_id;
    }

    public String getAssistant_google_id() {
        return assistant_google_id;
    }

    public void setAssistant_google_id(String assistant_google_id) {
        this.assistant_google_id = assistant_google_id;
    }

    public int getGarden_ID() {
        return garden_ID;
    }

    public void setGarden_ID(int garden_ID) {
        this.garden_ID = garden_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLand_area() {
        return land_area;
    }

    public void setLand_area(double land_area) {
        this.land_area = land_area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
