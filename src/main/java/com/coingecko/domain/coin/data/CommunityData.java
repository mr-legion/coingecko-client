package com.coingecko.domain.coin.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Community data.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommunityData {

    @JsonProperty("facebook_likes")
    private Long facebookLikes;

    @JsonProperty("twitter_followers")
    private Long twitterFollowers;

    @JsonProperty("reddit_average_posts_48h")
    private Double redditAveragePosts48h;

    @JsonProperty("reddit_average_comments_48h")
    private Double redditAverageComments48h;

    @JsonProperty("reddit_subscribers")
    private Long redditSubscribers;

    @JsonProperty("reddit_accounts_active_48h")
    private Double redditAccountsActive48h;

    @JsonProperty("telegram_channel_user_count")
    private Long telegramChannelUserCount;

}
