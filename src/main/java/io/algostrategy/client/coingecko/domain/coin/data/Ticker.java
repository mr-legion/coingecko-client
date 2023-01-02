package io.algostrategy.client.coingecko.domain.coin.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {

    private String base;

    private String target;

    private Market market;

    private Double last;

    private Double volume;

    @JsonProperty("converted_last")
    private Map<String, String> convertedLast;

    @JsonProperty("converted_volume")
    private Map<String, String> convertedVolume;

    @JsonProperty("trust_score")
    private String trustScore;

    @JsonProperty("bid_ask_spread_percentage")
    private Double bidAskSpreadPercentage;

    private String timestamp;

    @JsonProperty("last_traded_at")
    private String lastTradedAt;

    @JsonProperty("last_fetch_at")
    private String lastFetchAt;

    @JsonProperty("is_anomaly")
    private Boolean isAnomaly;

    @JsonProperty("is_stale")
    private Boolean isStale;

    @JsonProperty("trade_url")
    private String tradeUrl;

    @JsonProperty("coin_id")
    private String coinId;

}
