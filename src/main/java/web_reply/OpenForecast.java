package web_reply;

import pogodynka.interaction.User;
import pogodynka.model.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import pogodynka.network_queries.OpenWeatherClient;

public class OpenForecast {

  OpenWeatherClient client = new OpenWeatherClient();
  User user = new User();

    public Double getPressure() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jsonObject = new Gson().fromJson(myJSONString, JsonObject.class);
        return Double.parseDouble(jsonObject.getAsJsonObject("main").get("pressure").toString());
    }

    public double getTemperature() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jsonObject = new Gson().fromJson(myJSONString, JsonObject.class);
        String result = jsonObject.getAsJsonObject("main").get("temp").toString();
        return Double.parseDouble(result);
    }

    public double getHumidity() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jsonObject = new Gson().fromJson(myJSONString, JsonObject.class);
        String result = jsonObject.getAsJsonObject("main").get("humidity").toString();
        return Double.parseDouble(result);
    }

    public double getWindSpeed() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jsonObject = new Gson().fromJson(myJSONString, JsonObject.class);
        String result = jsonObject.getAsJsonObject("wind").get("speed").toString();
        return Double.parseDouble(result);
    }

    public double getCloudsInfo() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jsonObject = new Gson().fromJson(myJSONString, JsonObject.class);
        String result = jsonObject.getAsJsonObject("clouds").get("all").toString();
        return Double.parseDouble(result);
    }

    public StringBuilder getForecast() throws Exception {
            String myJSONString = client.getResponseWeather(user.inputCityName());
            JsonObject jsonObject = new Gson().fromJson(myJSONString, JsonObject.class);

            StringBuilder forecast = new StringBuilder("Temperatura = " + jsonObject.getAsJsonObject("main").get("temp").toString() + "°C")
                    .append("\nCiśnienie = " + jsonObject.getAsJsonObject("main").get("pressure").toString() + " Mpa")
                    .append("\nWiatr = " + jsonObject.getAsJsonObject("wind").get("speed").toString() + " Km/h")
                    .append("\nPrzejrzystość = " + jsonObject.getAsJsonObject("clouds").get("all").toString() + "%")
                    .append("\nWilgotność = " + jsonObject.getAsJsonObject("main").get("humidity").toString() + "%");
            return forecast;
    }

    public Weather getWeatherObject() throws Exception {
        Weather weather = new Weather();
        weather.setTemperature(getTemperature());
        weather.setClouds(getCloudsInfo());
        weather.setHumidity(getHumidity());
        weather.setPressure(getPressure());
        weather.setTemperature(getTemperature());
        return weather;
    }
}

