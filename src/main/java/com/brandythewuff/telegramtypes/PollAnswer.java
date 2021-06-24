package com.brandythewuff.telegramtypes;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = PollAnswer.Builder.class)
public class PollAnswer{
    private final String PollId;
    private final User User;
    private final ArrayList<Integer> OptionIds;

    private PollAnswer(Builder builder){
        this.PollId = builder.PollId;
        this.User = builder.User;
        this.OptionIds = builder.OptionIds;
    }

    // Getter methods

    public String getPollId(){return PollId;}
    public User getUser(){return User;}
    public ArrayList<Integer> getOptionIds(){return OptionIds;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String PollId;
        private User User;
        private ArrayList<Integer> OptionIds;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("poll_id")
        public Builder setPollId(String pid){this.PollId = pid;return this;}
        @JsonProperty("user")
        public Builder setUser(User usr){this.User = usr;return this;}
        @JsonProperty("option_ids")
        public Builder setOptionIds(ArrayList<Integer> ids){this.OptionIds = ids;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public PollAnswer build(){
            return new PollAnswer(this);
        }
    }
}
