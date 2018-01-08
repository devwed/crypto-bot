package com.devwed.io.crypto.chatbot.model.telegram;

public class Message {

    private int message_id;

    private User sender;

    private Chat chat;

    private long date;

    private String text;

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



}
