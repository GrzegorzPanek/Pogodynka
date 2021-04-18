package pogodynka.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Weather")
public class Weather {

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;

    private Location getLocation() {
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "temperature")
    private double temperature;

    private double pressure;
    private double wind;
    private double clouds;
    private double humidity;

    public Weather() {
    }

    public Weather(int id, double temperature, double pressure, double wind, double clouds, double humidity) {
        this.id = id;
        this.temperature = temperature;
        this.pressure = pressure;
        this.wind = wind;
        this.clouds = clouds;
        this.humidity = humidity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public double getClouds() {
        return clouds;
    }

    public void setClouds(double clouds) {
        this.clouds = clouds;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
