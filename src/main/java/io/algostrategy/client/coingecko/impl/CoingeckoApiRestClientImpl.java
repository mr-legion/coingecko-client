package io.algostrategy.client.coingecko.impl;

import io.algostrategy.client.coingecko.CoingeckoApiRestClient;
import io.algostrategy.client.coingecko.domain.coin.Coin;
import io.algostrategy.client.coingecko.domain.coin.CoinFullData;
import io.algostrategy.client.coingecko.domain.exchange.Tickers;
import okhttp3.OkHttpClient;

import java.util.List;
import java.util.Map;

import static io.algostrategy.client.coingecko.impl.CoingeckoApiServiceGenerator.createService;

/**
 * Implementation of REST API using Retrofit with synchronous/blocking method calls.
 */
public class CoingeckoApiRestClientImpl implements CoingeckoApiRestClient {

    private final CoingeckoApiService coingeckoApiService;

    public CoingeckoApiRestClientImpl() {
        this.coingeckoApiService = createService(CoingeckoApiService.class);
    }

    public CoingeckoApiRestClientImpl(OkHttpClient client) {
        this.coingeckoApiService = createService(client, CoingeckoApiService.class);
    }

    // Coin endpoints

    @Override
    public Map<String, Map<String, Double>> getPrice(String ids,
                                                     String vsCurrencies,
                                                     Boolean includeMarketCap,
                                                     Boolean include24hrVol,
                                                     Boolean include24hrChange,
                                                     Boolean includeLastUpdatedAt) {
        return CoingeckoApiServiceGenerator.executeSync(coingeckoApiService.getPrice(ids, vsCurrencies,
                includeMarketCap, include24hrVol, include24hrChange, includeLastUpdatedAt));
    }

    @Override
    public List<Coin> getCoins() {
        return CoingeckoApiServiceGenerator.executeSync(coingeckoApiService.getCoins());
    }

    @Override
    public CoinFullData getCoinFullData(String id,
                                        boolean localization,
                                        boolean tickers,
                                        boolean marketData,
                                        boolean communityData,
                                        boolean developerData,
                                        boolean sparkline) {
        return CoingeckoApiServiceGenerator.executeSync(coingeckoApiService.getCoinFullData(
                id, localization, tickers, marketData, communityData, developerData, sparkline
        ));
    }

    // Exchange endpoints

    @Override
    public Tickers getExchangeTickers(String exchange,
                                      String[] coins,
                                      Boolean includeExchangeLogo,
                                      Integer page,
                                      Boolean depthInclude,
                                      String order) {
        return CoingeckoApiServiceGenerator.executeSync(coingeckoApiService.getExchangeTickers(
                exchange, coins, includeExchangeLogo, page, depthInclude, order
        ));
    }
}
