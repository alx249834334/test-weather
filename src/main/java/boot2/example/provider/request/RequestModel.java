package boot2.example.provider.request;

/**
 * The enum Http method.
 */
enum HTTP_METHOD {
    /**
     * Get http method.
     */
    GET,
    /**
     * Post http method.
     */
    POST,
    /**
     * Put http method.
     */
    PUT,
    /**
     * Patch http method.
     */
    PATCH,
    /**
     * Delete http method.
     */
    DELETE
}

/**
 * The type Request model.
 */
public abstract class RequestModel {

    /**
     * Gets method type.
     *
     * @return the method type
     */
    public HTTP_METHOD getMethodType() {
        return HTTP_METHOD.GET;
    }

    /**
     * Create request url string.
     *
     * @return the string
     */
    public abstract String createRequestUrl();

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
