package io.algostrategy.client.coingecko;

import io.algostrategy.client.coingecko.impl.CoingeckoApiAsyncRestClientImpl;
import io.algostrategy.client.coingecko.impl.CoingeckoApiRestClientImpl;
import io.algostrategy.client.coingecko.impl.CoingeckoApiService;
import io.algostrategy.client.coingecko.impl.CoingeckoApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Coingecko API client objects.
 */
public class CoingeckoApiClientFactory {

    private final CoingeckoApiServiceGenerator serviceGenerator;

    public CoingeckoApiClientFactory() {
        this(new OkHttpClient());
    }

    public CoingeckoApiClientFactory(OkHttpClient client) {
        OkHttpClient newClient = client.newBuilder()
                .addInterceptor(new PaginationInterceptor())
                .build();
        this.serviceGenerator = new CoingeckoApiServiceGenerator(newClient);
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
