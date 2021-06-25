package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = OrderInfo.Builder.class)
public class OrderInfo {
    private final String Name;
    private final String PhoneNumber;
    private final String Email;
    private final ShippingAddress ShippingAddress;

    private OrderInfo(Builder builder){
        this.Name = builder.Name;
        this.PhoneNumber = builder.PhoneNumber;
        this.Email = builder.Email;
        this.ShippingAddress = builder.ShippingAddress;
    }

    // Getter methods

    @JsonProperty("name")
    public String getName(){return Name;}
    @JsonProperty("phone_number")
    public String getPhoneNumber(){return PhoneNumber;}
    @JsonProperty("email")
    public String getEmail(){return Email;}
    @JsonProperty("shipping_address")
    public ShippingAddress getShippingAddress(){return ShippingAddress;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Name;
        private String PhoneNumber;
        private String Email;
        private ShippingAddress ShippingAddress;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("name")
        public Builder setName(String name){this.Name = name;return this;}
        @JsonProperty("phone_number")
        public Builder setPhoneNumber(String num){this.PhoneNumber = num;return this;}
        @JsonProperty("email")
        public Builder setEmail(String email){this.Email = email;return this;}
        @JsonProperty("shipping_address")
        public Builder setShippingAddress(ShippingAddress shipaddr){this.ShippingAddress = shipaddr;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public OrderInfo build(){
            return new OrderInfo(this);
        }
    }
}
