package com.coingecko.impl;

import com.coingecko.CoingeckoApiAsyncRestClient;
import com.coingecko.CoingeckoApiClientFactory;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

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
}