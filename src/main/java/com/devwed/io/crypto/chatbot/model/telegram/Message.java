package com.devwed.io.crypto.chatbot.model.telegram;

import java.util.ArrayList;

public class Message {

    private int message_id;

    private User sender;

    private Chat chat;

    private long date;

    private String text;

    private ArrayList<MessageEntity> entities;

    public Message() {

    }

    public int getMessage_id() {
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



}
