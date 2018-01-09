package com.devwed.io.crypto.chatbot.model.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chat {

    private long id;

    private String title;

    //TODO: change to enum: group, channel, etc.
    private String group;

    @JsonProperty("all_members_are_administrators")
    private boolean allAdmins;

    public Chat() {

    }

    public long getId() {
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

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", group='" + group + '\'' +
                ", allAdmins=" + allAdmins +
                '}';
    }
}
