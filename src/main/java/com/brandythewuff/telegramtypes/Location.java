package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Location.Builder.class)
public class Location{
    private final Float Longitude;
    private final Float Latitude;
    private final Float HorizontalAccuracy; // Radius of uncertainty for the location in meters (0-1500)
    private final Integer LivePeriod;
    private final Integer Heading; // Direction in which user is moving, in degrees (0-360)
    private final Integer ProximityAlertRadius; // Max distance for proximity alerts about approaching another chat member

    private Location(Builder builder){
        this.Longitude = builder.Longitude;
        this.Latitude = builder.Latitude;
        this.HorizontalAccuracy = builder.HorizontalAccuracy;
        this.LivePeriod = builder.LivePeriod;
        this.Heading = builder.Heading;
        this.ProximityAlertRadius = builder.ProximityAlertRadius;
    }

    // Getter methods

    @JsonProperty("longitude")
    public Float getLongitude(){return Longitude;}
    @JsonProperty("latitude")
    public Float getLatitude(){return Latitude;}
    @JsonProperty("horizontal_accuracy")
    public Float getHorizontalAccuracy(){return HorizontalAccuracy;}
    @JsonProperty("live_period")
    public Integer getLivePeriod(){return LivePeriod;}
    @JsonProperty("heading")
    public Integer getHeading(){return Heading;}
    @JsonProperty("proximity_alert_radius")
    public Integer getProximityAlertRadius(){return ProximityAlertRadius;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Float Longitude;
        private Float Latitude;
        private Float HorizontalAccuracy;
        private Integer LivePeriod;
        private Integer Heading;
        private Integer ProximityAlertRadius;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("longitude")
        public Builder setLongitude(Float lon){this.Longitude = lon;return this;}
        @JsonProperty("latitude")
        public Builder setLatitude(Float lat){this.Latitude = lat;return this;}
        @JsonProperty("horizontal_accuracy")
        public Builder setHorizontalAccuracy(Float acc){this.HorizontalAccuracy = acc;return this;}
        @JsonProperty("live_period")
        public Builder setLivePeriod(Integer lp){this.LivePeriod = lp;return this;}
        @JsonProperty("heading")
        public Builder setHeading(Integer h){this.Heading = h;return this;}
        @JsonProperty("proximity_alert_radius")
        public Builder setProximityAlertRadius(Integer r){this.ProximityAlertRadius = r;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Location build(){
            return new Location(this);
        }
    }
}