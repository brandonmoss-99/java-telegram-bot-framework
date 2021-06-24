package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LeaveChat {
    private final Integer ChatId;

    public LeaveChat(Integer cId){
        this.ChatId = cId;
    }

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
}
