package com.brandythewuff.telegramtypes;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoiceChatParticipantsInvited{
    private ArrayList<User> Users;

    @JsonProperty("users")
    public void setUsers(ArrayList<User> users){this.Users = users;}

    @JsonProperty("users")
    public ArrayList<User> getUsers(){return Users;}
}