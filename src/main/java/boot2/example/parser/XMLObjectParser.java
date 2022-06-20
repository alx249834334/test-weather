package boot2.example.parser;

import boot2.example.provider.ProviderType;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * The type Xml object parser.
 *
 * @param <T> the type parameter
 */
public class XMLObjectParser<T> extends AbstractObjectParser implements IDataObjectParser {
    public <T> List<T> parse(String json, ProviderType providerType, Class<T> elementClass) throws JsonProcessingException {
        //TODO: replace with not implemented exception
        return null;
    }
}