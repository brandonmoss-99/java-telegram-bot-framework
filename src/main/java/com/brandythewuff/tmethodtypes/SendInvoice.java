package com.brandythewuff.tmethodtypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.brandythewuff.InvalidParamsException;
import com.brandythewuff.telegramtypes.LabeledPrice;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = SendInvoice.Builder.class)
public class SendInvoice {
    private final Long ChatId; // Unique identifier for the target chat
    private final String Title; // Product name, 1-32 characters
    private final String Description; // Product description, 1-255 characters
    private final String Payload; // Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
    private final String ProviderToken; // Payments provider token, obtained via Botfather
    private final String Currency; // Three-letter ISO 4217 currency code
    private final ArrayList<LabeledPrice> Prices; // Price breakdown, a JSON-serialized list of components (Product price, tax, discount, delivery, etc)
    private final Integer MaxTipAmount; // maximum accepted amount for tips in the smallest units of the currency
    private final ArrayList<Integer> SuggestedTipAmounts; //  JSON-serialized array of suggested amounts of tips in the smallest units of the currency
    private final String StartParameter; // Unique deep-linking parameter
    private final String ProviderData; // JSON-serialized data about the invoice, which will be shared with the payment provider. Provider should specify required fields
    private final String PhotoUrl; // URL of the product photo for the invoice
    private final Integer PhotoSize;
    private final Integer PhotoWidth;
    private final Integer PhotoHeight;
    private final Boolean NeedName; // True, if you require the user's full name to complete the order
    private final Boolean NeedPhoneNumber; // True, if you require the user's phone number to complete the order
    private final Boolean NeedEmail; // True, if you require the user's email address to complete the order
    private final Boolean NeedShippingAddress; // True, if you require the user's shipping address to complete the order
    private final Boolean SendPhoneNumberToProvider; // True, if user's phone number should be sent to provider
    private final Boolean SendEmailToProvider; // True, if user's email address should be sent to provider
    private final Boolean IsFlexible; // True, if the final price depends on the shipping method
    private final Boolean DisableNotification; // Sends the message silently
    private final Integer ReplyToMessageId; // If the message is a reply, ID of the original message
    private final Boolean AllowSendingWithoutReply; // True, if the message should be sent even if the specified replied-to message is not found
    //private final InlineKeyboardMarkup ReplyMarkup; //  JSON-serialized object for an inline keyboard

    private SendInvoice(Builder builder){
        this.ChatId = builder.ChatId;
        this.Title = builder.Title;
        this.Description = builder.Description;
        this.Payload = builder.Payload;
        this.ProviderToken = builder.ProviderToken;
        this.Currency = builder.Currency;
        this.Prices = builder.Prices;
        this.MaxTipAmount = builder.MaxTipAmount;
        this.SuggestedTipAmounts = builder.SuggestedTipAmounts;
        this.StartParameter = builder.StartParameter;
        this.ProviderData = builder.ProviderData;
        this.PhotoUrl = builder.PhotoUrl;
        this.PhotoSize = builder.PhotoSize;
        this.PhotoWidth = builder.PhotoWidth;
        this.PhotoHeight = builder.PhotoHeight;
        this.NeedName = builder.NeedName;
        this.NeedPhoneNumber = builder.NeedPhoneNumber;
        this.NeedEmail = builder.NeedEmail;
        this.NeedShippingAddress = builder.NeedShippingAddress;
        this.SendPhoneNumberToProvider = builder.SendPhoneNumberToProvider;
        this.SendEmailToProvider = builder.SendEmailToProvider;
        this.IsFlexible = builder.IsFlexible;
        this.DisableNotification = builder.DisableNotification;
        this.ReplyToMessageId = builder.ReplyToMessageId;
        this.AllowSendingWithoutReply = builder.AllowSendingWithoutReply;
        //this.ReplyMarkup = builder.ReplyMarkup;
    }

    // Getter methods

