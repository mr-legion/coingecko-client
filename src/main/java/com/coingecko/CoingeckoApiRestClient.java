package com.coingecko;

import com.coingecko.domain.coin.Coin;

import java.util.List;
import java.util.Map;

/**
 * Coingecko API facade, supporting synchronous/blocking access Coingecko's REST API.
 */
public interface CoingeckoApiRestClient {

    // Coin endpoints

    /**
     * Get the current price of any cryptocurrencies in any other supported currencies that you need.
     *
     * @param ids                  of coins, comma-separated if querying more than 1 coin
     * @param vsCurrencies         of coins, comma-separated if querying more than 1 vs_currency
     * @param includeMarketCap     to include market cap
     * @param include24hrVol       to include 24hr volume
     * @param include24hrChange    to include 24hr change
     * @param includeLastUpdatedAt to include last updated at of price
     * @return price(s) of cryptocurrency
     */
    Map<String, Map<String, Double>> getPrice(String ids,
                                              String vsCurrencies,
                                              Boolean includeMarketCap,
                                              Boolean include24hrVol,
                                              Boolean include24hrChange,
                                              Boolean includeLastUpdatedAt);

    /**
     * List all supported coins.
     *
     * @return coins
     */
    List<Coin> getCoins();

}