import pogodynka.interaction.DatabaseMethods;
import pogodynka.interaction.User;
import pogodynka.model.Location;
import web_reply.OpenForecast;
import web_reply.OpenLocation;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

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

            selected = scanner.nextInt();
            if (selected == 0 || selected == 1 || selected == 2 || selected == 3 || selected == 4 || selected == 5) {
                switch (selected) {
                    case 1:
                        try {
                            methods.insertOneLocation(openLocation);
                        } catch (Exception e) {
                            System.out.println("To miasto już zostało zapisane w bazie danych.");
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
