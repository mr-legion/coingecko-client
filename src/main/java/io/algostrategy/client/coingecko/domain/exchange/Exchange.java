package io.algostrategy.client.coingecko.domain.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An exchange.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Exchange {

    @JsonProperty("identifier")
    private String id;

    private String name;

    @JsonProperty("has_trading_incentive")
    private Boolean hasTradingIncentive;
}
