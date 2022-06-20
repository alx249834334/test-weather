package boot2.example.provider;

import boot2.example.provider.request.RequestModel;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * The interface Data provider.
 */
public interface IDataProvider {

    /**
     * Gets data.
     *
     * @param <T>          the type parameter
     * @param RequestModel the request model
     * @param elementClass the element class
     * @return the data
     * @throws JsonProcessingException the json processing exception
     */
    public <T> List<T> getData(RequestModel RequestModel, Class<T> elementClass) throws JsonProcessingException;

}
