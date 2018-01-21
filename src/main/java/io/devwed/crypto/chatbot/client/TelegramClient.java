package io.devwed.crypto.chatbot.client;

import io.devwed.crypto.chatbot.constant.Telegram;
import io.devwed.crypto.chatbot.enums.telegram.ParseMode;
import io.devwed.crypto.chatbot.model.telegram.BotMessage;
import io.devwed.crypto.chatbot.model.telegram.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TelegramClient {

    @Value("${api.telegram.bot.endpoint}")
    private String telegramEndpoint;

    @Value("${telegram.cryptobot.api.key}")
    private String telegramApiKey;

    public void sendMessage(long chatId, String text) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<BotMessage> botMessage = new HttpEntity<>(new BotMessage(chatId, text, ParseMode.Markdown), headers);

        ResponseEntity<Message> messageResponse = restTemplate.exchange(telegramEndpoint + Telegram.APIKEY_PREFIX + telegramApiKey + Telegram.SEND_MESSAGE,
                HttpMethod.POST, botMessage, Message.class);

        System.out.println(messageResponse.getStatusCode());

    }
}
