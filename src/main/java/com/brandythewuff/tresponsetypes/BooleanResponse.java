package com.brandythewuff.tresponsetypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = BooleanResponse.Builder.class)
public class BooleanResponse {
    private final Boolean Result;
    private final Boolean Ok;

    private BooleanResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods

    @JsonProperty("result")
    public Boolean GetMessage(){return Result;}

    /**
     * Get Ok status from response
     * @return true if Ok, otherwise false
     */
    public Boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Boolean Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder setMessage(Boolean message){
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
        public BooleanResponse build(){
            return new BooleanResponse(this);
        }
    }
}
