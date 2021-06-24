package com.brandythewuff.tresponsetypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = GenericResponse.Builder.class)
public class GenericResponse<T> {
    private final T Result;
    private final Boolean Ok;

    private GenericResponse(Builder<T> builder){
        this.Result = builder.Result;
        this.Ok = builder.Ok;
    }

    // Getter methods
    @JsonProperty("result")
    public T getResult(){return Result;}
    public Boolean getOk(){return Ok;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder<T>{
        private T Result;
        private Boolean Ok;

        public Builder<T> newInstance(){
            return new Builder<T>();
        }

        private Builder(){}

        public Builder<T> setResult(T result){this.Result = result;return this;}
        public Builder<T> setOk(Boolean ok){this.Ok = ok;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public GenericResponse<T> build(){
            return new GenericResponse<T>(this);
        }
    }
}
