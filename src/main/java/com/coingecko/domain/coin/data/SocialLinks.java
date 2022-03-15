package com.coingecko.domain.coin.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Social links.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SocialLinks {
    private String web;
    private String blog;
    private String github;
    private String twitter;
    private String facebook;
    private String telegram;
    private String whitepaper;
}
