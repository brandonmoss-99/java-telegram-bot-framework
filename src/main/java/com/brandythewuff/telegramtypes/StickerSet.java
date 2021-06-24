package com.brandythewuff.telegramtypes;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = StickerSet.Builder.class)
public class StickerSet {
    private final String Name;
    private final String Title;
    private final Boolean IsAnimated;
    private final Boolean ContainsMasks;
    private final ArrayList<Sticker> Stickers;
    private final PhotoSize Thumb;

    private StickerSet(Builder builder){
        this.Name = builder.Name;
        this.Title = builder.Title;
        this.IsAnimated = builder.IsAnimated;
        this.ContainsMasks = builder.ContainsMasks;
        this.Stickers = builder.Stickers;
        this.Thumb = builder.Thumb;
    }

    // Getter methods

    @JsonProperty("name")
    public String getName(){return Name;}
    @JsonProperty("title")
    public String getTitle(){return Title;}
    @JsonProperty("is_animated")
    public Boolean getIsAnimated(){return IsAnimated;}
    @JsonProperty("contains_masks")
    public Boolean getContainsMasks(){return ContainsMasks;}
    @JsonProperty("stickers")
    public ArrayList<Sticker> getStickers(){return Stickers;}
    @JsonProperty("thumb")
    public PhotoSize getThumb(){return Thumb;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Name;
        private String Title;
        private Boolean IsAnimated;
        private Boolean ContainsMasks;
        private ArrayList<Sticker> Stickers;
        private PhotoSize Thumb;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("name")
        public Builder setName(String name){this.Name = name;return this;}
        @JsonProperty("title")
        public Builder setTitle(String title){this.Title = title;return this;}
        @JsonProperty("is_animated")
        public Builder setIsAnimated(Boolean isAnim){this.IsAnimated = isAnim;return this;}
        @JsonProperty("contains_masks")
        public Builder setContainsMasks(Boolean cMasks){this.ContainsMasks = cMasks;return this;}
        @JsonProperty("stickers")
        public Builder setStickers(ArrayList<Sticker> stickers){this.Stickers = stickers;return this;}
        @JsonProperty("thumb")
        public Builder setThumb(PhotoSize thumb){this.Thumb = thumb;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public StickerSet build(){
            return new StickerSet(this);
        }
    }
}
