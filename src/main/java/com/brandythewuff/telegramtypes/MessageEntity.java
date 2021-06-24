package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = MessageEntity.Builder.class)
public class MessageEntity{
    private final String Type;
    private final Integer Offset;
    private final Integer Length;
    private final String Url;
    private final User User;
    private final String Language;

    private MessageEntity(Builder builder){
        this.Type = builder.Type;
        this.Offset = builder.Offset;
        this.Length = builder.Length;
        this.Url = builder.Url;
        this.User = builder.User;
        this.Language = builder.Language;
    }

    // Getter methods

    @JsonProperty("type")
    public String getType(){return Type;}
    @JsonProperty("offset")
    public Integer getOffset(){return Offset;}
    @JsonProperty("length")
    public Integer getLength(){return Length;}
    @JsonProperty("url")
    public String getUrl(){return Url;}
    @JsonProperty("user")
    public User getUser(){return User;}
    @JsonProperty("language")
    public String getLanguage(){return Language;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Type;
        private Integer Offset;
        private Integer Length;
        private String Url;
        private User User;
        private String Language;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        public Builder setType(String type){this.Type = type;return this;}
        public Builder setOffset(Integer offset){this.Offset = offset;return this;}
        public Builder setLength(Integer length){this.Length = length;return this;}
        public Builder setUrl(String url){this.Url = url;return this;}
        public Builder setUser(User usr){this.User = usr;return this;}
        public Builder setLanguage(String lang){this.Language = lang;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public MessageEntity build(){
            return new MessageEntity(this);
        }
    }
}