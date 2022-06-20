package boot2.example.service.weather;

import boot2.example.AppProperties;
import boot2.example.dto.weather.WeatherForecastDto;
import boot2.example.kafka.IKafkaMessageProducer;
import boot2.example.mapper.customer.CustomerMapperImpl;
import boot2.example.model.customer.Customer;
import boot2.example.provider.IDataProvider;
import boot2.example.provider.request.weather.WeatherRequestModel;
import boot2.example.service.customer.ICustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Weather service.
 */
@Service
public class WeatherService implements IWeatherService {

    private final AppProperties appProperties;

    //TODO: change to interface without generic
    private final IDataProvider weatherProvide;

    private final ICustomerService customerService;

    private final IKafkaMessageProducer kafkaMessageProducer;

    /**
     * Instantiates a new Weather service.
     *
     * @param appProperties        the app properties
     * @param weatherProvider      the weather provider
     * @param customerService      the customer service
     * @param kafkaMessageProducer the kafka message producer
     */
    public WeatherService(AppProperties appProperties,
                          IDataProvider weatherProvider,
                          ICustomerService customerService, IKafkaMessageProducer kafkaMessageProducer) {
        this.appProperties = appProperties;
        this.weatherProvide = weatherProvider;
        this.customerService = customerService;
        this.kafkaMessageProducer = kafkaMessageProducer;
    }


    @Override
    public List<WeatherForecastDto> getWeatherData(String latitude, String longitude, String hourly) throws JsonProcessingException {
        var weatherRequestModel = new WeatherRequestModel(latitude, longitude, hourly);
        var result = weatherProvide.<WeatherForecastDto>getData(weatherRequestModel, WeatherForecastDto.class);
        //TODO: move to static? converter
        Customer customerDto = getCustomer(result);
        /*TODOEND*/
        customerService.saveCustomer(customerDto);

        return result;
    }

    private Customer getCustomer(List<WeatherForecastDto> result) {
        var customerMapperImpl = new CustomerMapperImpl();
        var customerDto = customerMapperImpl.toCustomerDto(result);
        return customerDto;
    }

    @Override
    public Customer getStoredWeatherDataById(Long id) {
        var x = customerService.getStoredWeatherDataById(id);
        return x;
    }

    @Override

    //TODO: class for Kafka send message, get, convert
    public void sendCall(String message) {

        kafkaMessageProducer.sendMessage(message);
    }
}
