package pogodynka.database.dao_implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pogodynka.database.dao.LocationDao;
import pogodynka.database.utils.HibernateUtils;
import pogodynka.model.Location;

import java.time.LocalDate;
import java.util.List;

public class LocationDaoImpl implements LocationDao {

    @Override
    public void save(Location location) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();
        session.saveOrUpdate(location);
        session.getTransaction().commit();
        session.close();
    }


    public List<Location> findByName(String name) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<Location> runMemberList = session
                .createQuery("from RunMember where name like :name", Location.class)
                .setParameter("name", name)
                .list();

        session.getTransaction().commit();
        session.close();
        return runMemberList;
    }

    @Override
    public List<Location> findAll() {
            SessionFactory sessionFactory = HibernateUtils
                    .getInstance()
                    .getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Location> locationList = session
                    .createQuery("from Location", Location.class)
                    .list();

            session.getTransaction().commit();
            session.close();
            return locationList;
    }

    @Override
    public Location findByLongitude(double longitude) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        Location location = session
                .createQuery("from NfcTag where longitude=:longitude", Location.class)
                .setParameter("long", longitude)
                .uniqueResult();

        session.getTransaction().commit();
        session.close();

        return location;
    }

    @Override
    public Location findByLatitude(double latitude) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        Location location = session
                .createQuery("from NfcTag where latitude=:latitude", Location.class)
                .setParameter("long", latitude)
                .uniqueResult();

        session.getTransaction().commit();
        session.close();

        return location;
    }
}
