package com.brandythewuff.tresponsetypes;

import com.brandythewuff.telegramtypes.Chat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = MessageResponse.Builder.class)
public class ChatResponse {
    private final Chat Result;
    private final Boolean Ok;

    private ChatResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods

    @JsonProperty("result")
    public Chat GetChat(){return Result;}

    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Chat Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder SetChat(Chat chat){
            this.Result = chat;
            return this;
        }

        public Builder setOk(Boolean ok){
            this.Ok = ok;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ChatResponse build(){
            return new ChatResponse(this);
        }
    }
}
