import pogodynka.interaction.DatabaseMethods;
import pogodynka.interaction.User;
import web_reply.OpenForecast;
import web_reply.OpenLocation;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) throws Exception {

        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); //or whatever level you need


        OpenLocation openLocation = new OpenLocation();
        OpenForecast forecast = new OpenForecast();
        DatabaseMethods methods = new DatabaseMethods();
        User user = new User();

        System.out.println("Witamy w aplikacji POGODYNKA, programie do wyświetlania pogody.");
        System.out.println("===============================================================");

        int selected = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            user.log("[1] Zapisz lokacje");
            user.log("[2] Wyświetl pogode dla lokacji");
            user.log("[3] Wyświetl dane lokacji");
            user.log("[4] Wyświetl wszystkie zapisane miasta.");
            user.log("[5] Zamknij aplikację.");
            grubaKrecha();

                try {
                    selected = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Wprowadzono niepoprawny format danych.\nAplikacja zostanie zamknięta");
                    System.exit(0);
                }

            if (selected == 0 || selected == 1 || selected == 2 || selected == 3 || selected == 4 || selected == 5) {
                switch (selected) {
                    case 1:
                        try {
                            methods.insertOneLocation(openLocation);
                        } catch (Exception e) {
                            System.out.println("Wprowadzono niepoprawne dane lub miasto już zostało zapisane w bazie danych.");
                        }
                        grubaKrecha();
                        break;
                    case 2:
                        try {

                            System.out.println(forecast.getForecast());
                        } catch (Exception e) {
                            System.out.println("Takie miasto nie istnieje!");
                        }
                        grubaKrecha();
                        break;
                    case 3:
                        System.out.println(openLocation.getCityInformation());
                        try {
                            grubaKrecha();
                            break;
                        } catch (Exception e) {
                            System.out.println("Takie miasto nie istnieje!");
                        }
                    case 4:
                        grubaKrecha();
                        methods.showAllLocations();
                        grubaKrecha();
                        break;
                    case 5:
                        System.out.println("Do zobaczenia!");
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("Wprowadziles niepoprawne dane.");
                System.out.println("Wybierz opcję dostępna w menu aplikacji.");
            }
        } while (selected != 0);
    }
    public static void grubaKrecha() {
        System.out.println("===============================================================");
    }
}
