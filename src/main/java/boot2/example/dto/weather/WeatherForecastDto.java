package boot2.example.dto.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Weather forecast dto.
 */
public class WeatherForecastDto {

    @JsonProperty("elevation")
    private double elevation;

    @JsonProperty("hourly_units")
    private HourlyUnits hourlyUnits;

    @JsonProperty("generationtime_ms")
    private double generationtimeMs;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("utc_offset_seconds")
    private int utcOffsetSeconds;

    @JsonProperty("hourly")
    private Hourly hourly;

    @JsonProperty("longitude")
    private double longitude;

    /**
     * Gets elevation.
     *
     * @return the elevation
     */
    public double getElevation() {
        return elevation;
    }

    /**
     * Gets hourly units.
     *
     * @return the hourly units
     */
    public HourlyUnits getHourlyUnits() {
        return hourlyUnits;
    }

    /**
     * Gets generationtime ms.
     *
     * @return the generationtime ms
     */
    public double getGenerationtimeMs() {
        return generationtimeMs;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Gets utc offset seconds.
     *
     * @return the utc offset seconds
     */
    public int getUtcOffsetSeconds() {
        return utcOffsetSeconds;
    }

    /**
     * Gets hourly.
     *
     * @return the hourly
     */
    public Hourly getHourly() {
        return hourly;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }
}