package com.coingecko.impl;

import com.coingecko.domain.coin.Coin;
import com.coingecko.domain.coin.CoinFullData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

/**
 * Coingecko's REST API URL mappings.
 */
public interface CoingeckoApiService {

    // Coin endpoints

    @GET("/api/v3/simple/price")
    Call<Map<String, Map<String, Double>>> getPrice(@Query("ids") String ids,
                                                    @Query("vs_currencies") String vsCurrencies,
                                                    @Query("include_market_cap") Boolean includeMarketCap,
                                                    @Query("include_24hr_vol") Boolean include24hrVol,
                                                    @Query("include_24hr_change") Boolean include24hrChange,
                                                    @Query("include_last_updated_at") Boolean includeLastUpdatedAt);

    @GET("/api/v3/coins/list")
    Call<List<Coin>> getCoins();

    @GET("/api/v3/coins/{id}")
    Call<CoinFullData> getCoinFullData(@Path("id") String id,
                                       @Query("localization") Boolean localization,
                                       @Query("tickers") Boolean tickers,
                                       @Query("market_data") Boolean marketData,
                                       @Query("community_data") Boolean communityData,
                                       @Query("developer_data") Boolean developerData,
                                       @Query("sparkline") Boolean sparkline);
}
