package pogodynka.database.dao;

import pogodynka.model.Weather;

import java.util.List;

public interface WeatherDao {

    void save(Weather weather);
    List<Weather> findAll();
    List<Weather> findByName(Weather weather);
    Weather findById(int id);
}
