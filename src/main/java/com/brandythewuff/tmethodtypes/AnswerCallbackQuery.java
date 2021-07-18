package com.brandythewuff.tmethodtypes;

import java.util.HashMap;

import com.brandythewuff.InvalidParamsException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

public class AnswerCallbackQuery {
    private final String CallbackQueryId; // Unique ID for the query to be answered
    private final String Text; // Text of notification. 0-200 characters
    private final Boolean ShowAlert; // True will send alert to client instead of notification at top of chat screen
    private final String Url; // URL that will be opened by user's client
    private final Integer CacheTime; // Max time in seconds that results from callbackQuery are cached client-side

    private AnswerCallbackQuery(Builder builder){
        this.CallbackQueryId = builder.CallbackQueryId;
        this.Text = builder.Text;
        this.ShowAlert = builder.ShowAlert;
        this.Url = builder.Url;
        this.CacheTime = builder.CacheTime;
    }

    @JsonProperty("callback_query_id")
    public String getCallbackQueryId(){return CallbackQueryId;}
    @JsonProperty("text")
    public String getText(){return Text;}
    @JsonProperty("show_alert")
    public Boolean getShowAlert(){return ShowAlert;}
    @JsonProperty("url")
    public String getUrl(){return Url;}
    @JsonProperty("cache_time")
    public Integer getCacheTime(){return CacheTime;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String CallbackQueryId;
        private String Text;
        private Boolean ShowAlert;
        private String Url;
        private Integer CacheTime;

        public static Builder newInstance(String callbackQId){
            return new Builder(callbackQId);
        }

        private Builder(String callbackQId){
            setCallbackQueryId(callbackQId);
        }

        @JsonProperty("callback_query_id")
        public Builder setCallbackQueryId(String callbackQId){this.CallbackQueryId = callbackQId;return this;}
        @JsonProperty("text")
        public Builder setText(String t){this.Text = t;return this;}
        @JsonProperty("show_alert")
        public Builder setShowAlert(Boolean showAlert){this.ShowAlert = showAlert;return this;}
        @JsonProperty("url")
        public Builder setUrl(String url){this.Url = url;return this;}
        @JsonProperty("cache_time")
        public Builder setCacheTime(Integer cTime){this.CacheTime = cTime;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public AnswerCallbackQuery build() throws InvalidParamsException{
            HashMap<String, String> isValid = checkValid();
            if(isValid.get("valid") == "true"){
                return new AnswerCallbackQuery(this);
            }
            else{
                throw new InvalidParamsException(isValid.get("msg"));
            }
        }

        private HashMap<String, String> checkValid(){
            Boolean isValid = true;
            HashMap<String, String> result = new HashMap<String, String>();
            // Create StringBuilder with initial capacity 64 characters
            StringBuilder errorMsg = new StringBuilder(64);

            // Text must be between 0-200 characters if supplied
            if(this.Text != null && this.Text.length() > 200){
                errorMsg.append("Text must be between 0-200 characters long");
                isValid = false;
            }

            result.put("valid", Boolean.toString(isValid));
            result.put("msg", errorMsg.toString());
            return result;
        }
    }
}
