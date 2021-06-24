package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VoiceChatEnded{
    private Integer Duration;

    @JsonProperty("duration")
    public void setDuration(Integer d){this.Duration = d;}

    @JsonProperty("duration")
    public Integer getDuration(){return Duration;}
}