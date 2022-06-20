package boot2.example.provider.request.weather;

import boot2.example.provider.request.RequestModel;

/**
 * The type Weather request model.
 */
public class WeatherRequestModel extends RequestModel {

    private final String latitude;

    private final String longitude;

    private final String hourly;

    /**
     * Instantiates a new Weather request model.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @param hourly    the hourly
     */
    public WeatherRequestModel(String latitude, String longitude, String hourly) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.hourly = hourly;
    }

    private String generateQueryPath() {
        var generateQueryPath = "latitude=" + latitude + "&longitude=" + longitude + "&hourly=" + hourly;
        return generateQueryPath;
    }

    public String createRequestUrl() {
        var requestUrl = getUrl() + "?" + generateQueryPath();
        return requestUrl;
    }
}
