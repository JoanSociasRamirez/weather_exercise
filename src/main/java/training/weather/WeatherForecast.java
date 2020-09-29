package training.weather;

import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import training.http.HttpClient;
import training.model.City;
import training.model.Weather;

public class WeatherForecast {

	private Date checkDate = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 6));

	public Weather getCityWeather(City city, Date datetime) throws IOException {
		Weather weather = new Weather();
		if (datetime == null) {
			datetime = new Date();
		}
		if (datetime.before(checkDate)) {
			HttpClient rf = HttpClient.getInstance(new NetHttpTransport());
			String rq = rf.getRequest("https://www.metaweather.com/api/location/search/?query=" + city.getName());
			JSONArray array = new JSONArray(rq);
			try {
				Integer wId = null;
				wId = (Integer) array.getJSONObject(0).get("woeid");
				city.setWId(wId);
				rq = rf.getRequest("https://www.metaweather.com/api/location/" + city.getWId());
				JSONArray results = new JSONObject(rq).getJSONArray("consolidated_weather");
				for (int i = 0; i < results.length(); i++) {
					if (new SimpleDateFormat("yyyy-MM-dd").format(datetime)
							.equals(results.getJSONObject(i).get("applicable_date").toString())) {
								weather.setClimate(results.getJSONObject(i).get("weather_state_name").toString());
								return weather;
					}
				}
			} catch (Exception e) {
				throw e;
			}

		}
		return weather;
	}
}
