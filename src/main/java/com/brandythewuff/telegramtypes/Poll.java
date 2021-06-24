package com.brandythewuff.telegramtypes;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Poll.Builder.class)
public class Poll{
    private final String Id;
    private final String Question; // Poll question, 1-300 characters
    private final ArrayList<PollOption> Options; // List of poll options
    private final Integer TotalVoterCount;
    private final Boolean IsClosed;
    private final Boolean IsAnonymous;
    private final String Type; // Poll type
    private final Boolean AllowsMultipleAnswers;
    private final Integer CorrectOptionId;
    private final String Explanation; // Text shown when user chooses incorrect answer, 0-200 characters
    private final ArrayList<MessageEntity> ExplanationEntities; // Special entities for explanation text
    private final Integer OpenPeriod; // Amount of time poll is active after creation
    private final Integer CloseDate; // UNIX timestamp when poll is automatically closed

    private Poll(Builder builder){
        this.Id = builder.Id;
        this.Question = builder.Question;
        this.Options = builder.Options;
        this.TotalVoterCount = builder.TotalVoterCount;
        this.IsClosed = builder.IsClosed;
        this.IsAnonymous = builder.IsAnonymous;
        this.Type = builder.Type;
        this.AllowsMultipleAnswers = builder.AllowsMultipleAnswers;
        this.CorrectOptionId = builder.CorrectOptionId;
        this.Explanation = builder.Explanation;
        this.ExplanationEntities = builder.ExplanationEntities;
        this.OpenPeriod = builder.OpenPeriod;
        this.CloseDate = builder.CloseDate;
    }

    // Getter methods

    @JsonProperty("id")
    public String getId(){return Id;}
    @JsonProperty("question")
    public String getQuestion(){return Question;}
    @JsonProperty("options")
    public ArrayList<PollOption> getOptions(){return Options;}
    @JsonProperty("total_voter_count")
    public Integer getTotalVoterCount(){return TotalVoterCount;}
    @JsonProperty("is_closed")
    public Boolean getIsClosed(){return IsClosed;}
    @JsonProperty("is_anonymous")
    public Boolean getIsAnonymous(){return IsAnonymous;}
    @JsonProperty("type")
    public String getType(){return Type;}
    @JsonProperty("allows_multiple_answers")
    public Boolean getAllowsMultipleAnswers(){return AllowsMultipleAnswers;}
    @JsonProperty("correct_option_id")
    public Integer getCorrectOptionId(){return CorrectOptionId;}
    @JsonProperty("explanation")
    public String getExplanation(){return Explanation;}
    @JsonProperty("explanation_entities")
    public ArrayList<MessageEntity> getExplanationEntities(){return ExplanationEntities;}
    @JsonProperty("open_period")
    public Integer getOpenPeriod(){return OpenPeriod;}
    @JsonProperty("close_date")
    public Integer getCloseDate(){return CloseDate;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Id;
        private String Question; // Poll question, 1-300 characters
        private ArrayList<PollOption> Options; // List of poll options
        private Integer TotalVoterCount;
        private Boolean IsClosed;
        private Boolean IsAnonymous;
        private String Type; // Poll type
        private Boolean AllowsMultipleAnswers;
        private Integer CorrectOptionId;
        private String Explanation; // Text shown when user chooses incorrect answer, 0-200 characters
        private ArrayList<MessageEntity> ExplanationEntities; // Special entities for explanation text
        private Integer OpenPeriod; // Amount of time poll is active after creation
        private Integer CloseDate; // UNIX timestamp when poll is automatically closed

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        @JsonProperty("id")
        public Builder setId(String id){this.Id = id;return this;}
        @JsonProperty("question")
        public Builder setQuestion(String q){this.Question = q;return this;}
        @JsonProperty("options")
        public Builder setOptions(ArrayList<PollOption> options){this.Options = options;return this;}
        @JsonProperty("total_voter_count")
        public Builder setTotalVoterCount(Integer vc){this.TotalVoterCount = vc;return this;}
        @JsonProperty("is_closed")
        public Builder setIsClosed(Boolean ic){this.IsClosed = ic;return this;}
        @JsonProperty("is_anonymous")
        public Builder setIsAnonymous(Boolean ia){this.IsAnonymous = ia;return this;}
        @JsonProperty("type")
        public Builder setType(String t){this.Type = t;return this;}
        @JsonProperty("allows_multiple_answers")
        public Builder setAllowsMultipleAnswers(Boolean ama){this.AllowsMultipleAnswers = ama;return this;}
        @JsonProperty("correct_option_id")
        public Builder setCorrectOptionId(Integer cid){this.CorrectOptionId = cid;return this;}
        @JsonProperty("explanation")
        public Builder setExplanation(String exp){this.Explanation = exp;return this;}
        @JsonProperty("explanation_entities")
        public Builder setExplanationEntities(ArrayList<MessageEntity> ents){this.ExplanationEntities = ents;return this;}
        @JsonProperty("open_perid")
        public Builder setOpenPeriod(Integer op){this.OpenPeriod = op;return this;}
        @JsonProperty("close_date")
        public Builder setCloseDate(Integer cd){this.CloseDate = cd;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Poll build(){
            return new Poll(this);
        }
    }
}