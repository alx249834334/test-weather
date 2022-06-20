package boot2.example.service.customer;


import boot2.example.model.customer.Customer;
import boot2.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * The type Customer service.
 */
@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository repository;

    /**
     * Instantiates a new Customer service.
     *
     * @param repository the repository
     */
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findByLatitude(String lastName) {
        var result = repository.findByLatitude(lastName);
        return result;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        var result = repository.findById(id);
        return result;
    }

    @Override
    public void saveCustomer(Customer customerDto) {
        repository.save(customerDto);
    }

    @Override
    @Transactional
    public Customer getStoredWeatherDataById(Long id) {
        var preResult = repository.findById(id);
        if (preResult.isPresent()) {
            //preResult.get().getPages();//no session to get lazy
            preResult.get().getPages().size();// init lazy
        }
        var result = preResult.orElse(null);
        return result;
    }
}



