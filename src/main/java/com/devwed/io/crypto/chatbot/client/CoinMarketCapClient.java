package com.devwed.io.crypto.chatbot.client;

import com.devwed.io.crypto.chatbot.constant.CoinMarketCap;
import com.devwed.io.crypto.chatbot.model.coinmarketcap.Currency;
import com.devwed.io.crypto.chatbot.util.GainsComparator;
import com.devwed.io.crypto.chatbot.util.LosersComparator;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Component
public class CoinMarketCapClient {

    @Value("${api.coinmarketcap.endpoint}")
    private String cmcEndpoint;

    public List<Currency> cmcRequest() {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(cmcEndpoint + CoinMarketCap.TICKER)
                .queryParam("limit", 0);
        ResponseEntity<ArrayList<Currency>> response = restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Currency>>() {});

        // TODO: handle response

        return response.getBody();

    }

    public String getCurrencyInfo(String symbol) {

        List<Currency> currencies = cmcRequest();

        String currencyInfo = null;
        for(Currency c : currencies) {
            if(Objects.equals(c.getSymbol().toUpperCase(), symbol.toUpperCase())) {
                //meme
                if(Objects.equals(symbol.toUpperCase(), "XRP")) {
                    c.setName("Cripple");
                }
                currencyInfo = c.toInfoMarkdown();
                break;
            }
        }

        if(currencyInfo == null) {
            currencyInfo = "Can't find symbol: " + symbol;
        }

        return currencyInfo;

    }

    public String getTodaysGainers() {

        List<Currency> currencies = getValidCurrencies(cmcRequest());

        // get top 500
        currencies = currencies.subList(0, 499);

        // get today's top 10
        Collections.sort(currencies, new GainsComparator());
        currencies = currencies.subList(0, 9);

        String dataTable = rankingTablePrettified(currencies);
        String tableHeader = generateTableHeader("GAINERS (past 24h)", dataTable);

        String result = "```\n" + tableHeader + "\n"+ dataTable + " ```";

        return result;

    }

    public String getTodaysLosers() {
        List<Currency> currencies = getValidCurrencies(cmcRequest());

        // get top 500
        currencies = currencies.subList(0, 499);

        // get today's top 10
        Collections.sort(currencies, new LosersComparator());
        currencies = currencies.subList(0, 9);

        String dataTable = rankingTablePrettified(currencies);
        String tableHeader = generateTableHeader("LOSERS (past 24h)", dataTable);
        String result = "```\n" + tableHeader + "\n"+ dataTable + " ```";

        return result;

    }

    public List<Currency> getValidCurrencies(List<Currency> currencies) {

        List<Currency> validCurrencies = new ArrayList<>();

        for(Currency c : currencies) {
            if(c.getPercent_change_day() != null && c.getPrice_usd() != null && c.getSymbol() !=  null) {
                validCurrencies.add(c);
            }
        }

       return validCurrencies;
    }

    public String rankingTablePrettified(List<Currency> currencies) {

        Map<String, Integer> columns = getColumnLengths(currencies);

        // build heading cells
        String symbolHeading = generateCell("symbol", columns.get("symbol"));
        String priceHeading = generateCell("price", columns.get("price"));
        String changeHeading = generateCell("change", columns.get("change"));
        String heading = "|" + symbolHeading + priceHeading + changeHeading + "\n";
        String spacer = generateTableSpacer(heading);
        String result = spacer + heading + spacer;

        for(Currency currency : currencies) {
            result = result + "|" + generateCell(currency.getSymbol(), columns.get("symbol"));
            result = result + generateCell(currency.getPriceText(), columns.get("price"));
            result = result + generateCell(currency.getDayChangeText(), columns.get("change")) + "\n";
        }

        result = result + spacer;

        return result;

    }

    public String generateTableHeader(String tableHeadingText, String data) {
        String columnHeadings = data.split("\n")[0];
        String tableHeader = Strings.padStart(tableHeadingText, (columnHeadings.length()
                + tableHeadingText.length())/2, ' ');
        return tableHeader;
    }

    public String generateCell(String text, int maxLength) {

        String column = Strings.padStart(text,(maxLength + text.length())/2, ' ');
        column = Strings.padEnd(column, maxLength, ' ');
        column = column + "|";

        return column;

    }

    public String generateTableSpacer(String text) {
        String spacer = text.replaceAll("\\|", "+");
        spacer = spacer.replaceAll("[\\w ]", "-");

        return spacer;
    }

    public Map<String, Integer> getColumnLengths(List<Currency> currencies) {
        String symbolHeading = "symbol";
        String priceHeading = "price";
        String changeHeading = "change";

        int maxSymbolLength = 0;
        int maxPriceLength = 0;
        int maxPercentageLength = 0;
        for(Currency c : currencies) {
            if (c.getSymbol().length() > maxSymbolLength) {
                maxSymbolLength = c.getSymbol().length();
            }
            if(c.getPriceText().length() > maxPriceLength) {
                maxPriceLength = c.getPrice_usd().length();
            }
            if (c.getDayChangeText().length() > maxPercentageLength) {
                maxPercentageLength = c.getPercent_change_day().length();
            }
        }

        Map<String, Integer> columnLengths = new HashMap<>();
        columnLengths.put(symbolHeading, calculateLengthWithPadding(symbolHeading, maxSymbolLength));
        columnLengths.put(priceHeading, calculateLengthWithPadding(priceHeading, maxPriceLength));
        columnLengths.put(changeHeading, calculateLengthWithPadding(changeHeading, maxPercentageLength));

        return columnLengths;

    }

    private int calculateLengthWithPadding(String heading, int maxLength) {
        int padding = 2;

        if(heading.length() > maxLength) {
           maxLength = heading.length();
        }
        return maxLength + padding;
    }



}
