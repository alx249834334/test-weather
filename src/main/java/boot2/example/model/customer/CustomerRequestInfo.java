package boot2.example.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Customer request info.
 */
@Entity
@Table(name = "requst_info")
public class CustomerRequestInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Gets number.
     *
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number the number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    private int number;
    @Column(name = "content")
    @Lob
    private String content;

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customer;

    /**
     * Instantiates a new Customer request info.
     */
    public CustomerRequestInfo() {
    }

    /**
     * Instantiates a new Customer request info.
     *
     * @param number   the number
     * @param content  the content
     * @param chapter  the chapter
     * @param customer the customer
     */
    public CustomerRequestInfo(int number, String content, String chapter, Customer customer) {
        this.number = number;
        this.content = content;
        this.customer = customer;
    }
}
