package pogodynka.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "city_name", unique = true, nullable = false)
    private String cityName;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private Set<Weather> weatherSet = new HashSet<>();

    public void SetWeathers(Set<Weather> weatherSet) {
        this.weatherSet = weatherSet;
    }

    public Set<Weather> getWeatherSet() {
        return weatherSet;
    }

    private String country;
    private double longitude;
    private double latitude;

    public Location() {
    }

    public Location(int id, String cityName, String country, double longitude, double latitude) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
