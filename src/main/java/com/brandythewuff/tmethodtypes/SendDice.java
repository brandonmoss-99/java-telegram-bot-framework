package com.brandythewuff.tmethodtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = SendDice.Builder.class)
public class SendDice {
    private final Integer ChatId;
    private final String Emoji;
    private final Boolean DisableNotification;
    private final Integer ReplyToMessageId;
    private final Boolean AllowSendingWithoutReply;

    private SendDice(Builder builder){
        this.ChatId = builder.ChatId;
        this.Emoji = builder.Emoji;
        this.DisableNotification = builder.DisableNotification;
        this.ReplyToMessageId = builder.ReplyToMessageId;
        this.AllowSendingWithoutReply = builder.AllowSendingWithoutReply;
    }

    // Getter methods

    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
    @JsonProperty("emoji")
    public String getEmoji(){return Emoji;}
    @JsonProperty("disable_notification")
    public Boolean getDisableNotification(){return DisableNotification;}
    @JsonProperty("reply_to_message_id")
    public Integer getReplyToMessageId(){return ReplyToMessageId;}
    @JsonProperty("allow_sending_without_reply")
    public Boolean getAllowSendingWithoutReply(){return AllowSendingWithoutReply;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer ChatId;
        private String Emoji;
        private Boolean DisableNotification;
        private Integer ReplyToMessageId;
        private Boolean AllowSendingWithoutReply;
        
        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("chat_id")
        public Builder setChatId(Integer cId){this.ChatId = cId;return this;}
        @JsonProperty("emoji")
        public Builder setEmoji(String e){this.Emoji = e;return this;}
        @JsonProperty("disable_notification")
        public Builder setDisableNotification(Boolean disNotifs){this.DisableNotification = disNotifs;return this;}
        @JsonProperty("reply_to_message_id")
        public Builder setReplyToMessageId(Integer rtId){this.ReplyToMessageId = rtId;return this;}
        @JsonProperty("allow_sending_without_reply")
        public Builder setAllowSendingWithoutReply(Boolean sWithoutReply){this.AllowSendingWithoutReply = sWithoutReply;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public SendDice build(){
            return new SendDice(this);
        }
    }
}
