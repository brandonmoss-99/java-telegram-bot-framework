package com.brandythewuff.tmethodtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = AnswerPreCheckoutQuery.Builder.class)
public class AnswerPreCheckoutQuery {
    private final String PreCheckoutQueryId; // Unique identifier for the query to be answered
    private final Boolean Ok; // True if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use False if there are any problems.
    private final String ErrorMessage; // Required if ok is False. Error message in human readable form that explains the reason for failure to proceed with the checkout

    private AnswerPreCheckoutQuery(Builder builder){
        this.PreCheckoutQueryId = builder.PreCheckoutQueryId;
        this.Ok = builder.Ok;
        this.ErrorMessage = builder.ErrorMessage;
    }

    // Getter methods

    @JsonProperty("pre_checkout_query_id")
    public String getPreCheckoutQueryId(){return PreCheckoutQueryId;}
    @JsonProperty("ok")
    public Boolean getOk(){return Ok;}
    @JsonProperty("error_message")
    public String getErrorMessage(){return ErrorMessage;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String PreCheckoutQueryId; // Unique identifier for the query to be answered
        private Boolean Ok; // True if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use False if there are any problems.
        private String ErrorMessage; // Required if ok is False. Error message in human readable form that explains the reason for failure to proceed with the checkout

        public static Builder newInstance(String preCheckoutQId, Boolean ok){
            return new Builder(preCheckoutQId, ok);
        }

        private Builder(String preCheckoutQId, Boolean ok){
            this.setPreCheckoutQueryId(preCheckoutQId);
            this.setOk(ok);
        }

        @JsonProperty("pre_checkout_query_id")
        public Builder setPreCheckoutQueryId(String preCheckoutQId){this.PreCheckoutQueryId = preCheckoutQId;return this;}
        @JsonProperty("ok")
        public Builder setOk(Boolean ok){this.Ok = ok;return this;}
        @JsonProperty("error_message")
        public Builder setErrorMessage(String errMsg){this.ErrorMessage = errMsg;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public AnswerPreCheckoutQuery build(){
            return new AnswerPreCheckoutQuery(this);
        }
    }
}
