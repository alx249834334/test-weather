package boot2.example.parser;

import boot2.example.provider.ProviderType;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * The interface Data object parser.
 */
public interface IDataObjectParser {
    /**
     * Parse list.
     *
     * @param <T>          the type parameter
     * @param json         the json
     * @param providerType the provider type
     * @param elementClass the element class
     * @return the list
     * @throws JsonProcessingException the json processing exception
     */
    public <T> List<T> parse(String json, ProviderType providerType, Class<T> elementClass) throws JsonProcessingException;
}
