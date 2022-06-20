package boot2.example.controller;

import boot2.example.dto.weather.WeatherForecastDto;
import boot2.example.model.customer.Customer;
import boot2.example.service.customer.ICustomerService;
import boot2.example.service.weather.IWeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Weather controller.
 */
@RestController
public class WeatherController {

    private final ICustomerService customerService;

    private final IWeatherService weatherService;

    private final Logger log = LoggerFactory.getLogger(WeatherController.class);

    /**
     * Instantiates a new Weather controller.
     *
     * @param customerService the customer service
     * @param weatherService  the weather service
     */
    public WeatherController(ICustomerService customerService, IWeatherService weatherService) {
        this.customerService = customerService;
        this.weatherService = weatherService;
    }

    /**
     * Handle json processing exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleJsonProcessingException(
            JsonProcessingException exception
    ) {
        log.error("Failed to parse json", exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to parse json");
    }

    /**
     * Handle exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(
            Throwable exception
    ) {
        log.error("INTERNAL_SERVER_ERROR", exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("INTERNAL_SERVER_ERROR");
    }

    /**
     * Gets weather forecast.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @param hourly    the hourly
     * @return the weather forecast
     * @throws JsonProcessingException the json processing exception
     */
    @GetMapping("/api/weather/forecast")
    public List<WeatherForecastDto> getWeatherForecast(@RequestParam(name = "latitude") String latitude, @RequestParam(name = "longitude") String longitude
            , @RequestParam(name = "hourly") String hourly) throws JsonProcessingException {
        var result = weatherService.getWeatherData(latitude, longitude, hourly);
        return result;
    }

    /**
     * Gets weather forecast stored.
     *
     * @param id the id
     * @return the weather forecast stored
     */
    @GetMapping("/api/weather/forecast/stored")
    public Customer getWeatherForecastStored(@RequestParam(name = "id") Long id) {
        var result = weatherService.getStoredWeatherDataById(id);
        return result;
    }
}

