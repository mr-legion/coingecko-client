package io.algostrategy.client.coingecko.domain.coin.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Repository urls.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReposUrl {
    private List<String> github;
    private List<Object> bitbucket;
}
