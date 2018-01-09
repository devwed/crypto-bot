package com.devwed.io.crypto.chatbot.model.telegram;

public class Update {

    private long update_id;

    private Message message;

    public Update() {

    }

    public long getUpdate_id() {
        return update_id;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Update{" +
                "update_id=" + update_id +
                ", message=" + message +
                '}';
    }
}
