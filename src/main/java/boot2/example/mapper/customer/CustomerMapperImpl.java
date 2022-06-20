package boot2.example.mapper.customer;

import boot2.example.dto.weather.WeatherForecastDto;
import boot2.example.model.customer.Customer;

import java.util.Collection;

/**
 * The type Customer mapper.
 */
public class CustomerMapperImpl extends CustomerMapper {

    @Override
    public Customer toCustomerDto(Collection<WeatherForecastDto> weatherForecastDtos) {
        if (weatherForecastDtos == null) {
            return null;
        }

        var customerDto = new Customer();
        int idx = 0;
        for (WeatherForecastDto weatherForecastDto : weatherForecastDtos) {
            var customerRequestInfoDto = toCustomerRequestInfoDto(weatherForecastDto);
            customerRequestInfoDto.setNumber(idx);
            customerDto.addItem(customerRequestInfoDto);
        }

        return customerDto;
    }
}
