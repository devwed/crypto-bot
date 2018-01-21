package io.devwed.crypto.chatbot.service;

import io.devwed.crypto.chatbot.client.CoinMarketCapClient;
import io.devwed.crypto.chatbot.client.TelegramClient;
import io.devwed.crypto.chatbot.enums.telegram.MessageEntityType;
import io.devwed.crypto.chatbot.model.telegram.Message;
import io.devwed.crypto.chatbot.model.telegram.MessageEntity;
import io.devwed.crypto.chatbot.model.telegram.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private CoinMarketCapClient cmcClient;

    @Autowired
    private TelegramClient telegramClient;

    @Async
    public void botUpdate(Update update) {

        telegramClient.sendMessage(update.getMessage().getChat().getId(), processMessage(update.getMessage()));

    }

    public String processMessage(Message message) {

        String messageReply = "No commands specified";

        // determine entity types
        for (MessageEntity entity : message.getEntities()) {
            if (entity.getType() == MessageEntityType.bot_command) {
                messageReply = handleBotCommand(message.getText(), entity.getOffset(), entity.getLength());
                break;
            }
        }

        return messageReply;
    }

    public String handleBotCommand(String messageText, int commandOffset, int commandLength) {

        // parse out command based on offset and length
        String command = messageText.substring(commandOffset, commandOffset + commandLength);

        // remove @botname mention
        if(command.contains("@")) {
            command = command.substring(0, command.indexOf("@"));
        }

        String reply;
        switch(command) {
            case "/stats":
                reply = statsCommand(messageText, commandOffset, commandLength);
                break;
            case "/gainers":
                reply = gainersCommand();
                break;
            case "/losers":
                reply = losersCommand();
                break;
            default:
                reply = "Unknown command: " + command;
        }

        return reply;

    }

    public String statsCommand(String messageText, int commandOffset, int commandLength) {
        // get first word after the /stats command
        String text = messageText.substring(commandOffset + commandLength, messageText.length());
        String[] textArray = text.split("\\s");

        String symbol = null;
        for(String s : textArray) {
            s = s.trim();
            if(!s.isEmpty()) {
                symbol = s;
                break;
            }
        }

        String stats = "A symbol is required for this command (e.g. /stats eth)";
        if(symbol != null) {
            stats = cmcClient.getCurrencyInfo(symbol);
        }

        return stats;
    }

    public String gainersCommand() {

        return cmcClient.getTodaysGainers();
    }

    public String losersCommand(){

        return cmcClient.getTodaysLosers();

    }


}
