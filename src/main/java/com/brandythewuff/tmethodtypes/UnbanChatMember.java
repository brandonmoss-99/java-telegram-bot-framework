package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;


@JsonDeserialize(builder = UnbanChatMember.Builder.class)
public class UnbanChatMember extends TMethod{
    private final Integer ChatId;
    private final Integer UserId;
    private final Boolean OnlyIfBanned;

    private UnbanChatMember(Builder builder){
        url = "unbanChatMember";
        this.ChatId = builder.ChatId;
        this.UserId = builder.UserId;
        this.OnlyIfBanned = builder.OnlyIfBanned;
    }

    // Getter methods

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
    @JsonProperty("user_id")
    public Integer getUserId(){return UserId;}
    @JsonProperty("only_if_banned")
    public Boolean getOnlyIfBanned(){return OnlyIfBanned;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer ChatId;
        private Integer UserId;
        private Boolean OnlyIfBanned;

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

        @JsonProperty("only_if_banned")
        public Builder setRevokeMessages(Boolean ifBanned){
            this.OnlyIfBanned = ifBanned;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public UnbanChatMember build(){
            return new UnbanChatMember(this);
        }
    }
}
