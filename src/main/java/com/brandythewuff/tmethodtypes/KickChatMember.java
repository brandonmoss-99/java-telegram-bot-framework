package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = KickChatMember.Builder.class)
public class KickChatMember extends TMethod {
    private final Integer ChatId;
    private final Integer UserId;
    private final Integer UntilDate;
    private final Boolean RevokeMessages;

    private KickChatMember(Builder builder){
        url = "kickChatMember";
        this.ChatId = builder.ChatId;
        this.UserId = builder.UserId;
        this.UntilDate = builder.UntilDate;
        this.RevokeMessages = builder.RevokeMessages;
    }

    // Getter methods
    
    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
    @JsonProperty("user_id")
    public Integer getUserId(){return UserId;}
    @JsonProperty("until_date")
    public Integer getUntilDate(){return UntilDate;}
    @JsonProperty("revoke_messages")
    public Boolean getRevokeMessages(){return RevokeMessages;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer ChatId;
        private Integer UserId;
        private Integer UntilDate;
        private Boolean RevokeMessages;

        public static Builder newInstance(Integer cId, Integer uId){
            return new Builder(cId, uId);
        }

        private Builder(Integer cId, Integer uId){
            this.ChatId = cId;
            this.UserId = uId;
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

        @JsonProperty("revoke_messages")
        public Builder setRevokeMessages(Boolean rMessages){
            this.RevokeMessages = rMessages;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public KickChatMember build(){
            return new KickChatMember(this);
        }
    }
}
