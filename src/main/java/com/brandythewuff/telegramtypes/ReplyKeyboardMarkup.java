package com.brandythewuff.telegramtypes;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = ReplyKeyboardMarkup.Builder.class)
public class ReplyKeyboardMarkup {
    private final ArrayList<ArrayList<KeyboardButton>> Keyboard;
    private final Boolean ResizeKeyboard; // Requests clients to resize keyboard vertically for optimal fit (default false)
    private final Boolean OneTimeKeyboard; // Requests clients to hide keyboard as soon as used (default false)
    private final String InputFieldPlaceholder; // Placeholder to be shown in input field when active (1-64 chars)
    private final Boolean Selective; // Use if want to show keyboard to specific users only (Users @mentioned or message is reply)

    private ReplyKeyboardMarkup(Builder builder){
        this.Keyboard = builder.Keyboard;
        this.ResizeKeyboard = builder.ResizeKeyboard;
        this.OneTimeKeyboard = builder.OneTimeKeyboard;
        this.InputFieldPlaceholder = builder.InputFieldPlaceholder;
        this.Selective = builder.Selective;
    }

    @JsonProperty("keyboard")
    public ArrayList<ArrayList<KeyboardButton>> getKeyboard(){return Keyboard;}
    @JsonProperty("resize_keyboard")
    public Boolean getResizeKeyboard(){return ResizeKeyboard;}
    @JsonProperty("one_time_keyboard")
    public Boolean getOneTimeKeyboard(){return OneTimeKeyboard;}
    @JsonProperty("input_field_placeholder")
    public String getInputFieldPlaceholder(){return InputFieldPlaceholder;}
    @JsonProperty("selective")
    public Boolean getSelective(){return Selective;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private ArrayList<ArrayList<KeyboardButton>> Keyboard;
        private Boolean ResizeKeyboard;
        private Boolean OneTimeKeyboard;
        private String InputFieldPlaceholder;
        private Boolean Selective;

        public static Builder newInstance(ArrayList<ArrayList<KeyboardButton>> keyboard){
            return new Builder(keyboard);
        }

        private Builder(ArrayList<ArrayList<KeyboardButton>> keyboard){
            setKeyboard(keyboard);
        }

        @JsonProperty("keyboard")
        public Builder setKeyboard(ArrayList<ArrayList<KeyboardButton>> kb){this.Keyboard = kb;return this;}
        @JsonProperty("resize_keyboard")
        public Builder setResizeKeyboard(Boolean resizeKb){this.ResizeKeyboard = resizeKb;return this;}
        @JsonProperty("one_time_keyboard")
        public Builder setOneTimeKeyboard(Boolean oneTKb){this.OneTimeKeyboard = oneTKb;return this;}
        @JsonProperty("input_field_placeholder")
        public Builder setInputFieldPlaceholder(String placeH){this.InputFieldPlaceholder = placeH;return this;}
        @JsonProperty("selective")
        public Builder setSelective(Boolean selective){this.Selective = selective;return this;}

        public ReplyKeyboardMarkup build(){
            return new ReplyKeyboardMarkup(this);
        }
    }
}
