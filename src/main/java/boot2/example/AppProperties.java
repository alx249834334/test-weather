package boot2.example;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The type App properties.
 */
@Configuration
@ConfigurationProperties(prefix = "weather")
public class AppProperties {

    /**
     * Gets test.
     *
     * @return the test
     */
    public String getTest() {
        return test;
    }

    /**
     * Sets test.
     *
     * @param test the test
     */
    public void setTest(String test) {
        this.test = test;
    }

    private String test;

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

}
