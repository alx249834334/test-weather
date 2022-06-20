package boot2.example.service.weather;

import boot2.example.dto.weather.WeatherForecastDto;
import boot2.example.model.customer.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * The interface Weather service.
 */
public interface IWeatherService {

    /**
     * Gets weather data.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @param hourly    the hourly
     * @return the weather data
     * @throws JsonProcessingException the json processing exception
     */
    public List<WeatherForecastDto> getWeatherData(String latitude, String longitude, String hourly) throws JsonProcessingException;

    /**
     * Gets stored weather data by id.
     *
     * @param Id the id
     * @return the stored weather data by id
     */
    public Customer getStoredWeatherDataById(Long Id);

    /**
     * Send call.
     *
     * @param message the message
     */
    //public void sendCall(String message);
}
