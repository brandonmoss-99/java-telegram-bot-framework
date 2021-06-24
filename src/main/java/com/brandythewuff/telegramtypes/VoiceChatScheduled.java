package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VoiceChatScheduled{
    private Integer StartDate;

    @JsonProperty("start_date")
    public void setStartDate(Integer sd){this.StartDate = sd;}
    
    @JsonProperty("start_date")
    public Integer getStartDate(){return StartDate;}
}