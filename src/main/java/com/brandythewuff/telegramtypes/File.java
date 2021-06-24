package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = File.Builder.class)
public class File {
    private final String FileId;
    private final String FileUniqueId;
    private final Integer FileSize;
    private final String FilePath;

    private File(Builder builder){
        this.FileId = builder.FileId;
        this.FileUniqueId = builder.FileUniqueId;
        this.FileSize = builder.FileSize;
        this.FilePath = builder.FilePath;
    }

    // Getter methods

    @JsonProperty("file_id")
    public String getFileId(){return FileId;}
    @JsonProperty("file_unique_id")
    public String getFileUniqueId(){return FileUniqueId;}
    @JsonProperty("file_unique_id")
    public Integer getFileSize(){return FileSize;}
    @JsonProperty("file_path")
    public String getFilePath(){return FilePath;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String FileId;
        private String FileUniqueId;
        private Integer FileSize;
        private String FilePath;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("file_id")
        public Builder setFileId(String fId){this.FileId = fId;return this;}
        @JsonProperty("file_unique_id")
        public Builder setFileUniqueId(String fuId){this.FileUniqueId = fuId;return this;}
        @JsonProperty("file_unique_id")
        public Builder setFileSize(Integer fSize){this.FileSize = fSize;return this;}
        @JsonProperty("file_path")
        public Builder setFilePath(String fPath){this.FilePath = fPath;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public File build(){
            return new File(this);
        }
    }
}
