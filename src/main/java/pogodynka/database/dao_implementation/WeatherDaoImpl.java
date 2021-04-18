package pogodynka.database.dao_implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pogodynka.database.dao.WeatherDao;
import pogodynka.database.utils.HibernateUtils;
import pogodynka.model.Location;
import pogodynka.model.Weather;

import java.util.List;

public class WeatherDaoImpl implements WeatherDao {
    @Override
    public void save(Weather weather) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();
        session.saveOrUpdate(weather);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Weather> findAll() {
        SessionFactory sessionFactory = HibernateUtils
                .getInstance()
                .getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Weather> weatherList = session
                .createQuery("from Weather", Weather.class)
                .list();

        session.getTransaction().commit();
        session.close();
        return weatherList;
    }

    @Override
    public List<Weather> findByName(Weather weather) {
        return null;
    }

    @Override
    public Weather findById(int id) {
        return null;
    }
}
