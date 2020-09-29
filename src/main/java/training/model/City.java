package training.model;

public class City {

	private String name;
	private Integer wId;
	private Weather weather;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWId() {
		return wId;
	}

	public void setWId(Integer wId) {
		this.wId = wId;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}
}