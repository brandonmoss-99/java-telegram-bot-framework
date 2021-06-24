package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = MessageId.Builder.class)
public class MessageId{
    private final Integer MessageId;

    private MessageId(Builder builder){
        this.MessageId = builder.MessageId;
    }

    // Getter methods

    @JsonProperty("message_id")
    public Integer getMessageId(){return MessageId;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer MessageId;

        public static Builder newInstance(){
            return new Builder();
        }
    
        private Builder(){}
    
        public Builder setMessageId(Integer msgId){this.MessageId = msgId; return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public MessageId build(){
            return new MessageId(this);
        }
    }
}