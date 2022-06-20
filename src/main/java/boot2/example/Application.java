package boot2.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Application.
 */
@SpringBootApplication
public class Application {

    //private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}

