package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;

@JsonDeserialize(builder = UserProfilePhotos.Builder.class)
public class UserProfilePhotos {
    private final Integer TotalCount;
    private final ArrayList<ArrayList<PhotoSize>> Photos;

    private UserProfilePhotos(Builder builder){
        this.TotalCount = builder.TotalCount;
        this.Photos = builder.Photos;
    }

    // Getter methods

    @JsonProperty("total_count")
    public Integer getTotalCount(){return TotalCount;}
    @JsonProperty("photos")
    public ArrayList<ArrayList<PhotoSize>> getPhotos(){return Photos;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer TotalCount;
        private ArrayList<ArrayList<PhotoSize>> Photos;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("total_count")
        public Builder setTotalCount(Integer tCount){this.TotalCount = tCount;return this;}
        @JsonProperty("photos")
        public Builder setPhotos(ArrayList<ArrayList<PhotoSize>> photos){this.Photos = photos;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public UserProfilePhotos build(){
            return new UserProfilePhotos(this);
        }
    }
}
