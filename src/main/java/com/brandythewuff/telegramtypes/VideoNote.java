package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

public class VideoNote{
    private final Integer Duration;
    private final Integer Length;
    private final PhotoSize Thumb;
    private final String FileId;
    private final String FileUniqueId;
    private final String FileSize;

    private VideoNote(Builder builder){
        this.Duration = builder.Duration;
        this.Length = builder.Length;
        this.Thumb = builder.Thumb;
        this.FileId = builder.FileId;
        this.FileUniqueId = builder.FileUniqueId;
        this.FileSize = builder.FileSize;
    }

    // Getter methods

    @JsonProperty("duration")
    public Integer getDuration(){return Duration;}
    @JsonProperty("length")
    public Integer getLength(){return Length;}
    @JsonProperty("thumb")
    public PhotoSize getThumb(){return Thumb;}
    @JsonProperty("file_id")
    public String getFileId(){return FileId;}
    @JsonProperty("file_unique_id")
    public String getFileUniqueId(){return FileUniqueId;}
    @JsonProperty("file_size")
    public String getFileSize(){return FileSize;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer Duration;
        private Integer Length;
        private PhotoSize Thumb;
        private String FileId;
        private String FileUniqueId;
        private String FileSize;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("duration")
        public Builder setDuration(Integer d){this.Duration = d;return this;}
        @JsonProperty("length")
        public Builder setLength(Integer l){this.Length = l;return this;}
        @JsonProperty("thumb")
        public Builder setThumb(PhotoSize photo){this.Thumb = photo;return this;}
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
        public VideoNote build(){
            return new VideoNote(this);
        }
    }
}
