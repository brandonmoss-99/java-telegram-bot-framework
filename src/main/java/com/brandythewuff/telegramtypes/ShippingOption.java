package com.brandythewuff.telegramtypes;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = ShippingOption.Builder.class)
public class ShippingOption {
    private final String Id;
    private final String Title;
    private final ArrayList<LabeledPrice> Prices;

    private ShippingOption(Builder builder){
        this.Id = builder.Id;
        this.Title = builder.Title;
        this.Prices = builder.Prices;
    }

    // Getter methods

    @JsonProperty("id")
    public String getId(){return Id;}
    @JsonProperty("title")
    public String getTitle(){return Title;}
    @JsonProperty("prices")
    public ArrayList<LabeledPrice> getPrices(){return Prices;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Id;
        private String Title;
        private ArrayList<LabeledPrice> Prices;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("id")
        public Builder setId(String id){this.Id = id;return this;}
        @JsonProperty("title")
        public Builder setTitle(String title){this.Title = title;return this;}
        @JsonProperty("prices")
        public Builder setPrices(ArrayList<LabeledPrice> prices){this.Prices = prices;return this;}
        
        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ShippingOption build(){
            return new ShippingOption(this);
        }
    }
}
