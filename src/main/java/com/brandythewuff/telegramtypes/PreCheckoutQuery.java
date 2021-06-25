package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = PreCheckoutQuery.Builder.class)
public class PreCheckoutQuery {
    private final String Id;
    private final User From;
    private final String Currency;
    private final Integer TotalAmount;
    private final String InvoicePayload;
    private final String ShippingOptionId;
    private final OrderInfo OrderInfo;

    private PreCheckoutQuery(Builder builder){
        this.Id = builder.Id;
        this.From = builder.From;
        this.Currency = builder.Currency;
        this.TotalAmount = builder.TotalAmount;
        this.InvoicePayload = builder.InvoicePayload;
        this.ShippingOptionId = builder.ShippingOptionId;
        this.OrderInfo = builder.OrderInfo;
    }

    // Getter methods

    @JsonProperty("id")
    public String getId(){return Id;}
    @JsonProperty("from")
    public User getFrom(){return From;}
    @JsonProperty("currency")
    public String getCurrency(){return Currency;}
    @JsonProperty("total_amount")
    public Integer getTotalAmount(){return TotalAmount;}
    @JsonProperty("invoice_payload")
    public String getInvoicePayload(){return InvoicePayload;}
    @JsonProperty("shipping_option_id")
    public String getShippingOptionId(){return ShippingOptionId;}
    @JsonProperty("order_info")
    public OrderInfo getOrderInfo(){return OrderInfo;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Id;
        private User From;
        private String Currency; // Three-letter ISO 4217 currency code
        private Integer TotalAmount; // Total price in the smallest units of the currency
        private String InvoicePayload; // Bot specified invoice payload
        private String ShippingOptionId; // Identifier of the shipping option chosen by the user
        private OrderInfo OrderInfo; // Order info provided by the user

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("id")
        public Builder setId(String id){this.Id = id;return this;}
        @JsonProperty("from")
        public Builder setFrom(User from){this.From = from;return this;}
        @JsonProperty("currency")
        public Builder setCurrency(String cur){this.Currency = cur;return this;}
        @JsonProperty("total_amount")
        public Builder setTotalAmount(Integer totAmount){this.TotalAmount = totAmount;return this;}
        @JsonProperty("invoice_payload")
        public Builder setInvoicePayload(String payload){this.InvoicePayload = payload;return this;}
        @JsonProperty("shipping_option_id")
        public Builder setShippingOptionId(String shipOpId){this.ShippingOptionId = shipOpId;return this;}
        @JsonProperty("order_info")
        public Builder setOrderInfo(OrderInfo ordInfo){this.OrderInfo = ordInfo;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public PreCheckoutQuery build(){
            return new PreCheckoutQuery(this);
        }
    }
}
