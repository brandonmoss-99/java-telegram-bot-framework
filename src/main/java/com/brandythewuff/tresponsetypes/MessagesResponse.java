package com.brandythewuff.tresponsetypes;

import java.util.ArrayList;

import com.brandythewuff.telegramtypes.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = MessagesResponse.Builder.class)
public class MessagesResponse {
    private final ArrayList<Message> Result;
    private final Boolean Ok;

    private MessagesResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods

    @JsonProperty("result")
    public ArrayList<Message> GetResult(){return Result;}

    /**
     * Get Ok status from response
     * @return true if Ok, otherwise false
     */
    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private ArrayList<Message> Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder SetResult(ArrayList<Message> result){
            this.Result = result;
            return this;
        }

        public Builder setOk(Boolean ok){
            this.Ok = ok;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public MessagesResponse build(){
            return new MessagesResponse(this);
        }
    }
}
