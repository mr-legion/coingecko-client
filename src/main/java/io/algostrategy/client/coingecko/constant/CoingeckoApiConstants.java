package io.algostrategy.client.coingecko.constant;

import lombok.experimental.UtilityClass;

/**
 * Constants used throughout API.
 */
@UtilityClass
public class CoingeckoApiConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "coingecko.com";

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://api." + BASE_DOMAIN;

    public static final String ZONED_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
}
