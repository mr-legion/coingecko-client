package com.coingecko.impl;

import com.coingecko.CoingeckoApiRestClient;

import java.util.Map;

import static com.coingecko.impl.CoingeckoApiServiceGenerator.executeSync;

/**
 * Implementation of Coingecko's REST API using Retrofit with synchronous/blocking method calls.
 */
public class CoingeckoApiRestClientImpl implements CoingeckoApiRestClient {

    private final CoingeckoApiService coingeckoApiService;

    public CoingeckoApiRestClientImpl(CoingeckoApiService coingeckoApiService) {
        this.coingeckoApiService = coingeckoApiService;
    }

    // Coin endpoints

    @Override
    public Map<String, Map<String, Double>> getPrice(String ids,
                                                     String vsCurrencies,
                                                     Boolean includeMarketCap,
                                                     Boolean include24hrVol,
                                                     Boolean include24hrChange,
                                                     Boolean includeLastUpdatedAt) {
        return executeSync(coingeckoApiService.getPrice(ids, vsCurrencies,
                includeMarketCap, include24hrVol, include24hrChange, includeLastUpdatedAt));
    }
}
