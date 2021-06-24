package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = MaskPosition.Builder.class)
public class MaskPosition{
    private final String Point;
    private final Float XShift;
    private final Float YShift;
    private final Float Scale;

    private MaskPosition(Builder builder){
        this.Point = builder.Point;
        this.XShift = builder.XShift;
        this.YShift = builder.YShift;
        this.Scale = builder.Scale;
    }

    // Getter methods

    @JsonProperty("point")
    public String getPoint(){return Point;}
    @JsonProperty("x_shift")
    public Float getXShift(){return XShift;}
    @JsonProperty("y_shift")
    public Float getYShift(){return YShift;}
    @JsonProperty("scale")
    public Float getScale(){return Scale;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private String Point;
        private Float XShift;
        private Float YShift;
        private Float Scale;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        public Builder setPoint(String point){this.Point = point;return this;}
        public Builder setXShift(Float x){this.XShift = x;return this;}
        public Builder setYShift(Float y){this.YShift = y;return this;}
        public Builder setScale(Float sc){this.Scale = sc;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public MaskPosition build(){
            return new MaskPosition(this);
        }
    }
}