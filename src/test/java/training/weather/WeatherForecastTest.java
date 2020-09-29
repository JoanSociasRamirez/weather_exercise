package training.weather;

import java.io.IOException;
import java.util.Date;

import com.google.api.client.http.javanet.NetHttpTransport;

import org.json.JSONArray;
import org.junit.Test;

import training.http.HttpClient;
import training.model.City;
import training.model.Weather;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class WeatherForecastTest {

	@Test
	public void city_weather_test() throws IOException {
		WeatherForecast weatherForecast = new WeatherForecast();
		//String forecast = weatherForecast.getCityWeather("Madrid", new Date());
		City city = new City();
		Date date = new Date();
		city.setName("Barcelona");
		Weather forecast = weatherForecast.getCityWeather(city, date);
		String climate = forecast.getClimate();
		System.out.println("Weather: " + climate);
		assertThat(forecast, instanceOf(Weather.class));
	}

	@Test
	public void check_url_city_id() throws IOException {
		HttpClient rf = HttpClient.getInstance(new NetHttpTransport());
		String rq = rf.getRequest("https://www.metaweather.com/api/location/search/?query=" + "Madrid");
		JSONArray array = new JSONArray(rq);
		System.out.println("CityId: " + array.getJSONObject(0).get("woeid"));	
		assertThat(rq, instanceOf(String.class));
	}

}
