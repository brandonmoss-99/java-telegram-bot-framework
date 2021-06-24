package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Sticker.Builder.class)
public class Sticker{
    private final Boolean IsAnimated;
    private final PhotoSize Thumb;
    private final String Emoji;
    private final String SetName;
    private final MaskPosition MaskPosition;
    private final Integer Width;
    private final Integer Height;
    private final String FileId;
    private final String FileUniqueId;
    private final String FileSize;

    private Sticker(Builder builder){
        this.IsAnimated = builder.IsAnimated;
        this.Thumb = builder.Thumb;
        this.Emoji = builder.Emoji;
        this.SetName = builder.SetName;
        this.MaskPosition = builder.MaskPosition;
        this.Width = builder.Width;
        this.Height = builder.Height;
        this.FileId = builder.FileId;
        this.FileUniqueId = builder.FileUniqueId;
        this.FileSize = builder.FileSize;
    }

    // Getter methods


    @JsonProperty("is_animated")
    public Boolean getIsAnimated(){return IsAnimated;}
    @JsonProperty("thumb")
    public PhotoSize getThumb(){return Thumb;}
    @JsonProperty("emoji")
    public String getEmoji(){return Emoji;}
    @JsonProperty("set_name")
    public String getSetName(){return SetName;}
    @JsonProperty("mask_position")
    public MaskPosition getMaskPosition(){return MaskPosition;}
    @JsonProperty("width")
    public Integer getWidth(){return Width;}
    @JsonProperty("height")
    public Integer getHeight(){return Height;}
    @JsonProperty("file_id")
    public String getFileId(){return FileId;}
    @JsonProperty("file_unique_id")
    public String getFileUniqueId(){return FileUniqueId;}
    @JsonProperty("file_size")
    public String getFileSize(){return FileSize;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Boolean IsAnimated;
        private PhotoSize Thumb;
        private String Emoji;
        private String SetName;
        private MaskPosition MaskPosition;
        private Integer Width;
        private Integer Height;
        private String FileId;
        private String FileUniqueId;
        private String FileSize;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("is_animated")
        public Builder setIsAnimated(Boolean animated){
            this.IsAnimated = animated;
            return this;
        }

        @JsonProperty("thumb")
        public Builder setThumb(PhotoSize photo){
            this.Thumb = photo;
            return this;
        }

        @JsonProperty("emoji")
        public Builder setEmoji(String emoji){
            this.Emoji = emoji;
            return this;
        }

        @JsonProperty("set_name")
        public Builder setSetName(String setName){
            this.SetName = setName;
            return this;
        }

        @JsonProperty("mask_position")
        public Builder setMaskPosition(MaskPosition maskPosition){
            this.MaskPosition = maskPosition;
            return this;
        }

        @JsonProperty("width")
        public Builder setWidth(Integer w){
            this.Width = w;
            return this;
        }

        @JsonProperty("height")
        public Builder setHeight(Integer h){
            this.Height = h;
            return this;
        }

        @JsonProperty("file_id")
        public Builder setFileId(String fileId){
            this.FileId = fileId;
            return this;
        }

        @JsonProperty("file_unique_id")
        public Builder setFileUniqueId(String uId){
            this.FileUniqueId = uId;
            return this;
        }

        @JsonProperty("file_size")
        public Builder setFileSize(String fSize){
            this.FileSize = fSize;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Sticker build(){
            return new Sticker(this);
        }
    }
}