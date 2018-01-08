package com.devwed.io.crypto.chatbot.service;

import com.devwed.io.crypto.chatbot.client.CoinMarketCapClient;
import com.devwed.io.crypto.chatbot.enums.telegram.ParseMode;
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

        String text = message.getText();

        //TODO: some parser method here
        String[] args = text.split(" ");
        String command = null;
        String symbol = null;
        if(args.length < 2) {
             //TODO: return invalid # of args
        } else {
             command = args[0];
             symbol = args[1];
        }

        MessageReply reply = new MessageReply(message.getChat().getId(), cmcClient.getCurrencyInfo(symbol), ParseMode.Markdown);

        return reply;

    }

    public void parseMessageText(String text) {

    }


}
