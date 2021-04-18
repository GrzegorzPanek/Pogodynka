package web_reply;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import pogodynka.interaction.User;
import pogodynka.model.Location;
import pogodynka.network_queries.OpenWeatherClient;

public class OpenLocation {
    OpenWeatherClient client = new OpenWeatherClient();
    User user = new User();;

    public String getCityName() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);
        return jobj.get("name").toString();
    }

    public double getLatitude() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);
        String result = jobj.getAsJsonObject("coord").get("lat").toString();
        return Double.parseDouble(result);
    }

    public double getLongitude() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);
        String result = jobj.getAsJsonObject("coord").get("lon").toString();
        return Double.parseDouble(result);
    }

    public String getCityCountry() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);
        return jobj.getAsJsonObject("sys").get("country").toString();
    }

    public StringBuilder getCityInformation() throws Exception {
        String myJSONString = null;
        try {
            myJSONString = client.getResponseWeather(user.inputCityName());
        } catch (Exception e) {
            System.out.println("Takie miasto nie istnieje.");
        }
        JsonObject jsonObject = new Gson().fromJson(myJSONString, JsonObject.class);

        StringBuilder location = new StringBuilder("Szerokość geograficzna = " + jsonObject.getAsJsonObject("coord").get("lat").toString())
                .append("\nDługość geograficzna = " + jsonObject.getAsJsonObject("coord").get("lon").toString())
                .append("\nKraj = " + jsonObject.getAsJsonObject("sys").get("country").toString());
        return location;
    }
    public Location getLocationObject() throws Exception {
        String myJSONString = client.getResponseWeather(user.inputCityName());
        JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);
        Location location = new Location();
        location.setCityName(jobj.get("name").toString());
        location.setCountry(jobj.getAsJsonObject("sys").get("country").toString());
        location.setLongitude(Double.parseDouble(jobj.getAsJsonObject("coord").get("lon").toString()));
        location.setLatitude(Double.parseDouble(jobj.getAsJsonObject("coord").get("lat").toString()));
        return location;
    }
}

