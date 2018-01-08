package com.devwed.io.crypto.chatbot.controller;

import com.devwed.io.crypto.chatbot.model.telegram.Update;
import com.devwed.io.crypto.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1")
public class ChatController {

    @Value("${telegram.cryptobot.api.key}")
    private String telegramApiKey;

    @Autowired
    private ChatService chatService;

    @PostMapping("/{apiKey}")
    ResponseEntity<?> botWebhook(@PathVariable String apiKey, @RequestBody Update update) {

        if(!Objects.equals(apiKey, telegramApiKey)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(chatService.processBotUpdate(update),HttpStatus.OK);

    }



}
