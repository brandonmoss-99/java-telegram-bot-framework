package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = CallbackQuery.Builder.class)
public class CallbackQuery {
    private final String Id; // Unique ID for query
    private final User From; // Sender
    private final Message Message; // Message with the callback button that originated query
    private final String InlineMessageId; // ID of msg sent via bot in inline mode that originated query
    private final String ChatInstance; // Chat where msg with callback button was sent
    private final String Data; // Data associated with callback button. Bad client can send arbitrary data here
    private final String GameShortName; // Short name of a Game to be returned, serves as unique ID for the game

    private CallbackQuery(Builder builder){
        this.Id = builder.Id;
        this.From = builder.From;
        this.Message = builder.Message;
        this.InlineMessageId = builder.InlineMessageId;
        this.ChatInstance = builder.ChatInstance;
        this.Data = builder.Data;
        this.GameShortName = builder.GameShortName;
    }

    @JsonProperty("id")
    public String getId(){return Id;}
    @JsonProperty("from")
    public User getFrom(){return From;}
    @JsonProperty("message")
    public Message getMessage(){return Message;}
    @JsonProperty("inline_message_id")
    public String getInlineMessageId(){return InlineMessageId;}
    @JsonProperty("chat_instance")
    public String getChatInstance(){return ChatInstance;}
    @JsonProperty("data")
    public String getData(){return Data;}
    @JsonProperty("game_short_name")
    public String getGameShortName(){return GameShortName;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Id;
        private User From;
        private Message Message;
        private String InlineMessageId;
        private String ChatInstance;
        private String Data;
        private String GameShortName;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("id")
        public Builder setId(String id){this.Id = id;return this;}
        @JsonProperty("from")
        public Builder setFrom(User from){this.From = from;return this;}
        @JsonProperty("message")
        public Builder setMessage(Message msg){this.Message = msg;return this;}
        @JsonProperty("inline_message_id")
        public Builder setInlineMessageId(String imId){this.InlineMessageId = imId;return this;}
        @JsonProperty("chat_instance")
        public Builder setChatInstance(String chatInst){this.ChatInstance = chatInst;return this;}
        @JsonProperty("data")
        public Builder setData(String data){this.Data = data;return this;}
        @JsonProperty("game_short_name")
        public Builder setGameShortName(String gShN){this.GameShortName = gShN;return this;}

        public CallbackQuery build(){
            return new CallbackQuery(this);
        }
    }
}
