package com.coingecko.impl;

import com.coingecko.CoingeckoApiRestClient;
import com.coingecko.domain.coin.Coin;
import com.coingecko.domain.coin.CoinFullData;

import java.util.List;
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

    @Override
    public List<Coin> getCoins() {
        return executeSync(coingeckoApiService.getCoins());
    }

    @Override
    public CoinFullData getCoinFullData(String id,
                                        boolean localization,
                                        boolean tickers,
                                        boolean marketData,
                                        boolean communityData,
                                        boolean developerData,
                                        boolean sparkline) {
        return executeSync(coingeckoApiService.getCoinFullData(
                id, localization, tickers, marketData, communityData, developerData, sparkline
        ));
    }
}
