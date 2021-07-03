package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetChatAdministrators extends TMethod {
    private final Integer ChatId;

    public GetChatAdministrators(Integer chatId){
        url = "getChatAdministrators";
        ChatId = chatId;
    }

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
}
