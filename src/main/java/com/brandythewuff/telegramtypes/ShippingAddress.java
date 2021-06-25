package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = ShippingAddress.Builder.class)
public class ShippingAddress {
    private final String CountryCode; // ISO 3166-1 alpha-2 country code
    private final String State; // State, if applicable
    private final String City; // City
    private final String StreetLineOne; // 1st line of address
    private final String StreetLineTwo; // 2nd line of address
    private final String PostCode; // Postcode

    private ShippingAddress(Builder builder){
        this.CountryCode = builder.CountryCode;
        this.State = builder.State;
        this.City = builder.City;
        this.StreetLineOne = builder.StreetLineOne;
        this.StreetLineTwo = builder.StreetLineTwo;
        this.PostCode = builder.PostCode;
    }

    // Getter methods

    @JsonProperty("country_code")
    public String getCountryCode(){return CountryCode;}
    @JsonProperty("state")
    public String getState(){return State;}
    @JsonProperty("city")
    public String getCity(){return City;}
    @JsonProperty("street_line1")
    public String getStreetLineOne(){return StreetLineOne;}
    @JsonProperty("street_line2")
    public String getStreetLineTwo(){return StreetLineTwo;}
    @JsonProperty("post_code")
    public String getPostCode(){return PostCode;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String CountryCode; // ISO 3166-1 alpha-2 country code
        private String State; // State, if applicable
        private String City; // City
        private String StreetLineOne; // 1st line of address
        private String StreetLineTwo; // 2nd line of address
        private String PostCode; // Postcode

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("country_code")
        public Builder setCountryCode(String cc){this.CountryCode = cc;return this;}
        @JsonProperty("state")
        public Builder setState(String state){this.State = state;return this;}
        @JsonProperty("city")
        public Builder setCity(String city){this.City = city;return this;}
        @JsonProperty("street_line1")
        public Builder setStreetLineOne(String slone){this.StreetLineOne = slone;return this;}
        @JsonProperty("street_line2")
        public Builder setStreetLineTwo(String sltwo){this.StreetLineTwo = sltwo;return this;}
        @JsonProperty("post_code")
        public Builder setPostCode(String postc){this.PostCode = postc;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ShippingAddress build(){
            return new ShippingAddress(this);
        }
    }
}
