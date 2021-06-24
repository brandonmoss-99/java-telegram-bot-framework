package com.brandythewuff.tmethodtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = ForwardMessage.Builder.class)
public class ForwardMessage {
    private final Integer ChatId;
    private final Integer FromChatId;
    private final Boolean DisableNotifications;
    private final Integer MessageId;

    private ForwardMessage(Builder builder){
        this.ChatId = builder.ChatId;
        this.FromChatId = builder.FromChatId;
        this.DisableNotifications = builder.DisableNotifications;
        this.MessageId = builder.MessageId;
    }

    // Getter methods
    @JsonProperty("chat_id")
    public Integer getChatId(){return ChatId;}
    @JsonProperty("from_chat_id")
    public Integer getFromChatId(){return FromChatId;}
    @JsonProperty("disable_notifications")
    public Boolean getDisableNotifications(){return DisableNotifications;}
    @JsonProperty("message_id")
    public Integer getMessageId(){return MessageId;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer ChatId;
        private Integer FromChatId;
        private Boolean DisableNotifications;
        private Integer MessageId;

        public static Builder newInstance(Integer chatId, Integer fromChatId, Integer messageId){
            return new Builder(chatId, fromChatId, messageId);
        }

        private Builder(Integer chatId, Integer fromChatId, Integer messageId){
            this.ChatId = chatId;
            this.FromChatId = fromChatId;
            this.MessageId = messageId;
        }

        // Setter methods

        @JsonProperty("chat_id")
        public Builder setChatId(Integer chatId){
            this.ChatId = chatId;
            return this;
        }

        @JsonProperty("from_chat_id")
        public Builder setFromChatId(Integer fromCId){
            this.FromChatId = fromCId;
            return this;
        }

        @JsonProperty("disable_notifications")
        public Builder setDisableNotifications(Boolean disableNotifs){
            this.DisableNotifications = disableNotifs;
            return this;
        }

        @JsonProperty("message_id")
        public Builder setMessageId(Integer messageId){
            this.MessageId = messageId;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ForwardMessage build(){
            return new ForwardMessage(this);
        }
    }
}
