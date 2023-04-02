package io.algostrategy.client.coingecko.domain.exchange;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

import static io.algostrategy.client.coingecko.constant.CoingeckoApiConstants.ZONED_DATE_FORMAT;

/**
 * An ticker.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {

    @JsonProperty("coin_id")
    private String baseCoinId;
    @JsonProperty("base")
    private String baseCoinSymbol;

    @JsonProperty("target_coin_id")
    private String quoteCoinId;
    @JsonProperty("target")
    private String quoteCoinSymbol;

    @JsonProperty("market")
    private Exchange exchange;

    private Double last;
    private Double volume;
    @JsonProperty("bid_ask_spread_percentage")
    private Double bidAskSpreadPercentage;

    @JsonProperty("converted_last")
    private Map<String, Double> convertedLast;

    @JsonProperty("converted_volume")
    private Map<String, Double> convertedVolume;

    @JsonProperty("trust_score")
    private String trustScore;

    @JsonProperty("trade_url")
    private String tradeUrl;

    @JsonProperty("is_anomaly")
    private Boolean anomaly;
    @JsonProperty("is_stale")
    private Boolean stale;
    @JsonProperty("token_info_url")
    private String tokenInfoUrl;

    @JsonFormat(pattern = ZONED_DATE_FORMAT)
    @JsonProperty("timestamp")
    private Date date;

    @JsonFormat(pattern = ZONED_DATE_FORMAT)
    @JsonProperty("last_traded_at")
    private Date lastTradedAt;

    @JsonFormat(pattern = ZONED_DATE_FORMAT)
    @JsonProperty("last_fetch_at")
    private Date lastFetchAt;
}
