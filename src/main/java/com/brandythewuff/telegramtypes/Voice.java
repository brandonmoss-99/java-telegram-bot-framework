package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

public class Voice{
    private final Integer Duration;
    private final String MimeType;
    private final String FileId;
    private final String FileUniqueId;
    private final String FileSize;

    private Voice(Builder builder){
        this.Duration = builder.Duration;
        this.MimeType = builder.MimeType;
        this.FileId = builder.FileId;
        this.FileUniqueId = builder.FileUniqueId;
        this.FileSize = builder.FileSize;
    }

    // Getter methods

    @JsonProperty("duration")
    public Integer getDuration(){return Duration;}
    @JsonProperty("mime_type")
    public String getMimeType(){return MimeType;}
    @JsonProperty("file_id")
    public String getFileId(){return FileId;}
    @JsonProperty("file_unique_id")
    public String getFileUniqueId(){return FileUniqueId;}
    @JsonProperty("file_size")
    public String getFileSize(){return FileSize;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer Duration;
        private String MimeType;
        private String FileId;
        private String FileUniqueId;
        private String FileSize;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("duration")
        public void setDuration(Integer d){this.Duration = d;}
        @JsonProperty("mime_type")
        public void setMimeType(String mtype){this.MimeType = mtype;}
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
        public Voice build(){
            return new Voice(this);
        }
    }
}