package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetChatMembersCount extends TMethod {
    private final Integer ChatId;

    public GetChatMembersCount(Integer chatId){
        url = "getChatMembersCount";
        ChatId = chatId;
    }

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
}
