package com.brandythewuff;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import com.brandythewuff.tmethodtypes.AnswerShippingQuery;
import com.brandythewuff.telegramtypes.LabeledPrice;
import com.brandythewuff.telegramtypes.ShippingOption;

import org.junit.jupiter.api.Test;

class AnswerShippingQueryTest {
    @Test
    void AnswerShippingQueryTrueTest() throws InvalidParamsException{
        ArrayList<ShippingOption> shipOptions = new ArrayList<>();
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        
        prices.add(LabeledPrice.Builder.newInstance().setAmount(100).setLabel("testLabel").build());
        shipOptions.add(ShippingOption.Builder.newInstance().setId("12345").setTitle("testShip").setPrices(prices).build());
        AnswerShippingQuery testAnswer = AnswerShippingQuery.Builder.newInstance("testQuery", true).setShippingOptions(shipOptions).build();
        assertEquals("testQuery", testAnswer.getShippingQueryId());
        assertEquals(true, testAnswer.getOk());
        assertEquals(shipOptions, testAnswer.getShippingOptions());
    }

    @Test
    void AnswerShippingQueryTrueValidTest() throws InvalidParamsException{
        ArrayList<ShippingOption> shipOptions = new ArrayList<>();
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        
        prices.add(LabeledPrice.Builder.newInstance().setAmount(100).setLabel("testLabel").build());
        shipOptions.add(ShippingOption.Builder.newInstance().setId("12345").setTitle("testShip").setPrices(prices).build());
        assertDoesNotThrow(() -> {
            AnswerShippingQuery.Builder.newInstance("testQuery", true).setShippingOptions(shipOptions).build();
        });
    }

    @Test
    void AnswerShippingQueryTrueInvalidTest() throws InvalidParamsException{
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            AnswerShippingQuery.Builder.newInstance("testQuery", true).build();
        });
        assertEquals("Shipping options required when Ok. ", exception.getMessage());
    }

    @Test
    void AnswerShippingQueryFalseTest() throws InvalidParamsException{
        AnswerShippingQuery testAnswer = AnswerShippingQuery.Builder.newInstance("testQuery", false).setErrorMessage("testError").build();
        assertEquals("testQuery", testAnswer.getShippingQueryId());
        assertEquals(false, testAnswer.getOk());
        assertEquals("testError", testAnswer.getErrorMessage());
    }

    @Test
    void AnswerShippingQueryFalseValidTest() throws InvalidParamsException{
        assertDoesNotThrow(() -> {
            AnswerShippingQuery.Builder.newInstance("testQuery", false).setErrorMessage("testError").build();
        });
    }

    @Test
    void AnswerShippingQueryFalseInvalidTest() throws InvalidParamsException{
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            AnswerShippingQuery.Builder.newInstance("testQuery", false).build();
        });
        assertEquals("Error message required when not Ok. ", exception.getMessage());
    }
}
