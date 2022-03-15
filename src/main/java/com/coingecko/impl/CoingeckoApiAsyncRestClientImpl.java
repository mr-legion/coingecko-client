package com.coingecko.impl;

import com.coingecko.CoingeckoApiAsyncRestClient;
import com.coingecko.domain.coin.Coin;
import com.coingecko.domain.coin.CoinFullData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Coingecko's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class CoingeckoApiAsyncRestClientImpl implements CoingeckoApiAsyncRestClient {

    private final CoingeckoApiService coingeckoApiService;

    public CoingeckoApiAsyncRestClientImpl(CoingeckoApiService coingeckoApiService) {
        this.coingeckoApiService = coingeckoApiService;
    }

    // Coin endpoints

    @Override
    public CompletableFuture<Map<String, Map<String, Double>>> getPrice(String ids,
                                                                        String vsCurrencies,
                                                                        Boolean includeMarketCap,
                                                                        Boolean include24hrVol,
                                                                        Boolean include24hrChange,
                                                                        Boolean includeLastUpdatedAt) {
        CompletableFuture<Map<String, Map<String, Double>>> future = new CompletableFuture<>();
        coingeckoApiService.getPrice(ids, vsCurrencies, includeMarketCap, include24hrVol,
                include24hrChange, includeLastUpdatedAt).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<List<Coin>> getCoins() {
        CompletableFuture<List<Coin>> future = new CompletableFuture<>();
        coingeckoApiService.getCoins().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<CoinFullData> getCoinFullData(String id,
                                                           boolean localization,
                                                           boolean tickers,
                                                           boolean marketData,
                                                           boolean communityData,
                                                           boolean developerData,
                                                           boolean sparkline) {
        CompletableFuture<CoinFullData> future = new CompletableFuture<>();
        coingeckoApiService.getCoinFullData(
                id, localization, tickers, marketData, communityData, developerData, sparkline
        ).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
