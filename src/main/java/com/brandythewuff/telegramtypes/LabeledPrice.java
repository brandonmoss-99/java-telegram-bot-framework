package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * An object representing a portion of the price for goods
 * or services
 */
@JsonDeserialize(builder = LabeledPrice.Builder.class)
public class LabeledPrice {
    private final String Label;
    private final Integer Amount;

    private LabeledPrice(Builder builder){
        this.Label = builder.Label;
        this.Amount = builder.Amount;
    }

    // Getter methods

    @JsonProperty("label")
    public String getLabel(){return Label;}
    @JsonProperty("amount")
    public Integer getAmount(){return Amount;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Label;
        private Integer Amount;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        public Builder setLabel(String label){this.Label = label;return this;}
        public Builder setAmount(Integer amount){this.Amount = amount;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public LabeledPrice build(){
            return new LabeledPrice(this);
        }
    }
}
