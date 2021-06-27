package com.brandythewuff;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.brandythewuff.tmethodtypes.AnswerPreCheckoutQuery;

import org.junit.jupiter.api.Test;

class AnswerPreCheckoutQueryTest {
    @Test
    void basicAnswerPreCheckoutQueryTest() throws InvalidParamsException{
        AnswerPreCheckoutQuery testAnswer = AnswerPreCheckoutQuery.Builder.newInstance("testPreCheckoutId", true).build();
        assertEquals("testPreCheckoutId", testAnswer.getPreCheckoutQueryId());
        assertEquals(true, testAnswer.getOk());
    }

    @Test
    void basicAnswerPreCheckoutQueryValidTest() throws InvalidParamsException{
        assertDoesNotThrow(() -> {
            AnswerPreCheckoutQuery.Builder.newInstance("testPreCheckoutId", true).build();
        });
    }

    @Test
    void ExtendedAnswerPreCheckoutQueryTest() throws InvalidParamsException{
        AnswerPreCheckoutQuery testAnswer = AnswerPreCheckoutQuery.Builder.newInstance("testPreCheckoutId", false).setErrorMessage("testErrorMsg").build();
        assertEquals("testPreCheckoutId", testAnswer.getPreCheckoutQueryId());
        assertEquals(false, testAnswer.getOk());
        assertEquals("testErrorMsg", testAnswer.getErrorMessage());
    }

    @Test
    void ExtendedAnswerPreCheckoutQueryValidTest() throws InvalidParamsException{
        assertDoesNotThrow(() -> {
            AnswerPreCheckoutQuery.Builder.newInstance("testPreCheckoutId", false).setErrorMessage("testErrorMsg").build();
        });
    }

    // --- Error message tests --- //

    @Test
    void MissingErrMsgAnswerPreCheckoutQueryTest() throws InvalidParamsException{
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            AnswerPreCheckoutQuery.Builder.newInstance("testPreCheckoutId", false).build();
        });
        assertEquals("Error message required when not Ok. ", exception.getMessage());;
    }

}
