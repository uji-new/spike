package app.service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.jcabi.aspects.Cacheable;

import org.springframework.stereotype.Service;

import io.restassured.RestAssured;
import io.restassured.internal.http.Status;

@Service
public class WeatherService {
    final static protected String URI = "https://api.openweathermap.org/data/2.5/onecall";
    final static protected String KEY = "839a382b8be4b70bc2d3eb6279b3c367";

    @Cacheable(lifetime = 30, unit = TimeUnit.MINUTES)
    public Object getData() {
        var baseRequest = RestAssured.given().baseUri(URI).queryParam("appid", KEY).queryParam("lang", "es");
        var request = baseRequest.queryParam("lat", 39.9875).queryParam("lon", 39.9875);
        var response = request.when().get().then().extract();

        if (Status.SUCCESS.matches(response.statusCode())) {
            var data = response.jsonPath();
            return Map.of("temp", data.getFloat("current.temp"));
        } else {
            return Map.of();
        }
    }
}
