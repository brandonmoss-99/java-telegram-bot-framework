package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = MessageAutoDeleteTimerChanged.Builder.class)
public class MessageAutoDeleteTimerChanged{
    private final Integer MessageAutoDeleteTime; // New auto-delete time for messages in the chat

    private MessageAutoDeleteTimerChanged(Builder builder){
        this.MessageAutoDeleteTime = builder.MessageAutoDeleteTime;
    }

    // Getter methods

    @JsonProperty("message_auto_delete_time")
    public Integer getMessageAutoDeleteTime(){return MessageAutoDeleteTime;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer MessageAutoDeleteTime;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        public Builder setMessageAutoDeleteTime(Integer dt){this.MessageAutoDeleteTime = dt;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public MessageAutoDeleteTimerChanged build(){
            return new MessageAutoDeleteTimerChanged(this);
        }
    }
}