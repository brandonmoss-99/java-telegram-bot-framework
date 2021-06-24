package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetChatMembersCount {
    private final Integer ChatId;

    public GetChatMembersCount(Integer chatId){
        ChatId = chatId;
    }

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
}
