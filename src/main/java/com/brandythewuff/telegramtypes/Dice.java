package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Dice.Builder.class)
public class Dice{
    private final String Emoji;
    private final Integer Value;

    private Dice(Builder builder){
        this.Emoji = builder.Emoji;
        this.Value = builder.Value;
    }

    // Getter methods

    @JsonProperty("emoji")
    public String getEmoji(){return Emoji;}
    @JsonProperty("value")
    public Integer getValue(){return Value;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Emoji;
        private Integer Value;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("emoji")
        public Builder setEmoji(String e){this.Emoji = e;return this;}
        @JsonProperty("value")
        public Builder setValue(Integer v){this.Value = v;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Dice build(){
            return new Dice(this);
        }
    }
}