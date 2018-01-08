package com.devwed.io.crypto.chatbot.service;

import com.devwed.io.crypto.chatbot.client.CoinMarketCapClient;
import com.devwed.io.crypto.chatbot.enums.telegram.ParseMode;
import com.devwed.io.crypto.chatbot.model.coinmarketcap.Currency;
import com.devwed.io.crypto.chatbot.model.telegram.Message;
import com.devwed.io.crypto.chatbot.model.telegram.MessageReply;
import com.devwed.io.crypto.chatbot.model.telegram.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private CoinMarketCapClient cmcClient;

    public MessageReply processBotUpdate(Update update) {

        Message message = update.getMessage();

        MessageReply reply = new MessageReply(message.getChat().getId(), coinStats("REQ"), ParseMode.Markdown);

        return reply;

    }

    public String coinStats(String symbol) {

        Currency currency = cmcClient.getCurrencyInfo(symbol);

        return currency.toMarkdown();

    }


}
