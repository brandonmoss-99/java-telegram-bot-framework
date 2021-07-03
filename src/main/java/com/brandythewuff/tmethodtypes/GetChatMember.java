package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetChatMember extends TMethod{
    private final Integer ChatId;
    private final Integer UserId;

    public GetChatMember(Integer chatId, Integer userId){
        url = "getChatMember";
        ChatId = chatId;
        UserId = userId;
    }

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
    @JsonProperty("user_id")
    public Integer getUserId(){return UserId;}
}
