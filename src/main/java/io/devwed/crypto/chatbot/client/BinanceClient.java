package io.devwed.crypto.chatbot.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BinanceClient {

    @Value("${api.binance.endpoint}")
    private String binanceEndpoint;

}
