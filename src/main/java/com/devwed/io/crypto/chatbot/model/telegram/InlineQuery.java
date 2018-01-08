package com.devwed.io.crypto.chatbot.model.telegram;

public class InlineQuery {

    private String id;

    private User sender;

    private String query;

    private String offset;

    public InlineQuery() {
    }

    public String getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public String getQuery() {
        return query;
    }

    public String getOffset() {
        return offset;
    }
}
