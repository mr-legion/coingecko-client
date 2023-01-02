package io.algostrategy.client.coingecko.domain.coin.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Links to resources.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {

    private List<String> homepage;

    @JsonProperty("blockchain_site")
    private List<String> blockchainExplorers;

    @JsonProperty("official_forum_url")
    private List<String> officialForumUrl;

    @JsonProperty("chat_url")
    private List<String> chatUrl;

    @JsonProperty("announcement_url")
    private List<String> announcementUrl;

    @JsonProperty("twitter_screen_name")
    private String twitterScreenName;

    @JsonProperty("facebook_username")
    private String facebookUsername;

    @JsonProperty("bitcointalk_thread_identifier")
    private Object bitcointalkThreadIdentifier;

    @JsonProperty("telegram_channel_identifier")
    private String telegramChannelIdentifier;

    @JsonProperty("subreddit_url")
    private String subredditUrl;

    @JsonProperty("repos_url")
    private ReposUrl reposUrl;

}
