package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = ShippingQuery.Builder.class)
public class ShippingQuery {
    private final String Id;
    private final User From;
    private final String InvoicePayload;
    private final ShippingAddress ShippingAddress;

    private ShippingQuery(Builder builder){
        this.Id = builder.Id;
        this.From = builder.From;
        this.InvoicePayload = builder.InvoicePayload;
        this.ShippingAddress = builder.ShippingAddress;
    }

    // Getter methods

    @JsonProperty("id")
    public String getId(){return Id;}
    @JsonProperty("from")
    public User getFrom(){return From;}
    @JsonProperty("invoice_payload")
    public String getInvoicePayload(){return InvoicePayload;}
    @JsonProperty("shipping_address")
    public ShippingAddress getShippingAddress(){return ShippingAddress;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Id;
        private User From;
        private String InvoicePayload;
        private ShippingAddress ShippingAddress;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("id")
        public Builder setId(String id){this.Id = id;return this;}
        @JsonProperty("from")
        public Builder setFrom(User from){this.From = from;return this;}
        @JsonProperty("invoice_payload")
        public Builder setInvoicePayload(String payload){this.InvoicePayload = payload;return this;}
        @JsonProperty("shipping_address")
        public Builder setShippingAddress(ShippingAddress shipAddr){this.ShippingAddress = shipAddr;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ShippingQuery build(){
            return new ShippingQuery(this);
        }
    }
}
