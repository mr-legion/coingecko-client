package io.algostrategy.client.coingecko.domain.coin;

import io.algostrategy.client.coingecko.domain.coin.data.Roi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Market data.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketData {

    @JsonProperty("current_price")
    private Map<String, Double> currentPrice;

    @JsonProperty("roi")
    private Roi roi;

    @JsonProperty("ath")
    private Map<String, Double> ath;

    @JsonProperty("ath_change_percentage")
    private Map<String, Double> athChangePercentage;

    @JsonProperty("ath_date")
    private Map<String, String> athDate;

    private Map<String, Double> atl;

    @JsonProperty("atl_change_percentage")
    private Map<String, Double> atlChangePercentage;

    @JsonProperty("atl_date")
    private Map<String, String> atlDate;

    @JsonProperty("market_cap")
    private Map<String, Double> marketCap;

    @JsonProperty("market_cap_rank")
    private Long marketCapRank;

    @JsonProperty("total_volume")
    private Map<String, Double> totalVolume;

    @JsonProperty("high_24h")
    private Map<String, Double> high24h;

    @JsonProperty("low_24h")
    private Map<String, Double> low24h;

    @JsonProperty("price_change_24h")
    private Double priceChange24h;

    @JsonProperty("price_change_percentage_24h")
    private Double priceChangePercentage24h;

    @JsonProperty("price_change_percentage_7d")
    private Double priceChangePercentage7d;

    @JsonProperty("price_change_percentage_14d")
    private Double priceChangePercentage14d;

    @JsonProperty("price_change_percentage_30d")
    private Double priceChangePercentage30d;

    @JsonProperty("price_change_percentage_60d")
    private Double priceChangePercentage60d;

    @JsonProperty("price_change_percentage_200d")
    private Double priceChangePercentage200d;

    @JsonProperty("price_change_percentage_1y")
    private Double priceChangePercentage1y;

    @JsonProperty("market_cap_change_24h")
    private Double marketCapChange24h;

    @JsonProperty("market_cap_change_percentage_24h")
    private Double marketCapChangePercentage24h;

    @JsonProperty("price_change_24h_in_currency")
    private Map<String, Double> priceChange24hInCurrency;

    @JsonProperty("price_change_percentage_1h_in_currency")
    private Map<String, Double> priceChangePercentage1hInCurrency;

    @JsonProperty("price_change_percentage_24h_in_currency")
    private Map<String, Double> priceChangePercentage24hInCurrency;

    @JsonProperty("price_change_percentage_7d_in_currency")
    private Map<String, Double> priceChangePercentage7dInCurrency;

    @JsonProperty("price_change_percentage_14d_in_currency")
    private Map<String, Double> priceChangePercentage14dInCurrency;

    @JsonProperty("price_change_percentage_30d_in_currency")
    private Map<String, Double> priceChangePercentage30dInCurrency;

    @JsonProperty("price_change_percentage_60d_in_currency")
    private Map<String, Double> priceChangePercentage60dInCurrency;

    @JsonProperty("price_change_percentage_200d_in_currency")
    private Map<String, Double> priceChangePercentage200dInCurrency;

    @JsonProperty("price_change_percentage_1y_in_currency")
    private Map<String, Double> priceChangePercentage1yInCurrency;

    @JsonProperty("market_cap_change_24h_in_currency")
    private Map<String, Double> marketCapChange24hInCurrency;

    @JsonProperty("market_cap_change_percentage_24h_in_currency")
    private Map<String, Double> marketCapChangePercentage24hInCurrency;

    @JsonProperty("fully_diluted_valuation")
    private Map<String, Long> fullyDilutedValuation;

    @JsonProperty("total_value_locked")
    private Map<String, Long> totalValueLocked;

    @JsonProperty("mcap_to_tvl_ratio")
    private String mcapToTvlRatio;

    @JsonProperty("fdv_to_tvl_ratio")
    private String fdvToTvlRatio;

    @JsonProperty("total_supply")
    private Double totalSupply;

    @JsonProperty("max_supply")
    private Double maxSupply;

    @JsonProperty("circulating_supply")
    private Double circulatingSupply;

    @JsonProperty("last_updated")
    private String lastUpdated;

}