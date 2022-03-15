package com.coingecko.impl;

import com.coingecko.CoingeckoApiClientFactory;
import com.coingecko.CoingeckoApiRestClient;
import com.coingecko.domain.coin.Coin;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

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
}