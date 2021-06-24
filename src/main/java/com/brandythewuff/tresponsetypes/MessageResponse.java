package com.brandythewuff.tresponsetypes;

import com.brandythewuff.telegramtypes.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = MessageResponse.Builder.class)
public class MessageResponse{
    private final Message Result;
    private final Boolean Ok;

    private MessageResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods

    @JsonProperty("result")
    public Message GetMessage(){return Result;}

    /**
     * Get Ok status from response
     * @return true if Ok, otherwise false
     */
    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Message Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder SetMessage(Message message){
            this.Result = message;
            return this;
        }

        public Builder setOk(Boolean ok){
            this.Ok = ok;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public MessageResponse build(){
            return new MessageResponse(this);
        }
    }
}