package boot2.example.repository;

import boot2.example.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Customer repository.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    /**
     * Find by latitude list.
     *
     * @param latitude the latitude
     * @return the list
     */
    List<Customer> findByLatitude(String latitude);

    Optional<Customer> findById(Long id);

}
