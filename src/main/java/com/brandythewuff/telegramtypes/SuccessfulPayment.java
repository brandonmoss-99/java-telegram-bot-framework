package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = SuccessfulPayment.Builder.class)
public class SuccessfulPayment {
    private final String Currency; // Three-letter ISO 4217 currency code
    private final Integer TotalAmount; // Total price in the smallest units of the currency
    private final String InvoicePayload; // Bot specified invoice payload
    private final String ShippingOptionId; // Identifier of the shipping option chosen by the user
    private final OrderInfo OrderInfo; // Order info provided by the user
    private final String TelegramPaymentChargeId; // Telegram payment identifier
    private final String ProviderPaymentChargeId; // Provider payment identifier

    private SuccessfulPayment(Builder builder){
        this.Currency = builder.Currency;
        this.TotalAmount = builder.TotalAmount;
        this.InvoicePayload = builder.InvoicePayload;
        this.ShippingOptionId = builder.ShippingOptionId;
        this.OrderInfo = builder.OrderInfo;
        this.TelegramPaymentChargeId = builder.TelegramPaymentChargeId;
        this.ProviderPaymentChargeId = builder.ProviderPaymentChargeId;
    }

    // Getter methods

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
    @JsonProperty("telegram_payment_charge_id")
    public String getTelegramPaymentChargeId(){return TelegramPaymentChargeId;}
    @JsonProperty("provider_payment_charge_id")
    public String getProviderPaymentChargeId(){return ProviderPaymentChargeId;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Currency; // Three-letter ISO 4217 currency code
        private Integer TotalAmount; // Total price in the smallest units of the currency
        private String InvoicePayload; // Bot specified invoice payload
        private String ShippingOptionId; // Identifier of the shipping option chosen by the user
        private OrderInfo OrderInfo; // Order info provided by the user
        private String TelegramPaymentChargeId; // Telegram payment identifier
        private String ProviderPaymentChargeId; // Provider payment identifier

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

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
        @JsonProperty("telegram_payment_charge_id")
        public Builder setTelegramPaymentChargeId(String tPaymentCId){this.TelegramPaymentChargeId = tPaymentCId;return this;}
        @JsonProperty("provider_payment_charge_id")
        public Builder setProviderPaymentChargeId(String pPaymentCId){this.ProviderPaymentChargeId = pPaymentCId;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public SuccessfulPayment build(){
            return new SuccessfulPayment(this);
        }
    }
}
