package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = PhotoSize.Builder.class)
public class PhotoSize{
    private final Integer Width;
    private final Integer Height;
    private final String FileId;
    private final String FileUniqueId;
    private final String FileSize;

    private PhotoSize(Builder builder){
        this.Width = builder.Width;
        this.Height = builder.Height;
        this.FileId = builder.FileId;
        this.FileUniqueId = builder.FileUniqueId;
        this.FileSize = builder.FileSize;
    }

    // Getter methods
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
        private Integer Width;
        private Integer Height;
        private String FileId;
        private String FileUniqueId;
        private String FileSize;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

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
        public PhotoSize build(){
            return new PhotoSize(this);
        }
    }
}