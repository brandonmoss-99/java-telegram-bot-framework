package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = ChatMember.Builder.class)
public class ChatMember {
    private final User User;
    private final String Status;
    private final String CustomTitle;
    private final Boolean IsAnonymous;
    private final Boolean CanBeEdited;
    private final Boolean CanManageChat;
    private final Boolean CanPostMessages;
    private final Boolean CanEditMessages;
    private final Boolean CanDeleteMessages;
    private final Boolean CanManageVoiceChats;
    private final Boolean CanRestrictMembers;
    private final Boolean CanPromoteMembers;
    private final Boolean CanChangeInfo;
    private final Boolean CanInviteUsers;
    private final Boolean CanPinMessages;
    private final Boolean IsMember;
    private final Boolean CanSendMessages;
    private final Boolean CanSendMediaMessages;
    private final Boolean CanSendPolls;
    private final Boolean CanSendOtherMessages;
    private final Boolean CanAddWebPagePreviews;
    private final Integer UntilDate;

    private ChatMember(Builder builder){
        this.User = builder.User;
        this.Status = builder.Status;
        this.CustomTitle = builder.CustomTitle;
        this.IsAnonymous = builder.IsAnonymous;
        this.CanBeEdited = builder.CanBeEdited;
        this.CanManageChat = builder.CanManageChat;
        this.CanPostMessages = builder.CanPostMessages;
        this.CanEditMessages = builder.CanEditMessages;
        this.CanDeleteMessages = builder.CanDeleteMessages;
        this.CanManageVoiceChats = builder.CanManageVoiceChats;
        this.CanRestrictMembers = builder.CanRestrictMembers;
        this.CanPromoteMembers = builder.CanPromoteMembers;
        this.CanChangeInfo = builder.CanChangeInfo;
        this.CanInviteUsers = builder.CanInviteUsers;
        this.CanPinMessages = builder.CanPinMessages;
        this.IsMember = builder.IsMember;
        this.CanSendMessages = builder.CanSendMessages;
        this.CanSendMediaMessages = builder.CanSendMediaMessages;
        this.CanSendPolls = builder.CanSendPolls;
        this.CanSendOtherMessages = builder.CanSendOtherMessages;
        this.CanAddWebPagePreviews = builder.CanAddWebPagePreviews;
        this.UntilDate = builder.UntilDate;
    }

    // Getter methods
    
