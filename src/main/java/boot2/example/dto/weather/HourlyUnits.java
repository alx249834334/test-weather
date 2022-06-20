package boot2.example.dto.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Hourly units.
 */
public class HourlyUnits {

    @JsonProperty("temperature_2m")
    private String temperature2m;

    @JsonProperty("time")
    private String time;

    /**
     * Gets temperature 2 m.
     *
     * @return the temperature 2 m
     */
    public String getTemperature2m() {
        return temperature2m;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }
}