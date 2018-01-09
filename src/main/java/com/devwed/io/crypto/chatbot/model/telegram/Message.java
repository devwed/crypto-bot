package com.devwed.io.crypto.chatbot.model.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Message {

    private long message_id;

    @JsonProperty("from")
    private User sender;

    private Chat chat;

    private long date;

    private String text;

    private ArrayList<MessageEntity> entities;

    public Message() {

    }

    public long getMessage_id() {
        return message_id;
    }

    public User getSender() {
        return sender;
    }

    public Chat getChat() {
        return chat;
    }

    public long getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public ArrayList<MessageEntity> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", sender=" + sender +
                ", chat=" + chat +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", entities=" + entities +
                '}';
    }
}
