package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;
import com.brandythewuff.telegramtypes.*;

@JsonDeserialize(builder = RestrictChatMember.Builder.class)
public class RestrictChatMember extends TMethod{
    private final Integer ChatId;
    private final Integer UserId;
    private final Integer UntilDate;
    private final ChatPermissions Permissions;

    private RestrictChatMember(Builder builder){
        url = "restrictChatMember";
        this.ChatId = builder.ChatId;
        this.UserId = builder.UserId;
        this.UntilDate = builder.UntilDate;
        this.Permissions = builder.Permissions;
    }

    // Getter methods

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
    @JsonProperty("user_id")
    public Integer getUserId(){return UserId;}
    @JsonProperty("until_date")
    public Integer getUntilDate(){return UntilDate;}
    @JsonProperty("permissions")
    public ChatPermissions getPermissions(){return Permissions;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer ChatId;
        private Integer UserId;
        private Integer UntilDate;
        private ChatPermissions Permissions;

        public static Builder newInstance(Integer cId, Integer uId, ChatPermissions p){
            return new Builder(cId, uId, p);
        }

        private Builder(Integer cId, Integer uId, ChatPermissions p){
            this.ChatId = cId;
            this.UserId = uId;
            this.Permissions = p;
        }

        @JsonProperty("chat_id")
        public Builder setChatId(Integer cId){
            this.ChatId = cId;
            return this;
        }

        @JsonProperty("user_id")
        public Builder setUserId(Integer uId){
            this.UserId = uId;
            return this;
        }

        @JsonProperty("until_date")
        public Builder setUntilDate(Integer uDate){
            this.UntilDate = uDate;
            return this;
        }

        @JsonProperty("permissions")
        public Builder setPermissions(ChatPermissions p){
            this.Permissions = p;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public RestrictChatMember build(){
            return new RestrictChatMember(this);
        }
    }
}
