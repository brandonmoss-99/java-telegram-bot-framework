package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * An object containing basic information about an invoice
 */
@JsonDeserialize(builder = Invoice.Builder.class)
public class Invoice {
    private final String Title; // Product name
    private final String Description; // Product description
    private final String StartParameter; // Unique bot deep-linking parameter that can be used to generate this invoice
    private final String Currency; // 3 letter ISO 4217 currency code
    private final Integer TotalAmount; // Total price in the smallest units of the currency ($1.45 = 145)

    private Invoice(Builder builder){
        this.Title = builder.Title;
        this.Description = builder.Description;
        this.StartParameter = builder.StartParameter;
        this.Currency = builder.Currency;
        this.TotalAmount = builder.TotalAmount;
    }

    // Getter methods

    @JsonProperty("title")
    public String getTitle(){return Title;}
    @JsonProperty("description")
    public String getDescription(){return Description;}
    @JsonProperty("start_parameter")
    public String getStartParameter(){return StartParameter;}
    @JsonProperty("currency")
    public String getCurrency(){return Currency;}
    @JsonProperty("total_amount")
    public Integer getTotalAmount(){return TotalAmount;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Title;
        private String Description;
        private String StartParameter;
        private String Currency;
        private Integer TotalAmount;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("title")
        public Builder setTitle(String title){this.Title = title;return this;}
        @JsonProperty("description")
        public Builder setDescription(String desc){this.Description = desc;return this;}
        @JsonProperty("start_parameter")
        public Builder setStartParameter(String param){this.StartParameter = param;return this;}
        @JsonProperty("currency")
        public Builder setCurrency(String cur){this.Currency = cur;return this;}
        @JsonProperty("total_amount")
        public Builder setTotalAmount(Integer amount){this.TotalAmount = amount;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Invoice build(){
            return new Invoice(this);
        }
    }
}
