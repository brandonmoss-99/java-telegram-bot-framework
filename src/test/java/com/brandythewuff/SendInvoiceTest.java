package com.brandythewuff;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import com.brandythewuff.telegramtypes.LabeledPrice;
import com.brandythewuff.tmethodtypes.SendInvoice;

import org.junit.jupiter.api.Test;

class basicInvoiceTest{
    @Test
    void testBasicInvoice() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("Total").setAmount(100).build());
        SendInvoice testSendInvoice = SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        assertEquals(123456789L, testSendInvoice.getChatId());
        assertEquals("testTitle", testSendInvoice.getTitle());
        assertEquals("testDescription", testSendInvoice.getDescription());
        assertEquals("testPayload", testSendInvoice.getPayload());
        assertEquals("testProviderToken:12345", testSendInvoice.getProviderToken());
        assertEquals("GBP", testSendInvoice.getCurrency());
        assertEquals(prices, testSendInvoice.getPrices());
    }

    @Test
    void testBasicInvoiceValid() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("Total").setAmount(100).build());
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testExtendedInvoice() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("Total").setAmount(100).build());
        ArrayList<Integer> suggestedTips = new ArrayList<>();
        suggestedTips.add(400);

        SendInvoice testSendInvoice = SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices)
            .setMaxTipAmount(1000)
            .setSuggestedTipAmounts(suggestedTips)
            .setStartParameter("testStartParam")
            .setProviderData("testProviderData")
            .setPhotoUrl("testPhotoURL")
            .setPhotoSize(100)
            .setPhotoHeight(100)
            .setPhotoWidth(100)
            .setNeedEmail(false)
            .setNeedName(false)
            .setNeedPhoneNumber(false)
            .setNeedShippingAddress(false)
            .setSendPhoneNumberToProvider(false)
            .setSendEmailToProvider(false)
            .setIsFlexible(false)
            .setDisableNotification(false)
            .setReplyToMessageId(123456789)
            .setAllowSendingWithoutReply(false)
            .build();

        assertEquals(123456789L, testSendInvoice.getChatId());
        assertEquals("testTitle", testSendInvoice.getTitle());
        assertEquals("testDescription", testSendInvoice.getDescription());
        assertEquals("testPayload", testSendInvoice.getPayload());
        assertEquals("testProviderToken:12345", testSendInvoice.getProviderToken());
        assertEquals("GBP", testSendInvoice.getCurrency());
        assertEquals(prices, testSendInvoice.getPrices());
        assertEquals(1000, testSendInvoice.getMaxTipAmount());
        assertEquals(suggestedTips, testSendInvoice.getSuggestedTipAmounts());
        assertEquals("testStartParam", testSendInvoice.getStartParameter());
        assertEquals("testProviderData", testSendInvoice.getProviderData());
        assertEquals("testPhotoURL", testSendInvoice.getPhotoUrl());
        assertEquals(100, testSendInvoice.getPhotoSize());
        assertEquals(100, testSendInvoice.getPhotoHeight());
        assertEquals(100, testSendInvoice.getPhotoWidth());
        assertEquals(false, testSendInvoice.getNeedEmail());
        assertEquals(false, testSendInvoice.getNeedPhoneNumber());
        assertEquals(false, testSendInvoice.getNeedName());
        assertEquals(false, testSendInvoice.getNeedShippingAddress());
        assertEquals(false, testSendInvoice.getSendPhoneNumberToProvider());
        assertEquals(false, testSendInvoice.getSendEmailToProvider());
        assertEquals(false, testSendInvoice.getIsFlexbile());
        assertEquals(false, testSendInvoice.getDisableNotification());
        assertEquals(false, testSendInvoice.getAllowSendingWithoutReply());
        assertEquals(123456789, testSendInvoice.getReplyToMessageId());
    }

    @Test
    void testExtendedInvoiceValid() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("Total").setAmount(100).build());
        ArrayList<Integer> suggestedTips = new ArrayList<>();
        suggestedTips.add(400);

        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices)
            .setMaxTipAmount(1000)
            .setSuggestedTipAmounts(suggestedTips)
            .setStartParameter("testStartParam")
            .setProviderData("testProviderData")
            .setPhotoUrl("testPhotoURL")
            .setPhotoSize(100)
            .setPhotoHeight(100)
            .setPhotoWidth(100)
            .setNeedEmail(false)
            .setNeedName(false)
            .setNeedPhoneNumber(false)
            .setNeedShippingAddress(false)
            .setSendPhoneNumberToProvider(false)
            .setSendEmailToProvider(false)
            .setIsFlexible(false)
            .setDisableNotification(false)
            .setReplyToMessageId(123456789)
            .setAllowSendingWithoutReply(false)
            .build();
        });
    }

    // --- Title tests --- //
    @Test
    void testMaxTitleLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testExceededTitleLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testMinTitleLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "a", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testTooShortTitleLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    // --- Description tests --- //
    @Test
    void testMinDescriptionLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "t", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testTooShortDescriptionLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testMaxDescriptionLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testTooLongDescriptionLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "testPayload", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    // --- Payload tests --- //
    @Test
    void testMinPayloadLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "t", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testTooShortPayloadLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testMaxPayloadLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayloadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    @Test
    void testTooLongPayloadLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayloadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "testProviderToken:12345", "GBP", prices).build();
        });
    }

    // --- Currency tests --- //
    @Test
    void testTooLongCurrencyLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBPP", prices).build();
        });
    }

    @Test
    void testTooShortCurrencyLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GB", prices).build();
        });
    }


    // --- Suggested tips tests --- //
    @Test
    void testMaxSuggestedTipsLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        ArrayList<Integer> suggestedTips = new ArrayList<>();
        suggestedTips.add(100);
        suggestedTips.add(200);
        suggestedTips.add(300);
        suggestedTips.add(400);
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).setMaxTipAmount(10000).setSuggestedTipAmounts(suggestedTips).build();
        });
    }

    @Test
    void testExceededSuggestedTipsLength() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        ArrayList<Integer> suggestedTips = new ArrayList<>();
        suggestedTips.add(100);
        suggestedTips.add(200);
        suggestedTips.add(300);
        suggestedTips.add(400);
        suggestedTips.add(500);
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).setMaxTipAmount(10000).setSuggestedTipAmounts(suggestedTips).build();
        });
    }

    @Test
    void testOutOfOrderSuggestedTipsValues() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        ArrayList<Integer> suggestedTips = new ArrayList<>();
        suggestedTips.add(400);
        suggestedTips.add(200);
        suggestedTips.add(300);
        suggestedTips.add(100);
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).setMaxTipAmount(10000).setSuggestedTipAmounts(suggestedTips).build();
        });
    }

    @Test
    void testMaxSuggestedTipsValueToMaxTipAmount() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        ArrayList<Integer> suggestedTips = new ArrayList<>();
        suggestedTips.add(1000);
        suggestedTips.add(200);
        suggestedTips.add(300);
        suggestedTips.add(100);
        assertDoesNotThrow(() -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).setMaxTipAmount(1000).setSuggestedTipAmounts(suggestedTips).build();
        });
    }

    @Test
    void testExceededSuggestedTipsValueToMaxTipAmount() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        ArrayList<Integer> suggestedTips = new ArrayList<>();
        suggestedTips.add(1001);
        suggestedTips.add(200);
        suggestedTips.add(300);
        suggestedTips.add(100);
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).setMaxTipAmount(1000).setSuggestedTipAmounts(suggestedTips).build();
        });
    }

    @Test
    void testNegativeSuggestedTipsValue() throws InvalidParamsException{
        ArrayList<LabeledPrice> prices = new ArrayList<>();
        prices.add(LabeledPrice.Builder.newInstance().setLabel("thing0").setAmount(100).build());
        ArrayList<Integer> suggestedTips = new ArrayList<>();
        suggestedTips.add(-1);
        suggestedTips.add(200);
        suggestedTips.add(300);
        suggestedTips.add(100);
        Throwable exception = assertThrows(InvalidParamsException.class, () -> {
            SendInvoice.Builder.newInstance(123456789L, "testTitle", "testDescription", "testPayload", "testProviderToken:12345", "GBP", prices).setMaxTipAmount(1000).setSuggestedTipAmounts(suggestedTips).build();
        });
    }
}
