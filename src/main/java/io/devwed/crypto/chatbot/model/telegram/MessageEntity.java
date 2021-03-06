package io.devwed.crypto.chatbot.model.telegram;

import io.devwed.crypto.chatbot.enums.telegram.MessageEntityType;

public class MessageEntity {

    private int offset;

    private int length;

    private MessageEntityType type;

    public MessageEntity() {

    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return length;
    }

    public MessageEntityType getType() {
        return type;
    }
}
