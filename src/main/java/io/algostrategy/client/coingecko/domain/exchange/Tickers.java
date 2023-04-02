package io.algostrategy.client.coingecko.domain.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Exchange tickers.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tickers {

    @JsonProperty("name")
    private String exchangeName;

    private List<Ticker> tickers;
}
