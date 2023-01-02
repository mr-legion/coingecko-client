package io.algostrategy.client.coingecko.exception;

import io.algostrategy.client.coingecko.CoingeckoApiError;

/**
 * An exception which can occur while invoking methods of the Coingecko API.
 */
public class CoingeckoApiException extends RuntimeException {

    private static final long serialVersionUID = 844923409812869225L;

    private CoingeckoApiError error;

    public CoingeckoApiException(CoingeckoApiError error) {
        this.error = error;
    }

    public CoingeckoApiException() {
        super();
    }

    public CoingeckoApiException(String message) {
        super(message);
    }

    public CoingeckoApiException(Throwable cause) {
        super(cause);
    }

    public CoingeckoApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Coingecko API,
     * or null if no response object was returned (e.g. server returned 500).
     */
    public CoingeckoApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
