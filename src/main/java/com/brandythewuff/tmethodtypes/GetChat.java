package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetChat extends TMethod{
    private final Integer ChatId;

    public GetChat(Integer chatId){
        url = "getChat";
        ChatId = chatId;
    }

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
}
