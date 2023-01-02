package io.algostrategy.client.coingecko.domain.coin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An coin.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {
    private String id;
    private String symbol;
    private String name;
}
