package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = InlineKeyboardButton.Builder.class)
public class InlineKeyboardButton {
    // Must use exactly one of the optional fields (everything but Text)

    private final String Text; // label text on button
    private final String Url; // HTTP or tg:// url to be opened when button pressed
    //private final LoginUrl LoginUrl; // HTTP URL to automatically authorize user. Can be replacement for Telegram login widget
    private final String CallbackData; // Data to be sent in callback query to bot when button pressed. 1-64 bytes

    /*If set, pressing the button will prompt the user to select one of their chats, 
    open that chat and insert the bot's username and the specified inline query in the 
    input field. Can be empty, in which case just the bot's username will be inserted. 
    
    offers an easy way for users to start using your bot in inline mode when they are 
    currently in a private chat with it. Especially useful when combined with 
    switch_pm… actions – in this case the user will be automatically returned to the chat 
    they switched from, skipping the chat selection screen.*/
    private final String SwitchInlineQuery;
    
    /*If set, pressing the button will insert the bot's username and the specified 
    inline query in the current chat's input field. Can be empty, in which case 
    only the bot's username will be inserted. 
    
    offers a quick way for the user to open your bot in inline mode in the same 
    chat – good for selecting something from multiple options.*/
    private final String SwitchInlineQueryCurrentChat;
    //private final CallbackGame CallbackGame; // Description of the game that will be launched when the user presses the button. Must be first button in first row
    private final Boolean Pay; // True to send a pay button. Must be first button in first row

    private InlineKeyboardButton(Builder builder){
        this.Text = builder.Text;
        this.Url = builder.Url;
        this.CallbackData = builder.CallbackData;
        this.SwitchInlineQuery = builder.SwitchInlineQuery;
        this.SwitchInlineQueryCurrentChat = builder.SwitchInlineQueryCurrentChat;
        this.Pay = builder.Pay;
    }

    @JsonProperty("text")
    public String getText(){return Text;}
    @JsonProperty("url")
    public String getUrl(){return Url;}
    @JsonProperty("callback_data")
    public String getCallbackData(){return CallbackData;}
    @JsonProperty("switch_inline_query")
    public String getSwitchInlineQuery(){return SwitchInlineQuery;}
    @JsonProperty("switch_inline_query_current_chat")
    public String getSwitchInlineQueryCurrentChat(){return SwitchInlineQueryCurrentChat;}
    @JsonProperty("pay")
    public Boolean getPay(){return Pay;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Text;
        private String Url;
        private String CallbackData;
        private String SwitchInlineQuery;
        private String SwitchInlineQueryCurrentChat;
        private Boolean Pay;

        public static Builder newInstance(String text){
            return new Builder(text);
        }

        private Builder(String text){
            setText(text);
        }

        @JsonProperty("text")
        public Builder setText(String text){this.Text = text;return this;}
        @JsonProperty("url")
        public Builder setUrl(String url){this.Url = url;return this;}
        @JsonProperty("callback_data")
        public Builder setCallbackData(String cbData){this.CallbackData = cbData;return this;}
        @JsonProperty("switch_inline_query")
        public Builder setSwitchInlineQuery(String swILQ){this.SwitchInlineQuery = swILQ;return this;}
        @JsonProperty("switch_inline_query_current_chat")
        public Builder setSwitchInlineQueryCurrentChat(String swILQCC){this.SwitchInlineQueryCurrentChat = swILQCC;return this;}
        @JsonProperty("pay")
        public Builder setPay(Boolean pay){this.Pay = pay;return this;}

        public InlineKeyboardButton build(){
            return new InlineKeyboardButton(this);
        }
    }
}
