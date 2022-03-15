package com.coingecko.impl;

import com.coingecko.CoingeckoApiAsyncRestClient;
import com.coingecko.CoingeckoApiClientFactory;
import com.coingecko.domain.coin.Coin;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
}