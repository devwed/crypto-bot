package io.devwed.crypto.chatbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
