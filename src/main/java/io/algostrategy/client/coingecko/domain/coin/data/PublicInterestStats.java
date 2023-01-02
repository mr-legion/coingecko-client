package io.algostrategy.client.coingecko.domain.coin.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicInterestStats {

    @JsonProperty("alexa_rank")
    private Long alexaRank;

    @JsonProperty("bing_matches")
    private Long bingMatches;

}
