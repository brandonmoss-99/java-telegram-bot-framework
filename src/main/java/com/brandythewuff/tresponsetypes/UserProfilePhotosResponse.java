package com.brandythewuff.tresponsetypes;

import com.brandythewuff.telegramtypes.UserProfilePhotos;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = UserProfilePhotosResponse.Builder.class)
public class UserProfilePhotosResponse {
    private final UserProfilePhotos Result;
    private final Boolean Ok;

    private UserProfilePhotosResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods

    @JsonProperty("result")
    public UserProfilePhotos GetResult(){return Result;}

    /**
     * Get Ok status from response
     * @return true if Ok, otherwise false
     */
    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private UserProfilePhotos Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder SetResult(UserProfilePhotos result){
            this.Result = result;
            return this;
        }

        public Builder setOk(Boolean ok){
            this.Ok = ok;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public UserProfilePhotosResponse build(){
            return new UserProfilePhotosResponse(this);
        }
    }
}