    @JsonProperty("chat_id")
    public Long getChatId(){return ChatId;}
    @JsonProperty("title")
    public String getTitle(){return Title;}
    @JsonProperty("description")
    public String getDescription(){return Description;}
    @JsonProperty("payload")
    public String getPayload(){return Payload;}
    @JsonProperty("provider_token")
    public String getProviderToken(){return ProviderToken;}
    @JsonProperty("currency")
    public String getCurrency(){return Currency;}
    @JsonProperty("prices")
    public ArrayList<LabeledPrice> getPrices(){return Prices;}
    @JsonProperty("max_tip_amount")
    public Integer getMaxTipAmount(){return MaxTipAmount;}
    @JsonProperty("suggested_tip_amounts")
    public ArrayList<Integer> getSuggestedTipAmounts(){return SuggestedTipAmounts;}
    @JsonProperty("start_parameter")
    public String getStartParameter(){return StartParameter;}
    @JsonProperty("provider_data")
    public String getProviderData(){return ProviderData;}
    @JsonProperty("photo_url")
    public String getPhotoUrl(){return PhotoUrl;}
    @JsonProperty("photo_size")
    public Integer getPhotoSize(){return PhotoSize;}
    @JsonProperty("photo_width")
    public Integer getPhotoWidth(){return PhotoWidth;}
    @JsonProperty("photo_height")
    public Integer getPhotoHeight(){return PhotoHeight;}
    @JsonProperty("need_name")
    public Boolean getNeedName(){return NeedName;}
    @JsonProperty("need_phone_number")
    public Boolean getNeedPhoneNumber(){return NeedPhoneNumber;}
    @JsonProperty("need_email")
    public Boolean getNeedEmail(){return NeedEmail;}
    @JsonProperty("need_shipping_address")
    public Boolean getNeedShippingAddress(){return NeedShippingAddress;}
    @JsonProperty("send_phone_number_to_provider")
    public Boolean getSendPhoneNumberToProvider(){return SendPhoneNumberToProvider;}
    @JsonProperty("send_email_to_provider")
    public Boolean getSendEmailToProvider(){return SendEmailToProvider;}
    @JsonProperty("is_flexible")
    public Boolean getIsFlexbile(){return IsFlexible;}
    @JsonProperty("disable_notification")
    public Boolean getDisableNotification(){return DisableNotification;}
    @JsonProperty("reply_to_message_id")
    public Integer getReplyToMessageId(){return ReplyToMessageId;}
    @JsonProperty("allow_sending_without_reply")
    public Boolean getAllowSendingWithoutReply(){return AllowSendingWithoutReply;}
    //@JsonProperty("reply_markup")
    //public InlineKeyboardMarkup getReplyMarkup(){return ReplyMarkup;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Long ChatId; // Unique identifier for the target chat
        private String Title; // Product name, 1-32 characters
        private String Description; // Product description, 1-255 characters
        private String Payload; // Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
        private String ProviderToken; // Payments provider token, obtained via Botfather
        private String Currency; // Three-letter ISO 4217 currency code
        private ArrayList<LabeledPrice> Prices; // Price breakdown, a JSON-serialized list of components (Product price, tax, discount, delivery, etc)
        private Integer MaxTipAmount; // maximum accepted amount for tips in the smallest units of the currency
        private ArrayList<Integer> SuggestedTipAmounts; //  JSON-serialized array of suggested amounts of tips in the smallest units of the currency
        private String StartParameter; // Unique deep-linking parameter
        private String ProviderData; // JSON-serialized data about the invoice, which will be shared with the payment provider. Provider should specify required fields
        private String PhotoUrl; // URL of the product photo for the invoice
        private Integer PhotoSize;
        private Integer PhotoWidth;
        private Integer PhotoHeight;
        private Boolean NeedName; // True, if you require the user's full name to complete the order
        private Boolean NeedPhoneNumber; // True, if you require the user's phone number to complete the order
        private Boolean NeedEmail; // True, if you require the user's email address to complete the order
        private Boolean NeedShippingAddress; // True, if you require the user's shipping address to complete the order
        private Boolean SendPhoneNumberToProvider; // True, if user's phone number should be sent to provider
        private Boolean SendEmailToProvider; // True, if user's email address should be sent to provider
        private Boolean IsFlexible; // True, if the final price depends on the shipping method
        private Boolean DisableNotification; // Sends the message silently
        private Integer ReplyToMessageId; // If the message is a reply, ID of the original message
        private Boolean AllowSendingWithoutReply; // True, if the message should be sent even if the specified replied-to message is not found
        //private InlineKeyboardMarkup ReplyMarkup; //  JSON-serialized object for an inline keyboard

        public static Builder newInstance(Long chatId, String title, String description, 
            String payload, String providerToken, String currency, ArrayList<LabeledPrice> prices){
            return new Builder(chatId, title, description, payload, providerToken, currency, prices);
        }

        private Builder(Long chatId, String title, String description, 
        String payload, String providerToken, String currency, ArrayList<LabeledPrice> prices){
            this.setChatId(chatId);
            this.setTitle(title);
            this.setDescription(description);
            this.setPayload(payload);
            this.setProviderToken(providerToken);
            this.setCurrency(currency);
            this.setPrices(prices);
        }

