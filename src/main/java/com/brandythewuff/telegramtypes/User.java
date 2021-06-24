package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = User.Builder.class)
public class User{
    private final Long Id;
    private final Boolean IsBot;
    private final String FirstName;
    private final String LastName;
    private final String Username;
    private final String LanguageCode;
    private final Boolean CanJoinGroups;
    private final Boolean CanReadAllGroupMessages;
    private final Boolean SupportsInlineQueries;

    private User(Builder builder){
        this.Id = builder.Id;
        this.IsBot = builder.IsBot;
        this.FirstName = builder.FirstName;
        this.LastName = builder.LastName;
        this.Username = builder.Username;
        this.LanguageCode = builder.LanguageCode;
        this.CanJoinGroups = builder.CanJoinGroups;
        this.CanReadAllGroupMessages = builder.CanReadAllGroupMessages;
        this.SupportsInlineQueries = builder.SupportsInlineQueries;
    }

    // Getter methods
    @JsonProperty("id")
    public long getId(){return Id;}
    @JsonProperty("is_bot")
    public Boolean getIsBot(){return IsBot;}
    @JsonProperty("can_join_groups")
    public Boolean getCanJoinGroups(){return CanJoinGroups;}
    @JsonProperty("can_read_all_group_messages")
    public Boolean getCanReadAllGroupMessages(){return CanReadAllGroupMessages;}
    @JsonProperty("supports_inline_queries")
    public Boolean getSupportsInlineQueries(){return SupportsInlineQueries;}
    @JsonProperty("first_name")
    public String getFirstName(){return FirstName;}
    @JsonProperty("last_name")
    public String getLastName(){return LastName;}
    @JsonProperty("username")
    public String getUsername(){return Username;}
    @JsonProperty("language_code")
    public String getLanguageCode(){return LanguageCode;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Long Id;
        private Boolean IsBot;
        private String FirstName;
        private String LastName;
        private String Username;
        private String LanguageCode;
        private Boolean CanJoinGroups;
        private Boolean CanReadAllGroupMessages;
        private Boolean SupportsInlineQueries;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        // Setter methods
        @JsonProperty("id")
        public Builder setId(Long id){
            this.Id = id; 
            return this;
        }

        @JsonProperty("is_bot")
        public Builder setIsBot(Boolean isBot){
            this.IsBot = isBot; 
            return this;
        }

        @JsonProperty("can_join_groups")
        public Builder setCanJoinGroups(Boolean canJoinGroups){
            this.CanJoinGroups = canJoinGroups;
            return this;
        }

        @JsonProperty("can_read_all_group_messages")
        public Builder setCanReadAllGroupMessages(Boolean canReadAllGroupMessages){
            this.CanReadAllGroupMessages = canReadAllGroupMessages;
            return this;
        }

        @JsonProperty("supports_inline_queries")
        public Builder setSupportsInlineQueries(Boolean supportsInlineQueries){
            this.SupportsInlineQueries = supportsInlineQueries;
            return this;
        }

        @JsonProperty("first_name")
        public Builder setFirstName(String firstName){
            this.FirstName = firstName;
            return this;
        }

        @JsonProperty("last_name")
        public Builder setLastName(String lastName){
            this.LastName = lastName;
            return this;
        }

        @JsonProperty("username")
        public Builder setUsername(String username){
            this.Username = username;
            return this;
        }

        @JsonProperty("language_code")
        public Builder setLanguageCode(String languageCode){
            this.LanguageCode = languageCode;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public User build(){
            return new User(this);
        }
    }
}