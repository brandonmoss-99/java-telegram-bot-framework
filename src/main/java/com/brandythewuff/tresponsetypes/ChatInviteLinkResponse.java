package com.brandythewuff.tresponsetypes;

import com.brandythewuff.telegramtypes.ChatInviteLink;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = ChatInviteLinkResponse.Builder.class)
public class ChatInviteLinkResponse {
    private final ChatInviteLink Result;
    private final Boolean Ok;

    private ChatInviteLinkResponse(Builder builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods

    @JsonProperty("result")
    public ChatInviteLink GetResult(){return Result;}

    /**
     * Get Ok status from response
     * @return true if Ok, otherwise false
     */
    public boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private ChatInviteLink Result;
        private Boolean Ok;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("result")
        public Builder SetResult(ChatInviteLink result){
            this.Result = result;
            return this;
        }

        public Builder setOk(Boolean ok){
            this.Ok = ok;
            return this;
        }

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ChatInviteLinkResponse build(){
            return new ChatInviteLinkResponse(this);
        }
    }
}
