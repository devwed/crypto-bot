package com.devwed.io.crypto.chatbot.client;

import com.devwed.io.crypto.chatbot.constant.CoinMarketCap;
import com.devwed.io.crypto.chatbot.model.coinmarketcap.Currency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class CoinMarketCapClient {

    @Value("${api.coinmarketcap.endpoint}")
    private String cmcEndpoint;

    public String getCurrencyInfo(String symbol) {

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(cmcEndpoint + CoinMarketCap.TICKER)
                .queryParam("limit", 0);

        ResponseEntity<ArrayList<Currency>> currencies = restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Currency>>() {});

        String currencyInfo = null;
        for(Currency c : currencies.getBody()) {
            if(Objects.equals(c.getSymbol().toUpperCase(), symbol.toUpperCase())) {

                //meme
                if(Objects.equals(symbol.toUpperCase(), "XRP")) {
                    c.setName("Cripple");
                }

                currencyInfo = c.toMarkdown();
                break;

            }
        }

        if(currencyInfo == null) {
            currencyInfo = "Can't find symbol: " + symbol;
        }

        return currencyInfo;

    }



}
