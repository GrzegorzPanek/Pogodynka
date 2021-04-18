package pogodynka.database.dao;

import pogodynka.model.Location;

import java.util.List;

public interface LocationDao {

    void save(Location location);
    List<Location> findByName(String name);
    List<Location> findAll();
    Location findByLongitude(double longitude);
    Location findByLatitude(double latitude);
}
