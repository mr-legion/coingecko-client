package io.algostrategy.client.coingecko.impl;

import io.algostrategy.client.coingecko.CoingeckoApiAsyncRestClient;
import io.algostrategy.client.coingecko.CoingeckoApiClientFactory;
import io.algostrategy.client.coingecko.domain.coin.Coin;
import io.algostrategy.client.coingecko.domain.coin.CoinFullData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoingeckoApiAsyncRestClientImplTest {

    private final CoingeckoApiAsyncRestClient coingeckoApiAsyncRestClient =
            CoingeckoApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getPrice_ShouldReturnPriceForBTCvsUSD() throws ExecutionException, InterruptedException {
        Map<String, Map<String, Double>> prices = coingeckoApiAsyncRestClient.getPrice(
                "bitcoin", "usd", null, null, null, null).get();
        assertTrue(prices.containsKey("bitcoin"));
        assertTrue(prices.get("bitcoin").containsKey("usd"));
    }

    @Test
    public void getCoins_ShouldReturnCoins() throws ExecutionException, InterruptedException {
        List<Coin> coins = coingeckoApiAsyncRestClient.getCoins().get();
        assertThat(coins, allOf(notNullValue(), is(not(empty()))));
    }

    @Test
    public void getCoinFullData_ShouldReturnFullDataForBitcoin() throws ExecutionException, InterruptedException {
        CoinFullData coinFullData = coingeckoApiAsyncRestClient.getCoinFullData(
                "bitcoin", true, true, true, true, true, true
        ).get();
        assertNotNull(coinFullData);
    }
}