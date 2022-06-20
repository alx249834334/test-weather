package boot2.example.service.customer;

import boot2.example.model.customer.Customer;

import java.util.List;
import java.util.Optional;

/**
 * The interface Customer service.
 */
public interface ICustomerService {

    /**
     * Find by latitude list.
     *
     * @param lastName the last name
     * @return the list
     */
    public List<Customer> findByLatitude(String lastName);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Customer> findById(Long id);

    /**
     * Save customer.
     *
     * @param customerDto the customer dto
     */
    void saveCustomer(Customer customerDto);

    /**
     * Gets stored weather data by id.
     *
     * @param id the id
     * @return the stored weather data by id
     */
    public Customer getStoredWeatherDataById(Long id);
}

