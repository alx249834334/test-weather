package boot2.example.model.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Customer.
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String latitude;
    private String longitude;
    private String hourly;

    /**
     * Instantiates a new Customer.
     *
     * @param latitude            the latitude
     * @param longitude           the longitude
     * @param hourly              the hourly
     * @param customerRequestInfo the customer request info
     */
    public Customer(String latitude, String longitude, String hourly, Set<CustomerRequestInfo> customerRequestInfo) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.hourly = hourly;
        this.customerRequestInfo = customerRequestInfo;
    }

    /**
     * Gets hourly.
     *
     * @return the hourly
     */
    public String getHourly() {
        return hourly;
    }

    /**
     * Sets hourly.
     *
     * @param hourly the hourly
     */
    public void setHourly(String hourly) {
        this.hourly = hourly;
    }

    /**
     * Instantiates a new Customer.
     */
    public Customer() {
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, latitude, longitude);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return latitude;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return longitude;
    }

    /**
     * Gets pages.
     *
     * @return the pages
     */
    public Set<CustomerRequestInfo> getPages() {
        return customerRequestInfo;
    }

    /**
     * Sets pages.
     *
     * @param customerRequestInfos the customer request infos
     */
    public void setPages(Set<CustomerRequestInfo> customerRequestInfos) {
        this.customerRequestInfo = customerRequestInfos;
    }

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<CustomerRequestInfo> customerRequestInfo = new HashSet<>();

    /**
     * Add item.
     *
     * @param customerRequestInfo the customer request info
     */
    public void addItem(CustomerRequestInfo customerRequestInfo) {
        this.customerRequestInfo.add(customerRequestInfo);
        customerRequestInfo.setCustomer(this);
    }
}