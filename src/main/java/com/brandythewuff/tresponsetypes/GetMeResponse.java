package com.brandythewuff.tresponsetypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

import com.brandythewuff.telegramtypes.User;

@JsonDeserialize(builder = GetMeResponse.Builder.class)
public class GetMeResponse{
    private final User Result;
    private final Boolean Ok;

    private GetMeResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods
    @JsonProperty("result")
    public User getResult(){return Result;}
    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private User Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder setResult(User result){
            this.Result = result;
            return this;
        }

        public Builder setOk(boolean ok){
            this.Ok = ok;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public GetMeResponse build(){
            return new GetMeResponse(this);
        }
    }
}