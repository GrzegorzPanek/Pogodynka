package pogodynka.interaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pogodynka.database.dao.LocationDao;
import pogodynka.database.dao_implementation.LocationDaoImpl;
import pogodynka.database.utils.HibernateUtils;
import pogodynka.model.Location;
import pogodynka.model.Weather;
import web_reply.OpenForecast;
import web_reply.OpenLocation;

import java.util.List;

public class DatabaseMethods {

    public void insertOneLocation(OpenLocation openLocation) throws Exception {
        Location location = openLocation.getLocationObject();
        SessionFactory sessionFactory = HibernateUtils
                .getInstance()
                .getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(location);
        transaction.commit();
        session.close();
    }

    public void insertWeather(OpenForecast forecast) throws Exception {

        Weather weather = forecast.getWeatherObject();
        SessionFactory sessionFactory = HibernateUtils
                .getInstance()
                .getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(weather);
        transaction.commit();
        session.close();
    }

    public void showAllLocations() {
        LocationDao locationDao = new LocationDaoImpl();
        List<Location> locationList = locationDao.findAll();

        for(Location location : locationList) {
            System.out.println(
                    location.getCityName() + " "
                            + location.getCountry() + " "
            );
        }
    }
}
