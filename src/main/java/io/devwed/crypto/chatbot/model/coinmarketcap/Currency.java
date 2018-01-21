package io.devwed.crypto.chatbot.model.coinmarketcap;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

    public void setName(String name) { this.name = name; }

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

    public String getPriceText() {
        Double price = BigDecimal.valueOf(Double.parseDouble(price_usd))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        return "$" + price;
    }

    public String getDayChangeText() {

        Double change = BigDecimal.valueOf(Double.parseDouble(percent_change_day))
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();

        return change + "%";
    }

    public String toInfoMarkdown() {

        long updated = Long.parseLong(last_updated);
        long current = new Date().getTime() / 1000L;

        int minutesSinceLastUpdate = (int) ((current - updated) / 60);

        return "```\n" + name + " [" + symbol + "] " + "\nprice: $" + price_usd + "\n1h: " +
                percent_change_one_hour + "%\n1d: " + percent_change_day + "%\n1w: " + percent_change_week +
                "%\nupdated: " + minutesSinceLastUpdate + " mins ago ```";
    }

}
