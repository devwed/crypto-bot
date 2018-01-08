package com.devwed.io.crypto.chatbot.model.telegram;

public class Update {

    private int update_id;

    private Message message;

    public Update() {

    }

    public int getUpdate_id() {
        return update_id;
    }

    public Message getMessage() {
        return message;
    }



}
