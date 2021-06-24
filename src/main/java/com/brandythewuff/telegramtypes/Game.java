package com.brandythewuff.telegramtypes;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Game.Builder.class)
public class Game{
    private final String Title; // Title of the game
    private final String Description; // Description of the game
    private final ArrayList<PhotoSize> Photo; // Photo displayed in the game message in chats
    private final String Text; // Brief description of game/high scores in game message (0-4096 characters)
    private final ArrayList<MessageEntity> TextEntities; // Special entities that appear in Text
    private final Animation Animation; // Animation displayed in the game message in chats

    private Game(Builder builder){
        this.Title = builder.Title;
        this.Description = builder.Description;
        this.Photo = builder.Photo;
        this.Text = builder.Text;
        this.TextEntities = builder.TextEntities;
        this.Animation = builder.Animation;
    }

    // Getter methods

    @JsonProperty("title")
    public String getTitle(){return Title;}
    @JsonProperty("description")
    public String getDescription(){return Description;}
    @JsonProperty("photo")
    public ArrayList<PhotoSize> getPhoto(){return Photo;}
    @JsonProperty("text")
    public String getText(){return Text;}
    @JsonProperty("text_entities")
    public ArrayList<MessageEntity> getTextEntities(){return TextEntities;}
    @JsonProperty("animation")
    public Animation getAnimation(){return Animation;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Title;
        private String Description;
        private ArrayList<PhotoSize> Photo;
        private String Text;
        private ArrayList<MessageEntity> TextEntities;
        private Animation Animation;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        public Builder setTitle(String title){this.Title = title;return this;}
        public Builder setDescription(String desc){this.Description = desc;return this;}
        public Builder setPhoto(ArrayList<PhotoSize> photo){this.Photo = photo;return this;}
        public Builder setText(String text){this.Text = text;return this;}
        public Builder setTextEntity(ArrayList<MessageEntity> txte){this.TextEntities = txte;return this;}
        public Builder setAnimation(Animation anim){this.Animation = anim;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Game build(){
            return new Game(this);
        }
    }
}