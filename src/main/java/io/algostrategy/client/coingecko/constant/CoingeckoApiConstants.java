package io.algostrategy.client.coingecko.constant;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Constants used throughout Coingecko's API.
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

    /**
     * Default ToStringStyle used by toString methods.
     */
    public static final ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
