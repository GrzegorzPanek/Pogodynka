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

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);

    public int inputIdOfCity() {
        System.out.println("Wpisz id miasta: ");
        return input.nextInt();
    }

    public String inputCityName() {
        System.out.println("Podaj nazwe miasta : ");
        return input.nextLine();
    }

    public String inputCountry() {
        System.out.println("Podaj kraj: ");
        return input.nextLine();
    }

    public double inputLongitude() {
        System.out.println("Wpisz długość: ");
        return input.nextDouble();
    }

    public double inputLatitude() {
        System.out.println("Wpisz szerokość: ");
        return input.nextDouble();
    }

    public void log(String text) {
        System.out.println(text);
    }

    public void ShowAllRuns() {
        LocationDao locationDao = new LocationDaoImpl();
        List<Location> list = locationDao.findAll();

        System.out.println("Lista miast.");
        System.out.println("--------------------------");
        for (Location location : list) {
            System.out.println(
                    location.getId() + " " +
                            location.getCityName() + " " +
                            location.getCountry());
        }
    }
}
