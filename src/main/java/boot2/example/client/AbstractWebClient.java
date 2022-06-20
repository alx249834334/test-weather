package boot2.example.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;


/**
 * The type Abstract web client.
 */
public abstract class AbstractWebClient implements IWebClient {

    public String getRequest(String url) {

        var client = getClient(url);

        var result = client.get().accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return result;
    }

    private WebClient getClient(String url) {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(url);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);

        WebClient client = WebClient.builder().uriBuilderFactory(factory)
                .build();
        return client;
    }


}

