package com.coingecko.domain.coin;

import com.coingecko.constant.CoingeckoApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An coin.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {

    private String id;
    private String symbol;
    private String name;

    public Coin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, CoingeckoApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("symbol", symbol)
                .append("name", name)
                .toString();
    }
}
