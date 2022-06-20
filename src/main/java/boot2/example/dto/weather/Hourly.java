package boot2.example.dto.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Hourly.
 */
public class Hourly {

    @JsonProperty("temperature_2m")
    private List<Double> temperature2m;

    @JsonProperty("time")
    private List<String> time;

    /**
     * Gets temperature 2 m.
     *
     * @return the temperature 2 m
     */
    public List<Double> getTemperature2m() {
        return temperature2m;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public List<String> getTime() {
        return time;
    }
}