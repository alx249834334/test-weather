package boot2.example.parser;

import boot2.example.provider.ProviderType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Json object parser.
 */
public class JsonObjectParser extends AbstractObjectParser implements IDataObjectParser {

    private <T> List<T> getDataList(String json, Class<T> elementClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var item = objectMapper.readValue(json, elementClass);
        var result = new ArrayList<T>();
        result.add(item);
        return result;
    }

    public <T> List<T> parse(String json, ProviderType providerType, Class<T> elementClass) throws JsonProcessingException {

        switch (providerType) {
            case Weather -> {
                return getDataList(json, elementClass);
            }
        }

        return null;
    }

}