package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetChat {
    private final Integer ChatId;

    public GetChat(Integer chatId){
        ChatId = chatId;
    }

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
}
