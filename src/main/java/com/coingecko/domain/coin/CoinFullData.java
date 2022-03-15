package com.coingecko.domain.coin;

import com.coingecko.domain.coin.data.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Full coin information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinFullData {

    private String id;

    private String symbol;
    private String name;

    @JsonProperty("asset_platform_id")
    private String assetPlatformId;
    private Map<String, String> platforms;

    @JsonProperty("block_time_in_minutes")
    private long blockTimeInMinutes;

    @JsonProperty("hashing_algorithm")
    private String hashingAlgorithm;

    private List<String> categories;

    @JsonProperty("public_notice")
    private String publicNotice;

    @JsonProperty("additional_notices")
    List<String> additionalNotices;

    private Map<String, String> localization;
    private Map<String, String> description;

    private Links links;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("country_origin")
    private String countryOrigin;

    @JsonProperty("genesis_date")
    private String genesisDate;

    @JsonProperty("sentiment_votes_up_percentage")
    private double sentimentVotesUpPercentage;

    @JsonProperty("sentiment_votes_down_percentage")
    private double sentimentVotesDownPercentage;

    @JsonProperty("contract_address")
    private String contractAddress;

    @JsonProperty("ico_data")
    private IcoData icoData;

    @JsonProperty("market_cap_rank")
    private long marketCapRank;

    @JsonProperty("coingecko_rank")
    private long coingeckoRank;

    @JsonProperty("coingecko_score")
    private double coingeckoScore;

    @JsonProperty("developer_score")
    private double developerScore;

    @JsonProperty("community_score")
    private double communityScore;

    @JsonProperty("liquidity_score")
    private double liquidityScore;

    @JsonProperty("public_interest_score")
    private double publicInterestScore;

    @JsonProperty("market_data")
    private MarketData marketData;

    @JsonProperty("community_data")
    private CommunityData communityData;

    @JsonProperty("developer_data")
    private DeveloperData developerData;

    @JsonProperty("public_interest_stats")
    private PublicInterestStats publicInterestStats;

    @JsonProperty("status_updates")
    private List<Object> statusUpdates;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("tickers")
    private List<Ticker> tickers;

}