    @JsonProperty("user")
    public User getUser(){return User;}
    @JsonProperty("status")
    public String getStatus(){return Status;}
    @JsonProperty("custom_title")
    public String getCustomTitle(){return CustomTitle;}
    @JsonProperty("until_date")
    public Integer getUntilDate(){return UntilDate;}
    @JsonProperty("is_anonymous")
    public Boolean getIsAnonymous(){return IsAnonymous;}
    @JsonProperty("can_be_edited")
    public Boolean getCanBeEdited(){return CanBeEdited;}
    @JsonProperty("can_manage_chat")
    public Boolean getCanManageChat(){return CanManageChat;}
    @JsonProperty("can_post_messages")
    public Boolean getCanPostMessages(){return CanPostMessages;}
    @JsonProperty("can_edit_messages")
    public Boolean getCanEditMessages(){return CanEditMessages;}
    @JsonProperty("can_delete_messages")
    public Boolean getCanDeleteMessages(){return CanDeleteMessages;}
    @JsonProperty("can_manage_voice_chats")
    public Boolean getCanManageVoiceChats(){return CanManageVoiceChats;}
    @JsonProperty("can_restrict_members")
    public Boolean getCanRestrictMembers(){return CanRestrictMembers;}
    @JsonProperty("can_promote_members")
    public Boolean getCanPromoteMembers(){return CanPromoteMembers;}
    @JsonProperty("can_change_info")
    public Boolean getCanChangeInfo(){return CanChangeInfo;}
    @JsonProperty("can_invite_users")
    public Boolean getCanInviteUsers(){return CanInviteUsers;}
    @JsonProperty("can_pin_messages")
    public Boolean getCanPinMessages(){return CanPinMessages;}
    @JsonProperty("is_member")
    public Boolean getIsMember(){return IsMember;}
    @JsonProperty("can_send_messages")
    public Boolean getCanSendMessages(){return CanSendMessages;}
    @JsonProperty("can_send_media_messages")
    public Boolean getCanSendMediaMessages(){return CanSendMediaMessages;}
    @JsonProperty("can_send_polls")
    public Boolean getCanSendPolls(){return CanSendPolls;}
    @JsonProperty("can_send_other_messages")
    public Boolean getCanSendOtherMessages(){return CanSendOtherMessages;}
    @JsonProperty("can_add_web_page_previews")
    public Boolean getCanAddWebPagePreviews(){return CanAddWebPagePreviews;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private User User;
        private String Status;
        private String CustomTitle;
        private Boolean IsAnonymous;
        private Boolean CanBeEdited;
        private Boolean CanManageChat;
        private Boolean CanPostMessages;
        private Boolean CanEditMessages;
        private Boolean CanDeleteMessages;
        private Boolean CanManageVoiceChats;
        private Boolean CanRestrictMembers;
        private Boolean CanPromoteMembers;
        private Boolean CanChangeInfo;
        private Boolean CanInviteUsers;
        private Boolean CanPinMessages;
        private Boolean IsMember;
        private Boolean CanSendMessages;
        private Boolean CanSendMediaMessages;
        private Boolean CanSendPolls;
        private Boolean CanSendOtherMessages;
        private Boolean CanAddWebPagePreviews;
        private Integer UntilDate;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("user")
        public Builder setUser(User user){this.User = user;return this;}
        @JsonProperty("status")
        public Builder setStatus(String status){this.Status = status;return this;}
        @JsonProperty("custom_title")
        public Builder setCustomTitle(String cT){this.CustomTitle = cT;return this;}
        @JsonProperty("is_anonymous")
        public Builder setIsAnonymous(Boolean isAnon){this.IsAnonymous = isAnon;return this;}
        @JsonProperty("can_be_edited")
        public Builder setCanBeEditied(Boolean canBeEdited){this.CanBeEdited = canBeEdited;return this;}
        @JsonProperty("can_manage_chat")
        public Builder setCanManageChat(Boolean canManageC){this.CanManageChat = canManageC;return this;}
        @JsonProperty("can_post_messages")
        public Builder setCanPostMessages(Boolean canPostMsgs){this.CanPostMessages = canPostMsgs;return this;}
        @JsonProperty("can_edit_messages")
        public Builder setCanEditMessages(Boolean canEditMsgs){this.CanEditMessages = canEditMsgs;return this;}
        @JsonProperty("can_delete_messages")
        public Builder setCanDeleteMessages(Boolean canDMsgs){this.CanDeleteMessages = canDMsgs;return this;}
        @JsonProperty("can_manage_voice_chats")
        public Builder setCanManageVoiceChats(Boolean canMVoiceChat){this.CanManageVoiceChats = canMVoiceChat;return this;}
        @JsonProperty("can_restrict_members")
        public Builder setCanRestrictMembers(Boolean canRMembers){this.CanRestrictMembers = canRMembers;return this;}
        @JsonProperty("can_promote_members")
        public Builder setCanPromoteMembers(Boolean canPrMembers){this.CanPromoteMembers = canPrMembers;return this;}
        @JsonProperty("can_change_info")
        public Builder setCanChangeInfo(Boolean canChangeInfo){this.CanChangeInfo = canChangeInfo;return this;}
        @JsonProperty("can_invite_users")
        public Builder setCanInviteUsers(Boolean canInvUsers){this.CanInviteUsers = canInvUsers;return this;}
        @JsonProperty("can_pin_messages")
        public Builder setCanPinMessages(Boolean canPMsgs){this.CanPinMessages = canPMsgs;return this;}
        @JsonProperty("is_member")
        public Builder setIsMember(Boolean isMember){this.IsMember = isMember;return this;}
        @JsonProperty("can_send_messages")
        public Builder setCanSendMessages(Boolean canSMsgs){this.CanSendMessages = canSMsgs;return this;}
        @JsonProperty("can_send_media_messages")
        public Builder setCanSendMediaMessages(Boolean canSMMsgs){this.CanSendMediaMessages = canSMMsgs;return this;}
        @JsonProperty("can_send_polls")
        public Builder setCanSendPolls(Boolean canSPolls){this.CanSendPolls = canSPolls;return this;}
        @JsonProperty("can_send_other_messages")
        public Builder setCanSendOtherMessages(Boolean canSOMsgs){this.CanSendOtherMessages = canSOMsgs;return this;}
        @JsonProperty("can_add_web_page_previews")
        public Builder setCanAddWebPagePreviews(Boolean canAddWPP){this.CanAddWebPagePreviews = canAddWPP;return this;}
        @JsonProperty("until_date")
        public Builder setUntilDate(Integer untilDate){this.UntilDate = untilDate;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ChatMember build(){
            return new ChatMember(this);
        }
    }
}
