package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Chat.Builder.class)
public class Chat{
    private final Long Id;
    private final String Type;
    private final String Title;
    private final String Username;
    private final String FirstName;
    private final String LastName;
    //private final ChatPhoto Photo;
    private final String Bio;
    private final String Description;
    private final String InviteLink;
    private final Message PinnedMessage;
    //private final ChatPermissions Permissions;
    private final Integer SlowModeDelay;
    private final Integer MessageAutoDelete;
    private final String StickerSetName;
    private final Boolean CanSetStickerSet;
    private final Long LinkedChatId;
    //private final ChatLocation Location;

    private Chat(Builder builder){
        this.Id = builder.Id;
        this.Type = builder.Type;
        this.Title = builder.Title;
        this.Username = builder.Username;
        this.FirstName = builder.FirstName;
        this.LastName = builder.LastName;
        //this.Photo = builder.Photo;
        this.Bio = builder.Bio;
        this.Description = builder.Description;
        this.InviteLink = builder.InviteLink;
        this.PinnedMessage = builder.PinnedMessage;
        //this.Permissions = builder.Permissions;
        this.SlowModeDelay = builder.SlowModeDelay;
        this.MessageAutoDelete = builder.MessageAutoDelete;
        this.StickerSetName = builder.StickerSetName;
        this.CanSetStickerSet = builder.CanSetStickerSet;
        this.LinkedChatId = builder.LinkedChatId;
        //this.Location = builder.Location;
    }

    // Getter methods
    @JsonProperty("id")
    public Long getId(){return Id;}
    @JsonProperty("type")
    public String getType(){return Type;}
    @JsonProperty("title")
    public String getTitle(){return Title;}
    @JsonProperty("username")
    public String getUsername(){return Username;}
    @JsonProperty("first_name")
    public String getFirstName(){return FirstName;}
    @JsonProperty("last_name")
    public String getLastName(){return LastName;}
    //@JsonProperty("chat_photo")
    //public ChatPhoto getPhoto(){return Photo;}
    @JsonProperty("bio")
    public String getBio(){return Bio;}
    @JsonProperty("description")
    public String getDescription(){return Description;}
    @JsonProperty("invite_link")
    public String getInviteLink(){return InviteLink;}
    @JsonProperty("pinned_message")
    public Message getPinnedMessage(){return PinnedMessage;}
    //@JsonProperty("permissions")
    //public ChatPermissions getPermissions(){return Permissions;}
    @JsonProperty("slow_mode_delay")
    public Integer getSlowModeDelay(){return SlowModeDelay;}
    @JsonProperty("message_auto_delete")
    public Integer getMessageAutoDelete(){return MessageAutoDelete;}
    @JsonProperty("sticker_set_name")
    public String getStickerSetName(){return StickerSetName;}
    @JsonProperty("can_set_sticker_set")
    public Boolean getCanSetStickerSet(){return CanSetStickerSet;}
    @JsonProperty("linked_chat_id")
    public Long setLinkedChatId(){return LinkedChatId;}
    //@JsonProperty("location")
    //public ChatLocation setLocation(){return Location;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Long Id;
        private String Type;
        private String Title;
        private String Username;
        private String FirstName;
        private String LastName;
        //private ChatPhoto Photo;
        private String Bio;
        private String Description;
        private String InviteLink;
        private Message PinnedMessage;
        //private ChatPermissions Permissions;
        private Integer SlowModeDelay;
        private Integer MessageAutoDelete;
        private String StickerSetName;
        private Boolean CanSetStickerSet;
        private Long LinkedChatId;
        //private ChatLocation Location;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        // Setter methods
        @JsonProperty("id")
        public Builder setId(Long id){
            this.Id = id;
            return this;
        }

        @JsonProperty("type")
        public Builder setType(String type){
            this.Type = type; 
            return this;
        }

        @JsonProperty("title")
        public Builder setTitle(String title){
            this.Title = title;
            return this;
        }

        @JsonProperty("username")
        public Builder setUsername(String username){
            this.Username = username;
            return this;
        }

        @JsonProperty("first_name")
        public Builder setFirstName(String fname){
            this.FirstName = fname;
            return this;
        }

        @JsonProperty("last_name")
        public Builder setLastName(String lname){
            this.LastName = lname;
            return this;
        }
        
        //@JsonProperty("chat_photo")
        /*public Builder setChatPhoto(ChatPhoto photo){
            this.Photo = photo;
            return this;
        }*/

        @JsonProperty("bio")
        public Builder setBio(String bio){
            this.Bio = bio;
            return this;
        }

        @JsonProperty("description")
        public Builder setDescription(String desc){
            this.Description = desc;
            return this;
        }

        @JsonProperty("invite_link")
        public Builder setInviteLink(String invl){
            this.InviteLink = invl;
            return this;
        }

        @JsonProperty("pinned_message")
        public Builder setPinnedMessage(Message pmsg){
            this.PinnedMessage = pmsg;
            return this;
        }

        //@JsonProperty("permissions")
        /*public Builder setPermissions(ChatPermissions perms){
            this.Permissions = perms;
            return this;
        }*/

        @JsonProperty("slow_mode_delay")
        public Builder setSlowModeDelay(Integer delay){
            this.SlowModeDelay = delay;
            return this;
        }

        @JsonProperty("message_auto_delete")
        public Builder setMessageAutoDelete(Integer msgDelete){
            this.MessageAutoDelete = msgDelete;
            return this;
        }

        @JsonProperty("sticker_set_name")
        public Builder setStickerSetName(String sSetName){
            this.StickerSetName = sSetName;
            return this;
        }

        @JsonProperty("can_set_sticker_set")
        public Builder setCanSetStickerSet(Boolean cSetss){
            this.CanSetStickerSet = cSetss;
            return this;
        }

        @JsonProperty("linked_chat_id")
        public Builder setLinkedChatId(Long linkedChatId){
            this.LinkedChatId = linkedChatId;
            return this;
        }

        //@JsonProperty("location")
        /*public Builder setLocation(ChatLocation location){
            this.Location = location; 
            return this;
        }*/

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Chat build(){
            return new Chat(this);
        }
    }
}