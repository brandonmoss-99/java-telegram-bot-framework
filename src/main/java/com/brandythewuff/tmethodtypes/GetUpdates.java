package com.brandythewuff.tmethodtypes;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = GetUpdates.Builder.class)
public class GetUpdates{
    private final Integer Offset;
    private final Integer Limit;
    private final Integer Timeout;
    private final ArrayList<String> AllowedUpdates;

    private GetUpdates(Builder builder){
        this.Offset = builder.Offset;
        this.Limit = builder.Limit;
        this.Timeout = builder.Timeout;
        this.AllowedUpdates = builder.AllowedUpdates;
    }

    // Getter methods
    
    public Integer getOffset(){return Offset;}
    public Integer getLimit(){return Limit;}
    public Integer getTimeout(){return Timeout;}
    public ArrayList<String> getAllowedUpdates(){return AllowedUpdates;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer Offset;
        private Integer Limit;
        private Integer Timeout;
        private ArrayList<String> AllowedUpdates;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        // Setter methods

        @JsonProperty("offset")
        public Builder setOffset(int offset){this.Offset = offset;return this;}
        @JsonProperty("limit")
        public Builder setLimit(int limit){this.Limit = limit;return this;}
        @JsonProperty("timeout")
        public Builder setTimeout(int timeout){this.Timeout = timeout;return this;}
        @JsonProperty("allowed_updates")
        public Builder setAllowedUpdates(ArrayList<String> allowedUpdates){this.AllowedUpdates = allowedUpdates;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public GetUpdates build(){
            return new GetUpdates(this);
        }
    }
}