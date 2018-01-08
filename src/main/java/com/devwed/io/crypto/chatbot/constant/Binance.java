package com.devwed.io.crypto.chatbot.constant;

public final class Binance {

    // general endpoints
    public static final String PING = "/v1/ping";
    public static final String TIME = "/v1/time";
    public static final String INFO = "/v1/exchangeInfo";

    // market data endpoints
    public static final String ORDER_BOOK = "/v1/depth";
    public static final String TRADES = "/v1/trades";
    public static final String HISTORICAL_TRADES = "/v1/historicalTrades";
    public static final String AGGREGATE_TRADES = "/v1/aggTrades";
    public static final String KLINES = "/v1/klines";
    public static final String CHANGE_LAST_DAY = "/v1/ticker/24hr";
    public static final String TICKER = "/v3/ticker/price";
    public static final String BOOK_TICKER = "/v3/ticker/bookTicker";

    //TODO: account endpoints

}
