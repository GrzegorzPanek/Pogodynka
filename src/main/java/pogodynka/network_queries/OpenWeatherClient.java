package pogodynka.network_queries;


import pogodynka.file_reader.FileReader;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpenWeatherClient {

    String upId = new FileReader().readKeyFromFile();

    public URI openWeatherUri(String query) throws Exception {
        String https ="";
        final  URI OPEN_WEATHER =
                URI.create(new StringBuilder(https)
                        .append("https://api.openweathermap.org/data/2.5/weather?q=")
                        .append( query)
                        .append("&appid=")
                        .append(upId)
                        .append("&units=metric")
                        .toString());
        return OPEN_WEATHER;
    }
    public String getResponseWeather(String query) throws Exception {

        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(openWeatherUri(query))
                .GET()
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
