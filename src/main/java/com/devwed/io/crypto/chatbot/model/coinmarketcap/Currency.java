package com.devwed.io.crypto.chatbot.model.coinmarketcap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {

    private String id;

    private String name;

    private String symbol;

    private int rank;

    private String price_usd;

    private String price_btc;

    @JsonProperty("24h_volume_usd")
    private String day_volume_usd;

    private String market_cap_usd;

    private String available_supply;

    private String total_supply;

    private String max_supply;

    @JsonProperty("percent_change_1h")
    private String percent_change_one_hour;

    @JsonProperty("percent_change_24h")
    private String percent_change_day;

    @JsonProperty("percent_change_7d")
    private String percent_change_week;

    private String last_updated;

    public Currency() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRank() {
        return rank;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public String getPrice_btc() {
        return price_btc;
    }

    public String getDay_volume_usd() {
        return day_volume_usd;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public String getAvailable_supply() {
        return available_supply;
    }

    public String getTotal_supply() {
        return total_supply;
    }

    public String getMax_supply() {
        return max_supply;
    }

    public String getPercent_change_one_hour() {
        return percent_change_one_hour;
    }

    public String getPercent_change_day() {
        return percent_change_day;
    }

    public String getPercent_change_week() {
        return percent_change_week;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public String toMarkdown() {
        return "```\n" + name + " [" + symbol + "] " + "\ncost: $" + price_usd + "\n1h: " +
                percent_change_one_hour + "%\n1d: " + percent_change_day + "%\n1w: " + percent_change_week + "% ```";
    }




}
