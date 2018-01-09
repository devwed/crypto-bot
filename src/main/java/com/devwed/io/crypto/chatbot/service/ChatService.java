package com.devwed.io.crypto.chatbot.service;

import com.devwed.io.crypto.chatbot.client.CoinMarketCapClient;
import com.devwed.io.crypto.chatbot.client.TelegramClient;
import com.devwed.io.crypto.chatbot.enums.telegram.MessageEntityType;
import com.devwed.io.crypto.chatbot.enums.telegram.ParseMode;
import com.devwed.io.crypto.chatbot.model.telegram.*;
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

        // determine entity types
        String messageReply = null;
        if(message.getEntities() != null) {
            for (MessageEntity entity : message.getEntities()) {
                if (entity.getType() == MessageEntityType.bot_command) {
                    messageReply = handleBotCommand(message.getText(), entity.getOffset(), entity.getLength());
                    break;
                }
            }
        } else {
            messageReply = "No commands specified";
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

        // remove leading forward /
        command = command.substring(1, command.length());

        String reply;
        switch(command) {
            case "stats":
                reply = statsCommand(messageText, commandOffset, commandLength);
                break;
            case "gainers":
                reply = gainersCommand(messageText, commandOffset, commandLength);
                break;
            case "losers":
                reply = losersCommand(messageText, commandOffset, commandLength);
                break;
            default:
                reply = "Unknown command: /" + command;
        }

        return reply;

    }

    public String statsCommand(String messageText, int commandOffset, int commandLength) {
        // get first word after the /stats command
        String text = messageText.substring(commandOffset + commandLength, messageText.length());

        //remove leading space
        text  = text.replaceFirst("\\s", "");
        String[] textArray = text.split("\\s");

        String statsResponse;
        if(textArray.length > 0) {
            statsResponse = cmcClient.getCurrencyInfo(textArray[0]);
        } else {
            statsResponse = "A coin/token symbol is required";
        }

        return statsResponse;
    }

    public String gainersCommand(String messageText, int commandOffset, int commandLength) {

        return null;
    }

    public String losersCommand(String messageText, int commandOffset, int commandLength) {

        return null;

    }


}
