package com.devwed.io.crypto.chatbot;

import com.devwed.io.crypto.chatbot.constant.Binance;
import com.devwed.io.crypto.chatbot.constant.CoinMarketCap;
import com.devwed.io.crypto.chatbot.model.binance.ServerTime;
import com.devwed.io.crypto.chatbot.model.coinmarketcap.Currency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class ChatbotApplication {

	@Value("${api.coinmarketcap.endpoint}")
	private String cmcEndpoint;

	@Value("${api.binance.endpoint}")
	private String binanceEndpoint;

//	@Override
//	public void run(String[] args) {
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		ResponseEntity<ArrayList<Currency>> currencies = restTemplate.exchange(cmcEndpoint + CoinMarketCap.TICKER,
//				HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Currency>>() {});
//
//		for(Currency currency : currencies.getBody()) {
//			System.out.println("Symbol: " + currency.getSymbol() + ", Price: " + currency.getPrice_usd() + ", 24hr chng " + currency.getPercent_change_day() + "%");
//		}
//
//		ResponseEntity<ServerTime> serverTime = restTemplate.exchange(binanceEndpoint + Binance.TIME, HttpMethod.GET, null, ServerTime.class);
//
//		System.out.println("BinanceClient Server Time: " + serverTime.getBody().getServerTime());
//
//	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ChatbotApplication.class, args);
	}

}
