package com.brandythewuff.tresponsetypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

import java.util.List;

import com.brandythewuff.telegramtypes.Update;

@JsonDeserialize(builder = UpdateResponse.Builder.class)
public class UpdateResponse{
    private final List<Update> Result;
    private final Boolean Ok;

    private UpdateResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods

    @JsonProperty("result")
    public List<Update> getResult(){return Result;}

    /**
     * Get Ok status from response
     * @return true if Ok, otherwise false
     */
    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private List<Update> Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder setResult(List<Update> result){
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
        public UpdateResponse build(){
            return new UpdateResponse(this);
        }
    }
}