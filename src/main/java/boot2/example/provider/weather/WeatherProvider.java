package boot2.example.provider.weather;

import boot2.example.AppProperties;
import boot2.example.client.IWebClient;
import boot2.example.provider.AbstractProvider;
import boot2.example.provider.IDataProvider;
import boot2.example.provider.ParseStrategyType;
import boot2.example.provider.ProviderType;
import boot2.example.provider.request.RequestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Weather provider.
 */
@Component
public class WeatherProvider extends AbstractProvider implements IDataProvider {

    /**
     * Instantiates a new Weather provider.
     *
     * @param appProperties the app properties
     * @param webClient     the web client
     */
    public WeatherProvider(AppProperties appProperties, IWebClient webClient) {
        super(appProperties, webClient);
    }

    @Override
    public ProviderType getProviderType() {
        return ProviderType.Weather;
    }

    @Override
    public ParseStrategyType getStrategy() {
        return ParseStrategyType.JSON;
    }

    public <T> List<T> getData(RequestModel requestModel,
                               Class<T> elementClass) throws JsonProcessingException {
        var converter = getDataConverter();
        var urlFromProperties = getUrlFromProperties();
        requestModel.setUrl(urlFromProperties);
        var providerType = getProviderType();

        var webClient = getWebClient();

        var jsonResponse = webClient.getRequest(requestModel.createRequestUrl());
        var result = converter.parse(jsonResponse, providerType, elementClass);

        return result;
    }
}

