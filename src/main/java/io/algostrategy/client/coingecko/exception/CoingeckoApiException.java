package io.algostrategy.client.coingecko.exception;

import io.algostrategy.client.coingecko.CoingeckoApiError;
import lombok.AllArgsConstructor;
import lombok.experimental.StandardException;

/**
 * An exception which can occur while invoking methods of the API.
 */
@AllArgsConstructor
@StandardException
public class CoingeckoApiException extends RuntimeException {

    private CoingeckoApiError error;

    @Override
    public String getMessage() {
        return error != null ? error.getMsg() : super.getMessage();
    }
}
