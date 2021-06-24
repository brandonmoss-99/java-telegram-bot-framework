package com.brandythewuff.tresponsetypes;

import com.brandythewuff.telegramtypes.StickerSet;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = StickerSetResponse.Builder.class)
public class StickerSetResponse {
    private final StickerSet Result;
    private final Boolean Ok;

    private StickerSetResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods

    @JsonProperty("result")
    public StickerSet GetResult(){return Result;}

    /**
     * Get Ok status from response
     * @return true if Ok, otherwise false
     */
    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private StickerSet Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder SetResult(StickerSet result){
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
        public StickerSetResponse build(){
            return new StickerSetResponse(this);
        }
    }
}
