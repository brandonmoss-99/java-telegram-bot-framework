package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Update.Builder.class)
public class Update{
    // Final attributes. Once set, can't be changed
    private final Integer UpdateId;
    private final Message Message;

    private final Message EditedMessage;
    private final Message ChannelPost;
    private final Message EditedChannelPost;

    // Constructor. Set all attributes at once to those
    // Defined by the builder process. Object is always
    // fully built, never half built when getters called
    private Update(Builder builder){
        this.UpdateId = builder.UpdateId;
        this.Message = builder.Message;
        this.EditedMessage = builder.EditedMessage;
        this.ChannelPost = builder.ChannelPost;
        this.EditedChannelPost = builder.EditedChannelPost;
    }

    // Getter methods
    @JsonProperty("update_id")
    public Integer getUpdateId(){return UpdateId;}
    @JsonProperty("message")
    public Message getMessage(){return Message;}
    @JsonProperty("edited_message")
    public Message getEditedMessage(){return EditedMessage;}
    @JsonProperty("channel_post")
    public Message getChannelPost(){return ChannelPost;}
    @JsonProperty("edited_channel_post")
    public Message getEditedChannelPost(){return EditedChannelPost;}

    // Builder class
    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer UpdateId;
        private Message Message;
        private Message EditedMessage;
        private Message ChannelPost;
        private Message EditedChannelPost;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        // Setter methods
        @JsonProperty("update_id")
        public Builder setUpdateId(Integer id){
            this.UpdateId = id;
            return this;
        }

        @JsonProperty("message")
        public Builder setMessage(Message msg){
            this.Message = msg;
            return this;
        }

        @JsonProperty("edited_message")
        public Builder setEditedMessage(Message msg){
            this.EditedMessage = msg;
            return this;
        }

        @JsonProperty("channel_post")
        public Builder setChannelPost(Message msg){
            this.ChannelPost = msg;
            return this;
        }

        @JsonProperty("edited_channel_post")
        public Builder setEditedChannelPost(Message msg){
            this.EditedChannelPost = msg;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Update build(){
            return new Update(this);
        }
    }

}