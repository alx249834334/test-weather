package boot2.example.provider;

import boot2.example.AppProperties;
import boot2.example.client.IWebClient;
import boot2.example.parser.IDataObjectParser;
import boot2.example.parser.JsonObjectParser;
import boot2.example.parser.XMLObjectParser;


/**
 * The type Abstract provider.
 */
public abstract class AbstractProvider {

    private final String url;

    /**
     * Gets web client.
     *
     * @return the web client
     */
    protected IWebClient getWebClient() {
        return webClient;
    }

    private final IWebClient webClient;

    /**
     * Instantiates a new Abstract provider.
     *
     * @param appProperties the app properties
     * @param webClient     the web client
     */
    public AbstractProvider(AppProperties appProperties, IWebClient webClient) {
        this.url = appProperties.getUrl();
        this.webClient = webClient;
    }

    /**
     * Gets provider type.
     *
     * @return the provider type
     */
    public abstract ProviderType getProviderType();

    /**
     * Gets strategy.
     *
     * @return the strategy
     */
    public abstract ParseStrategyType getStrategy();

    /**
     * Gets url from properties.
     *
     * @return the url from properties
     */
    protected String getUrlFromProperties() {
        return url;
    }

    /**
     * Gets data converter.
     *
     * @return the data converter
     */
    protected IDataObjectParser getDataConverter() {
        var strategy = getStrategy();
        switch (strategy) {
            case JSON:
                return new JsonObjectParser();
            case XML:
                return new XMLObjectParser();
        }
        return null;
    }
}

