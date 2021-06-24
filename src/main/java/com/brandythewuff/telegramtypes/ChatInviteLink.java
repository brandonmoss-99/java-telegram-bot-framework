package com.brandythewuff.telegramtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = ChatInviteLink.Builder.class)
public class ChatInviteLink {
    private final String InviteLink;
    private final User Creator;
    private final Boolean IsPrimary;
    private final Boolean IsRevoked;
    private final Integer ExpireDate;
    private final Integer MemberLimit;

    private ChatInviteLink(Builder builder){
        this.InviteLink = builder.InviteLink;
        this.Creator = builder.Creator;
        this.IsPrimary = builder.IsPrimary;
        this.IsRevoked = builder.IsRevoked;
        this.ExpireDate = builder.ExpireDate;
        this.MemberLimit = builder.MemberLimit;
    }

    // Getter methods

    @JsonProperty("invite_link")
    public String getInviteLink(){return InviteLink;}
    @JsonProperty("creator")
    public User getCreator(){return Creator;}
    @JsonProperty("is_primary")
    public Boolean getIsPrimary(){return IsPrimary;}
    @JsonProperty("is_revoked")
    public Boolean getIsRevoked(){return IsRevoked;}
    @JsonProperty("expire_date")
    public Integer getExpireDate(){return ExpireDate;}
    @JsonProperty("member_limit")
    public Integer getMemberLimit(){return MemberLimit;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String InviteLink;
        private User Creator;
        private Boolean IsPrimary;
        private Boolean IsRevoked;
        private Integer ExpireDate;
        private Integer MemberLimit;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("invite_link")
        public Builder setInviteLink(String il){this.InviteLink = il;return this;}
        @JsonProperty("creator")
        public Builder setCreator(User creator){this.Creator = creator;return this;}
        @JsonProperty("is_primary")
        public Builder setIsPrimary(Boolean isPrimary){this.IsPrimary = isPrimary;return this;}
        @JsonProperty("is_revoked")
        public Builder setIsRevoked(Boolean isRevoked){this.IsRevoked = isRevoked;return this;}
        @JsonProperty("expire_date")
        public Builder setExpireDate(Integer date){this.ExpireDate = date;return this;}
        @JsonProperty("member_limit")
        public Builder setMemberLimit(Integer lim){this.MemberLimit = lim;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public ChatInviteLink build(){
            return new ChatInviteLink(this);
        }
    }
}
