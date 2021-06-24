package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = ChatPermissions.Builder.class)
public class ChatPermissions {
    private final Boolean CanSendMessages;
    private final Boolean CanSendMediaMessages;
    private final Boolean CanSendPolls;
    private final Boolean CanSendOtherMessages;
    private final Boolean CanAddWebPagePreviews;
    private final Boolean CanChangeInfo;
    private final Boolean CanInviteUsers;
    private final Boolean CanPinMessages;

    private ChatPermissions(Builder builder){
        this.CanSendMessages = builder.CanSendMessages;
        this.CanSendMediaMessages = builder.CanSendMediaMessages;
        this.CanSendPolls = builder.CanSendPolls;
        this.CanSendOtherMessages = builder.CanSendOtherMessages;
        this.CanAddWebPagePreviews = builder.CanAddWebPagePreviews;
        this.CanChangeInfo = builder.CanChangeInfo;
        this.CanInviteUsers = builder.CanInviteUsers;
        this.CanPinMessages = builder.CanPinMessages;
    }

    // Getter methods

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
    @JsonProperty("can_change_info")
    public Boolean getCanChangeInfo(){return CanChangeInfo;}
    @JsonProperty("can_invite_users")
    public Boolean getCanInviteUsers(){return CanInviteUsers;}
    @JsonProperty("can_pin_messages")
    public Boolean getCanPinMessages(){return CanPinMessages;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Boolean CanSendMessages;
        private Boolean CanSendMediaMessages;
        private Boolean CanSendPolls;
        private Boolean CanSendOtherMessages;
        private Boolean CanAddWebPagePreviews;
        private Boolean CanChangeInfo;
        private Boolean CanInviteUsers;
        private Boolean CanPinMessages;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("can_send_messages")
        public Builder setCanSendMessages(Boolean canSendMsgs){this.CanSendMessages = canSendMsgs;return this;}
        @JsonProperty("can_send_media_messages")
        public Builder setCanSendMediaMessages(Boolean canSendMMsgs){this.CanSendMediaMessages = canSendMMsgs;return this;}
        @JsonProperty("can_send_polls")
        public Builder setCanSendPolls(Boolean canSendPolls){this.CanSendPolls = canSendPolls;return this;}
        @JsonProperty("can_send_other_messages")
        public Builder setCanSendOtherMessages(Boolean canSendOMsgs){this.CanSendOtherMessages = canSendOMsgs;return this;}
        @JsonProperty("can_add_web_page_previews")
        public Builder setCanAddWebPagePreviews(Boolean canAddWPPrev){this.CanAddWebPagePreviews = canAddWPPrev;return this;}
        @JsonProperty("can_change_info")
        public Builder setCanChangeInfo(Boolean canChangeInfo){this.CanChangeInfo = canChangeInfo;return this;}
        @JsonProperty("can_invite_users")
        public Builder setCanInviteUsers(Boolean canInvUsers){this.CanInviteUsers = canInvUsers;return this;}
        @JsonProperty("can_pin_messages")
        public Builder setCanPinMessages(Boolean canPinMsgs){this.CanPinMessages = canPinMsgs;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ChatPermissions build(){
            return new ChatPermissions(this);
        }
    }
}