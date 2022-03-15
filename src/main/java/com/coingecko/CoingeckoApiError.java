package com.coingecko;

import com.coingecko.constant.CoingeckoApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Coingecko API error.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoingeckoApiError {

    @JsonProperty("error")
    private String msg;

    public CoingeckoApiError() {
    }

    public CoingeckoApiError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, CoingeckoApiConstants.TO_STRING_BUILDER_STYLE)
                .append("msg", msg)
                .toString();
    }
}
