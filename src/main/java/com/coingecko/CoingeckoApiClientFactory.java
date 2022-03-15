package com.coingecko;

import com.coingecko.impl.CoingeckoApiAsyncRestClientImpl;
import com.coingecko.impl.CoingeckoApiRestClientImpl;
import com.coingecko.impl.CoingeckoApiService;
import com.coingecko.impl.CoingeckoApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Coingecko API client objects.
 */
public class CoingeckoApiClientFactory {

    private final CoingeckoApiServiceGenerator serviceGenerator;

    public CoingeckoApiClientFactory() {
        this(new OkHttpClient());
    }

    private CoingeckoApiClientFactory(OkHttpClient client) {
        this.serviceGenerator = new CoingeckoApiServiceGenerator(client);
    }

    /**
     * New instance without authentication.
     *
     * @return the Coingecko API client factory
     */
    public static CoingeckoApiClientFactory newInstance() {
        return new CoingeckoApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public CoingeckoApiRestClient newRestClient() {
        return new CoingeckoApiRestClientImpl(serviceGenerator.createService(CoingeckoApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public CoingeckoApiAsyncRestClient newAsyncRestClient() {
        return new CoingeckoApiAsyncRestClientImpl(serviceGenerator.createService(CoingeckoApiService.class));
    }
}
