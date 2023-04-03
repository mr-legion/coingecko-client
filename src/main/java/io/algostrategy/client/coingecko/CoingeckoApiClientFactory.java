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
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new PaginationInterceptor())
                .build();
        this.serviceGenerator = new CoingeckoApiServiceGenerator(okHttpClient);
    }

    public CoingeckoApiClientFactory(ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiInteractionConfig);
    }

    public CoingeckoApiClientFactory(OkHttpClient client, ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                ))
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
