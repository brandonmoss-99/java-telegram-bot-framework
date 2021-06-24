package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = PollOption.Builder.class)
public class PollOption{
    private final String Text;
    private final Integer VoterCount;

    private PollOption(Builder builder){
        this.Text = builder.Text;
        this.VoterCount = builder.VoterCount;
    }

    // Getter methods

    @JsonProperty("text")
    public String getText(){return Text;}
    @JsonProperty("voter_count")
    public Integer getVoterCount(){return VoterCount;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Text;
        private Integer VoterCount;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("text")
        public Builder setText(String t){this.Text = t;return this;}
        @JsonProperty("voter_count")
        public Builder setVoterCount(Integer vc){this.VoterCount = vc;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public PollOption build(){
            return new PollOption(this);
        }
    }
}
