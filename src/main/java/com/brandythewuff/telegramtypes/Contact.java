package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Contact.Builder.class)
public class Contact{
    private final String PhoneNumber;
    private final String FirstName;
    private final String LastName;
    private final Long UserId; // Contacts user ID in telegram
    private final String VCard; // Additional contact data in vCard format

    private Contact(Builder builder){
        this.PhoneNumber = builder.PhoneNumber;
        this.FirstName = builder.FirstName;
        this.LastName = builder.LastName;
        this.UserId = builder.UserId;
        this.VCard = builder.VCard;
    }

    // Getter methods

    @JsonProperty("phone_number")
    public String getPhoneNumber(){return PhoneNumber;}
    @JsonProperty("first_name")
    public String getFirstName(){return FirstName;}
    @JsonProperty("last_name")
    public String getLastName(){return LastName;}
    @JsonProperty("user_id")
    public Long getUserId(){return UserId;}
    @JsonProperty("vcard")
    public String getVCard(){return VCard;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String PhoneNumber;
        private String FirstName;
        private String LastName;
        private Long UserId; // Contacts user ID in telegram
        private String VCard; // Additional contact data in vCard format

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("phone_number")
        public Builder setPhoneNumber(String num){this.PhoneNumber = num;return this;}
        @JsonProperty("first_name")
        public Builder setFirstName(String fname){this.FirstName = fname;return this;}
        @JsonProperty("last_name")
        public Builder setLastName(String lname){this.LastName = lname;return this;}
        @JsonProperty("user_id")
        public Builder setUserId(Long id){this.UserId = id;return this;}
        @JsonProperty("vcard")
        public Builder setVCard(String vcard){this.VCard = vcard;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Contact build(){
            return new Contact(this);
        }
    }     
}