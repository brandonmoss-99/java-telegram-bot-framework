package com.brandythewuff.tmethodtypes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteMessage extends TMethod {
    private final Long ChatId;
    private final Integer MessageId;

    public DeleteMessage(Long cId, Integer mId){
        this.ChatId = cId;
        this.MessageId = mId;
    }

    @JsonProperty("chat_id")
    public Long getChatId(){return ChatId;}
    @JsonProperty("message_id")
    public Integer getMessageId(){return MessageId;}
}
