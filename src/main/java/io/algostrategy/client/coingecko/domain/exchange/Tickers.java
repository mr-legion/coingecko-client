package io.algostrategy.client.coingecko.domain.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.algostrategy.client.coingecko.domain.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Exchange tickers.
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tickers extends Page {

    @JsonProperty("name")
    private String exchangeName;

    private List<Ticker> tickers;
}
