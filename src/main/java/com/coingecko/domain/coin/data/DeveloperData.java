package com.coingecko.domain.coin.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Developer data
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeveloperData {

    private long forks;

    private long stars;

    private long subscribers;
    @JsonProperty("total_issues")

    private long totalIssues;
    @JsonProperty("closed_issues")

    private long closedIssues;

    @JsonProperty("pull_requests_merged")
    private long pullRequestsMerged;

    @JsonProperty("pull_request_contributors")
    private long pullRequestContributors;

    @JsonProperty("code_additions_deletions_4_weeks")
    private CodeAdditionsDeletions4Weeks codeAdditionsDeletions4Weeks;

    @JsonProperty("commit_count_4_weeks")
    private long commitCount4Weeks;

    @JsonProperty("last_4_weeks_commit_activity_series")
    private List<Long> last4WeeksCommitActivitySeries;

}
