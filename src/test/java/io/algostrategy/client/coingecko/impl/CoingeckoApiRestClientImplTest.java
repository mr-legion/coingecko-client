package io.algostrategy.client.coingecko.impl;

import io.algostrategy.client.coingecko.CoingeckoApiClientFactory;
import io.algostrategy.client.coingecko.CoingeckoApiRestClient;
import io.algostrategy.client.coingecko.domain.coin.Coin;
import io.algostrategy.client.coingecko.domain.coin.CoinFullData;
import io.algostrategy.client.coingecko.domain.exchange.Tickers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoingeckoApiRestClientImplTest {

    private final CoingeckoApiRestClient coingeckoApiRestClient =
            CoingeckoApiClientFactory.newInstance().newRestClient();

    @Test
    public void getPrice_ShouldReturnPriceForBTCvsUSD() {
        Map<String, Map<String, Double>> prices = coingeckoApiRestClient.getPrice(
                "bitcoin", "usd", null, null, null, null);
        assertTrue(prices.containsKey("bitcoin"));
        assertTrue(prices.get("bitcoin").containsKey("usd"));
    }

    @Test
    public void getCoins_ShouldReturnCoins() {
        List<Coin> coins = coingeckoApiRestClient.getCoins();
        assertThat(coins, allOf(notNullValue(), is(not(empty()))));
    }

    @Test
    public void getCoinFullData_ShouldReturnFullDataForBitcoin() {
        CoinFullData coinFullData = coingeckoApiRestClient.getCoinFullData("bitcoin", true, true, true, true, true, true);
        assertNotNull(coinFullData);
    }

    @Test
    public void getExchangeTickers_ShouldReturnExchangeTickers() {
        Tickers tickers = coingeckoApiRestClient.getExchangeTickers("binance", null, null, 5, null, null);
        assertNotNull(tickers);
    }
}