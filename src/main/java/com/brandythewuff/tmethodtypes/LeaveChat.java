package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LeaveChat extends TMethod{
    private final Integer ChatId;

    public LeaveChat(Integer cId){
        url = "leaveChat";
        this.ChatId = cId;
    }

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
}
