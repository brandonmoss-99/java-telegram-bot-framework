package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Venue.Builder.class)
public class Venue{
    private final Location Location;
    private final String Title;
    private final String Address;
    private final String FoursquareId;
    private final String FoursquareType;
    private final String GooglePlaceId;
    private final String GooglePlaceType;

    private Venue(Builder builder){
        this.Location = builder.Location;
        this.Title = builder.Title;
        this.Address = builder.Address;
        this.FoursquareId = builder.FoursquareId;
        this.FoursquareType = builder.FoursquareType;
        this.GooglePlaceId = builder.GooglePlaceId;
        this.GooglePlaceType = builder.GooglePlaceType;
    }

    // Getter methods

    @JsonProperty("location")
    public Location getLocation(){return Location;}
    @JsonProperty("title")
    public String getTitle(){return Title;}
    @JsonProperty("address")
    public String getAddress(){return Address;}
    @JsonProperty("four_square_id")
    public String getFoursquareId(){return FoursquareId;}
    @JsonProperty("four_square_type")
    public String getFoursquareType(){return FoursquareType;}
    @JsonProperty("google_place_id")
    public String getGooglePlaceId(){return GooglePlaceId;}
    @JsonProperty("google_place_type")
    public String getGooglePlaceType(){return GooglePlaceType;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Location Location;
        private String Title;
        private String Address;
        private String FoursquareId;
        private String FoursquareType;
        private String GooglePlaceId;
        private String GooglePlaceType;

        public static Builder newInstance(){
            return new Builder();
        }
    
        private Builder(){}
    
        
        public Builder setLocation(Location loc){this.Location = loc;return this;}
        public Builder setTitle(String title){this.Title = title;return this;}
        public Builder setAddress(String addr){this.Address = addr;return this;}
        public Builder setFoursquareId(String fsid){this.FoursquareId = fsid;return this;}
        public Builder setFoursquareType(String fst){this.FoursquareType = fst;return this;}
        public Builder setGooglePlaceId(String gid){this.GooglePlaceId = gid;return this;}
        public Builder setGooglePlaceType(String gt){this.GooglePlaceType = gt;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Venue build(){
            return new Venue(this);
        }
    }
}
