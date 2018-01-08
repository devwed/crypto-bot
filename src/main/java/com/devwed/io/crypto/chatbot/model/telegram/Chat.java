package com.devwed.io.crypto.chatbot.model.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chat {

    private int id;

    private String title;

    //TODO: change to enum: group, channel, etc.
    private String group;

    @JsonProperty("all_members_are_administrators")
    private boolean allAdmins;

    public Chat() {

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGroup() {
        return group;
    }

    public boolean isAllAdmins() {
        return allAdmins;
    }

}
