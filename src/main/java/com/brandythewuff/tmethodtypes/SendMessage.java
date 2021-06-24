package com.brandythewuff.tmethodtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;

import com.brandythewuff.IMethodType;
import com.brandythewuff.telegramtypes.*;

@JsonDeserialize(builder = SendMessage.Builder.class)
public class SendMessage{
    //private String Chat_id_string;
    private final Long ChatIdInt;
    private final String Text;
    private final String ParseMode;
    private final ArrayList<MessageEntity> Entities;
    private final Boolean DisableWebPagePreview;
    private final Boolean DisableNotification;
    private final Integer ReplyToMessageId;
    private final Boolean AllowSendingWithoutReply;
    //private final InlineKeyboardMarkup ReplyMarkupInlineKeyboardMarkup;
    //private final InlineKeyboardMarkup ReplyMarkupReplyKeyboardMarkup;
    //private final ReplyKeyboardRemove ReplyMarkupReplyKeyboardRemove;
    //private final ForceReply ReplyMarkupForceReply;

    private SendMessage(Builder builder){
        this.ChatIdInt = builder.ChatIdInt;
        this.Text = builder.Text;
        this.ParseMode = builder.ParseMode;
        this.Entities = builder.Entities;
        this.DisableWebPagePreview = builder.DisableWebPagePreview;
        this.DisableNotification = builder.DisableNotification;
        this.ReplyToMessageId = builder.ReplyToMessageId;
        this.AllowSendingWithoutReply = builder.AllowSendingWithoutReply;
        //this.ReplyMarkupInlineKeyboardMarkup = builder.ReplyMarkupInlineKeyboardMarkup;
        //this.ReplyMarkupReplyKeyboardMarkup = builder.ReplyMarkupReplyKeyboardMarkup;
        //this.ReplyMarkupReplyKeyboardRemove = builder.ReplyMarkupReplyKeyboardRemove;
        //this.ReplyMarkupForceReply = builder.ReplyMarkupForceReply;
    }

    // Getter methods
    @JsonProperty("chat_id")
    public Long getChatIdInt(){return ChatIdInt;}
    @JsonProperty("text")
    public String getText(){return Text;}
    @JsonProperty("parse_mode")
    public String getParseMode(){return ParseMode;}
    @JsonProperty("entities")
    public ArrayList<MessageEntity> getEntities(){return Entities;}
    @JsonProperty("disable_web_page_preview")
    public Boolean getDisableWebPagePreview(){return DisableWebPagePreview;}
    @JsonProperty("disable_notification")
    public Boolean getDisableNotification(){return DisableNotification;}
    @JsonProperty("reply_to_message_id")
    public Integer getReplyToMessageId(){return ReplyToMessageId;}
    @JsonProperty("allow_sending_without_reply")
    public Boolean getAllowSendingWithoutReply(){return AllowSendingWithoutReply;}
    //public InlineKeyboardMarkup getReplyMarkupInlineKeyboardMarkup(){return ReplyMarkupInlineKeyboardMarkup;}
    //public InlineKeyboardMarkup getReplyMarkupReplyKeyboardMarkup(){return ReplyMarkupReplyKeyboardMarkup;}
    //public InlineKeyboardMarkup getReplyMarkupReplyKeyboardRemove(){return ReplyMarkupReplyKeyboardRemove;}
    //public InlineKeyboardMarkup getReplyMarkupForceReply(){return ReplyMarkupForceReply;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        //private String Chat_id_string;
        private Long ChatIdInt;
        private String Text;
        private String ParseMode;
        private ArrayList<MessageEntity> Entities;
        private Boolean DisableWebPagePreview;
        private Boolean DisableNotification;
        private Integer ReplyToMessageId;
        private Boolean AllowSendingWithoutReply = null;
        //private InlineKeyboardMarkup ReplyMarkupInlineKeyboardMarkup;
        //private InlineKeyboardMarkup ReplyMarkupReplyKeyboardMarkup;
        //private ReplyKeyboardRemove ReplyMarkupReplyKeyboardRemove;
        //private ForceReply ReplyMarkupReplyKeyboardRemove;

        public static Builder newInstance(Long id, String text){
            return new Builder(id, text);
        }

        private Builder(Long id, String text){
            this.ChatIdInt = id;
            this.Text = text;
        }

        // Setter methods
        @JsonProperty("chat_id")
        public Builder setChatIdInt(Long chatIdInt){
            this.ChatIdInt = chatIdInt;
            return this;
        }

        @JsonProperty("text")
        public Builder setText(String text){
            this.Text = text;
            return this;
        }

        @JsonProperty("parse_mode")
        public Builder setParseMode(String pm){
            this.ParseMode = pm;
            return this;
        }

        @JsonProperty("entities")
        public Builder setEntities(ArrayList<MessageEntity> entities){
            this.Entities = entities;
            return this;
        }

        @JsonProperty("disable_web_page_preview")
        public Builder setDisableWebPagePreview(Boolean disablewpp){
            this.DisableWebPagePreview = disablewpp;
            return this;
        }

        @JsonProperty("disable_notification")
        public Builder setDisableNotification(Boolean disablen){
            this.DisableNotification = disablen;
            return this;
        }

        @JsonProperty("reply_to_message_id")
        public Builder setReplyToMessageId(Integer rtmid){
            this.ReplyToMessageId = rtmid;
            return this;
        }

        @JsonProperty("allow_sending_without_reply")
        public Builder setAllowSendingWithoutReply(Boolean swr){
            this.AllowSendingWithoutReply = swr;
            return this;
        }

        /*@JsonProperty("reply_markup_inline_keyboard_markup")
        public Builder setReplyMarkupInlineKeyboardMarkup(InlineKeyboardMarkup mInlineMarkup){
            this.ReplyMarkupInlineKeyboardMarkup = mInlineMarkup;
            return this;
        }*/

        /*@JsonProperty("reply_markup_reply_keyboard_markup")
        public Builder setReplyMarkupReplyKeyboardMarkup(InlineKeyboardMarkup mReplyMarkup){
            this.ReplyMarkupInlineKeyboardMarkup = mReplyMarkup;
            return this;
        }*/

        /*@JsonProperty("reply_markup_reply_keyboard_remove")
        public Builder setReplyMarkupReplyKeyboardRemove(InlineKeyboardMarkup mReplyRemove){
            this.ReplyMarkupInlineKeyboardMarkup = mReplyRemove;
            return this;
        }*/

        /*@JsonProperty("reply_markup_force_reply")
        public Builder setReplyMarkupReplyKeyboardRemove(ForceReply mReplyRemove){
            this.ReplyMarkupReplyKeyboardRemove = mReplyRemove;
            return this;
        }*/

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public SendMessage build(){
            return new SendMessage(this);
        }
    }
}