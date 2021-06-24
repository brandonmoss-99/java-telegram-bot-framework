package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

public class ProximityAlertTriggered{
    private final User Traveler;
    private final User Watcher;
    private final Integer Distance;

    private ProximityAlertTriggered(Builder builder){
        this.Traveler = builder.Traveler;
        this.Watcher = builder.Watcher;
        this.Distance = builder.Distance;
    }

    // Getter methods

    @JsonProperty("traveler")
    public User getTraveler(){return Traveler;}
    @JsonProperty("watcher")
    public User getWatcher(){return Watcher;}
    @JsonProperty("distance")
    public Integer getDistance(){return Distance;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private User Traveler;
        private User Watcher;
        private Integer Distance;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("traveler")
        public Builder setTraveler(User t){this.Traveler = t;return this;}
        @JsonProperty("watcher")
        public Builder setWatcher(User w){this.Watcher = w;return this;}
        @JsonProperty("distance")
        public Builder setDistance(Integer d){this.Distance = d;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ProximityAlertTriggered build(){
            return new ProximityAlertTriggered(this);
        }
    }
}
