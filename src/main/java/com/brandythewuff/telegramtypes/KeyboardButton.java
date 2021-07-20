package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = KeyboardButton.Builder.class)
public class KeyboardButton {
    private final String Text; // Text of button. If no optional fields used, sent as message when pressed
    private final Boolean RequestContact; // True to send user's phone number (private chat only)
    private final Boolean RequestLocation; // True to send user's location (private chat only)
    //private final KeyboardButtonPollType RequestPoll; // User asked to create a poll & send to bot when button pressed (private chat only)

    private KeyboardButton(Builder builder){
        this.Text = builder.Text;
        this.RequestContact = builder.RequestContact;
        this.RequestLocation = builder.RequestLocation;
    }

    @JsonProperty("text")
    public String getText(){return Text;}
    @JsonProperty("request_contact")
    public Boolean getRequestContact(){return RequestContact;}
    @JsonProperty("request_location")
    public Boolean getRequestLocation(){return RequestLocation;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Text;
        private Boolean RequestContact;
        private Boolean RequestLocation;

        public static Builder newInstance(String text){
            return new Builder(text);
        }

        private Builder(String text){
            setText(text);
        }

        @JsonProperty("text")
        public Builder setText(String text){this.Text = text;return this;}
        @JsonProperty("request_contact")
        public Builder setRequestContact(Boolean rCont){this.RequestContact = rCont;return this;}
        @JsonProperty("request_location")
        public Builder setRequestLocation(Boolean rLoc){this.RequestLocation = rLoc;return this;}

        public KeyboardButton build(){
            return new KeyboardButton(this);
        }
    }
}
