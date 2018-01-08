package com.devwed.io.crypto.chatbot.model.telegram;

import com.devwed.io.crypto.chatbot.enums.telegram.ParseMode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageReply {

    private int chat_id;

    private String text;

    private ParseMode parse_mode;

    @JsonProperty("disable_web_page_preview")
    private boolean disableWebPagePreview = true;

    @JsonProperty("disable_notification")
    private boolean disableNotification = true;

    @JsonProperty("reply_to_message_id")
    private int replyToMessageId;

    public MessageReply() {

    }

    public MessageReply(int chat_id, String text, ParseMode parse_mode) {
        this.chat_id = chat_id;
        this.text = text;
        this.parse_mode = parse_mode;
    }

    public MessageReply(int chat_id, String text, ParseMode parse_mode, boolean disableWebPagePreview, boolean disableNotification, int replyToMessageId) {
        this.chat_id = chat_id;
        this.text = text;
        this.parse_mode = parse_mode;
        this.disableWebPagePreview = disableWebPagePreview;
        this.disableNotification = disableNotification;
        this.replyToMessageId = replyToMessageId;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ParseMode getParse_mode() {
        return parse_mode;
    }

    public void setParse_mode(ParseMode parse_mode) {
        this.parse_mode = parse_mode;
    }

    public boolean isDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    public void setDisableWebPagePreview(boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
    }

    public boolean isDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    public int getReplyToMessageId() {
        return replyToMessageId;
    }

    public void setReplyToMessageId(int replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }


}