        @JsonProperty("chat_id")
        public Builder setChatId(Long cid){this.ChatId = cid;return this;}
        @JsonProperty("title")
        public Builder setTitle(String title){this.Title = title;return this;}
        @JsonProperty("description")
        public Builder setDescription(String desc){this.Description = desc;return this;}
        @JsonProperty("payload")
        public Builder setPayload(String payl){this.Payload = payl;return this;}
        @JsonProperty("provider_token")
        public Builder setProviderToken(String provToken){this.ProviderToken = provToken;return this;}
        @JsonProperty("currency")
        public Builder setCurrency(String cur){this.Currency = cur;return this;}
        @JsonProperty("prices")
        public Builder setPrices(ArrayList<LabeledPrice> prices){this.Prices = prices;return this;}
        @JsonProperty("max_tip_amount")
        public Builder setMaxTipAmount(Integer maxTip){this.MaxTipAmount = maxTip;return this;}
        @JsonProperty("suggested_tip_amounts")
        public Builder setSuggestedTipAmounts(ArrayList<Integer> suggestedTips){this.SuggestedTipAmounts = suggestedTips;return this;}
        @JsonProperty("start_parameter")
        public Builder setStartParameter(String startParam){this.StartParameter = startParam;return this;}
        @JsonProperty("provider_data")
        public Builder setProviderData(String provData){this.ProviderData = provData;return this;}
        @JsonProperty("photo_url")
        public Builder setPhotoUrl(String pURL){this.PhotoUrl = pURL;return this;}
        @JsonProperty("photo_size")
        public Builder setPhotoSize(Integer pSize){this.PhotoSize = pSize;return this;}
        @JsonProperty("photo_width")
        public Builder setPhotoWidth(Integer pWidth){this.PhotoWidth = pWidth;return this;}
        @JsonProperty("photo_height")
        public Builder setPhotoHeight(Integer pHeight){this.PhotoHeight = pHeight;return this;}
        @JsonProperty("need_name")
        public Builder setNeedName(Boolean needName){this.NeedName = needName;return this;}
        @JsonProperty("need_phone_number")
        public Builder setNeedPhoneNumber(Boolean needPNum){this.NeedPhoneNumber = needPNum;return this;}
        @JsonProperty("need_email")
        public Builder setNeedEmail(Boolean needEmail){this.NeedEmail = needEmail;return this;}
        @JsonProperty("need_shipping_address")
        public Builder setNeedShippingAddress(Boolean needAddr){this.NeedShippingAddress = needAddr;return this;}
        @JsonProperty("send_phone_number_to_provider")
        public Builder setSendPhoneNumberToProvider(Boolean sendPNum){this.SendPhoneNumberToProvider = sendPNum;return this;}
        @JsonProperty("send_email_to_provider")
        public Builder setSendEmailToProvider(Boolean sendEmail){this.SendEmailToProvider = sendEmail;return this;}
        @JsonProperty("is_flexible")
        public Builder setIsFlexible(Boolean isFlex){this.IsFlexible = isFlex;return this;}
        @JsonProperty("disable_notification")
        public Builder setDisableNotification(Boolean disableNotif){this.DisableNotification = disableNotif;return this;}
        @JsonProperty("reply_to_message_id")
        public Builder setReplyToMessageId(Integer replyToMsgId){this.ReplyToMessageId = replyToMsgId;return this;}
        @JsonProperty("allow_sending_without_reply")
        public Builder setAllowSendingWithoutReply(Boolean allowSendWithoutReply){this.AllowSendingWithoutReply = allowSendWithoutReply;return this;}
        //@JsonProperty("reply_markup")
        //public Builder setReplyMarkup(InlineKeyboardMarkup replyMarkup){this.ReplyMarkup = replyMarkup;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public SendInvoice build() throws InvalidParamsException{
            HashMap<String, String> isValid = checkValid();
            if(isValid.get("valid") == "true"){
                return new SendInvoice(this);
            }
            else{
                throw new InvalidParamsException(isValid.get("msg"));
            }
        }

        private HashMap<String, String> checkValid(){
            Boolean isValid = true;
            HashMap<String, String> result = new HashMap<String, String>();
            // Create StringBuilder with initial capacity 64 characters
            StringBuilder errorMsg = new StringBuilder(64);

            // title 1-32 characters
            if(this.Title.length() < 1 || this.Title.length() > 32){
                errorMsg.append("Title must be between 1-32 characters long. ");
                isValid = false;
            }

            // description 1-255 characters
            if(this.Description.length() < 1 || this.Description.length() > 255){
                errorMsg.append("Description must be between 1-255 characters long. ");
                isValid = false;
            }

            // payload 1-128 bytes
            if(this.Payload.getBytes().length > 128){
                errorMsg.append("Payload must be under 128 bytes. ");
                isValid = false;
            }

            // currency 3 characters
            if(this.Currency.length() != 3){
                errorMsg.append("Currency code must be 3 characters long. ");
                isValid = false;
            }

            // suggestedTipAmounts max of 4 entries, must be positive number, 
            // must be in increasing order, must be less than maxTipAmount
            if(this.SuggestedTipAmounts != null && this.SuggestedTipAmounts.size() > 4){
                errorMsg.append("Maximum of 4 suggested tip amounts. ");
                isValid = false;
            }
            else if (this.SuggestedTipAmounts != null){
                Collections.sort(this.SuggestedTipAmounts);
                if(this.SuggestedTipAmounts.get(this.SuggestedTipAmounts.size()-1) >= this.MaxTipAmount){
                    errorMsg.append("Largest suggested tip amount must be less than max tip amount. ");
                    isValid = false;
                }
                if(this.SuggestedTipAmounts.get(0) < 0){
                    errorMsg.append("All suggested tip amounts must be positive number. ");
                    isValid = false;
                }
            }
            result.put("valid", Boolean.toString(isValid));
            result.put("msg", errorMsg.toString());
            return result;
        }
    }
}
