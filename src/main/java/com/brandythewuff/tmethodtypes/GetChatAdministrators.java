package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetChatAdministrators {
    private final Integer ChatId;

    public GetChatAdministrators(Integer chatId){
        ChatId = chatId;
    }

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
}
