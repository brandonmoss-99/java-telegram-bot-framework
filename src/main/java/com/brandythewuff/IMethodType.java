package com.brandythewuff;

import java.util.HashMap;
// Interface for telegram method objects to implement
public interface IMethodType{
    /* The implementing class must be able to check if
    all the variables telegram requires to be set
    for a method to be valid when sent to their servers
    are actually set, to something other than their defaults */
    boolean isValid();

    /* Implementing class must be able to return all of its
    variables that have been set to something different to
    their default values */
    HashMap<String, String> getSetData();
}