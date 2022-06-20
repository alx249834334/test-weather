package boot2.example.mapper.customer;

import boot2.example.dto.weather.WeatherForecastDto;
import boot2.example.model.customer.Customer;
import boot2.example.model.customer.CustomerRequestInfo;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Customer mapper.
 */
public abstract class CustomerMapper {

    /**
     * To customer request info dto customer request info.
     *
     * @param weatherForecastDto the weather forecast dto
     * @return the customer request info
     */
    protected CustomerRequestInfo toCustomerRequestInfoDto(WeatherForecastDto weatherForecastDto) {
        var customerRequestInfoDto = new CustomerRequestInfo();

        var source = weatherForecastDto.getHourly();

        var source_temperature = source.getTemperature2m();
        var source_time = source.getTime();

        var target = IntStream
                .range(0, source_temperature.size())
                .mapToObj(i -> source_temperature.get(i) + "," + source_time.get(i))
                .collect(Collectors.toList());

        String result = target.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("-", "{", "}"));

        customerRequestInfoDto.setContent(result);

        return customerRequestInfoDto;
    }

    /**
     * To customer dto customer.
     *
     * @param weatherForecastDtos the weather forecast dtos
     * @return the customer
     */
    public abstract Customer toCustomerDto(
            Collection<WeatherForecastDto> weatherForecastDtos);
}

