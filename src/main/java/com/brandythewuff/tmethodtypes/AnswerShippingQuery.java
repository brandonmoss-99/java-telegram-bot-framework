package com.brandythewuff.tmethodtypes;

import java.util.ArrayList;
import com.brandythewuff.telegramtypes.ShippingOption;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = AnswerShippingQuery.Builder.class)
public class AnswerShippingQuery {
    private final String ShippingQueryId; // Unique identifier for the query to be answered
    private final Boolean Ok; // True if delivery to the specified address is possible and False if there are any problems
    private final ArrayList<ShippingOption> ShippingOptions; // Required if ok is True. A JSON-serialized array of available shipping options.
    private final String ErrorMessage; // Required if ok is False. Error message in human readable form that explains why it is impossible to complete the order

    private AnswerShippingQuery(Builder builder){
        this.ShippingQueryId = builder.ShippingQueryId;
        this.Ok = builder.Ok;
        this.ShippingOptions = builder.ShippingOptions;
        this.ErrorMessage = builder.ErrorMessage;
    }

    // Getter methods

    @JsonProperty("shipping_query_id")
    public String getShippingQueryId(){return ShippingQueryId;}
    @JsonProperty("ok")
    public Boolean getOk(){return Ok;}
    @JsonProperty("shipping_options")
    public ArrayList<ShippingOption> getShippingOptions(){return ShippingOptions;}
    @JsonProperty("error_message")
    public String getErrorMessage(){return ErrorMessage;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String ShippingQueryId; // Unique identifier for the query to be answered
        private Boolean Ok; // True if delivery to the specified address is possible and False if there are any problems
        private ArrayList<ShippingOption> ShippingOptions; // Required if ok is True. A JSON-serialized array of available shipping options.
        private String ErrorMessage; // Required if ok is False. Error message in human readable form that explains why it is impossible to complete the order

        public static Builder newInstance(String shipQueryId, Boolean ok){
            return new Builder(shipQueryId, ok);
        }

        private Builder(String shipQueryId, Boolean ok){
            this.setShippingQueryId(shipQueryId);
            this.setOk(ok);
        }

        @JsonProperty("shipping_query_id")
        public Builder setShippingQueryId(String shipQId){this.ShippingQueryId = shipQId;return this;}
        @JsonProperty("ok")
        public Builder setOk(Boolean ok){this.Ok = ok;return this;}
        @JsonProperty("shipping_options")
        public Builder setShippingOptions(ArrayList<ShippingOption> shipoptions){this.ShippingOptions = shipoptions;return this;}
        @JsonProperty("error_message")
        public Builder setErrorMessage(String errMsg){this.ErrorMessage = errMsg;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public AnswerShippingQuery build(){
            return new AnswerShippingQuery(this);
        }
    }
}
