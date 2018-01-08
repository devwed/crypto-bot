package com.devwed.io.crypto.chatbot.client;

import com.devwed.io.crypto.chatbot.constant.CoinMarketCap;
import com.devwed.io.crypto.chatbot.model.coinmarketcap.Currency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class CoinMarketCapClient {

    @Value("${api.coinmarketcap.endpoint}")
    private String cmcEndpoint;

    public Currency getCurrencyInfo(String symbol) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ArrayList<Currency>> currencies = restTemplate.exchange(cmcEndpoint + CoinMarketCap.TICKER,
                HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Currency>>() {});

        Currency currency = null;
        for(Currency c : currencies.getBody()) {
            if(Objects.equals(c.getSymbol().toUpperCase(), symbol.toUpperCase())) {
                currency = c;
            }
        }

        return currency;

    }



}
