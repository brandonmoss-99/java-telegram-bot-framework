package com.brandythewuff.telegramtypes;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

public class InlineKeyboardMarkup {
    private final ArrayList<ArrayList<InlineKeyboardButton>> InlineKeyboard;

    private InlineKeyboardMarkup(Builder builder){
        this.InlineKeyboard = builder.InlineKeyboard;
    }

    @JsonProperty("inline_keyboard")
    public ArrayList<ArrayList<InlineKeyboardButton>> getInlineKeyboard(){return InlineKeyboard;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private ArrayList<ArrayList<InlineKeyboardButton>> InlineKeyboard;

        public static Builder newInstance(ArrayList<ArrayList<InlineKeyboardButton>> ilKeyboard){
            return new Builder(ilKeyboard);
        }

        private Builder(ArrayList<ArrayList<InlineKeyboardButton>> ilKeyboard){
            setInlineKeyboard(ilKeyboard);
        }

        public Builder setInlineKeyboard(ArrayList<ArrayList<InlineKeyboardButton>> ilKeyboard){this.InlineKeyboard = ilKeyboard;return this;}

        public InlineKeyboardMarkup build(){
            return new InlineKeyboardMarkup(this);
        }
    }
}
