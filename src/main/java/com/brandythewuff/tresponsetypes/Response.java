package com.brandythewuff.tresponsetypes;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Response.Builder.class)
public class Response{
    private final Boolean Ok;

    private Response(Builder builder){
        this.Ok = builder.Ok;
    }

    // Getter methods

    /**
     * Get Ok status from response
     * @return true if Ok, otherwise false
     */
    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        public Builder setOk(boolean ok){
            this.Ok = ok;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Response build(){
            return new Response(this);
        }
    }
}