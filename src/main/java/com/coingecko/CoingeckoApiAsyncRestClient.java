package com.coingecko;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Coingecko API facade, supporting asynchronous/non-blocking access Coingecko's REST API.
 */
public interface CoingeckoApiAsyncRestClient {

    // Coin endpoints

    /**
     * Get the current price of any cryptocurrencies
     * in any other supported currencies that you need (asynchronous).
     *
     * @param ids                  of coins, comma-separated if querying more than 1 coin
     * @param vsCurrencies         of coins, comma-separated if querying more than 1 vs_currency
     * @param includeMarketCap     to include market cap
     * @param include24hrVol       to include 24hr volume
     * @param include24hrChange    to include 24hr change
     * @param includeLastUpdatedAt to include last updated at of price
     * @return price(s) of cryptocurrency
     */
    CompletableFuture<Map<String, Map<String, Double>>> getPrice(String ids,
                                                                 String vsCurrencies,
                                                                 Boolean includeMarketCap,
                                                                 Boolean include24hrVol,
                                                                 Boolean include24hrChange,
                                                                 Boolean includeLastUpdatedAt);
}