package com.brandythewuff.tresponsetypes;

import com.brandythewuff.telegramtypes.Poll;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = PollResponse.Builder.class)
public class PollResponse {
    private final Poll Result;
    private final Boolean Ok;

    private PollResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods

    @JsonProperty("result")
    public Poll GetResult(){return Result;}

    /**
     * Get Ok status from response
     * @return true if Ok, otherwise false
     */
    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Poll Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder SetResult(Poll result){
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
        public PollResponse build(){
            return new PollResponse(this);
        }
    }
}
