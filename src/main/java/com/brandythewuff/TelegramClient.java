package com.brandythewuff;

import java.text.MessageFormat;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.util.HashMap;

import com.brandythewuff.tmethodtypes.*;
//import com.brandythewuff.tresponsetypes.GetMeResponse;
import com.brandythewuff.tresponsetypes.*;

/** 
 * Telegram client, containing methods for
 * interacting with the Telegram API
*/
public class TelegramClient{
    private String _token;
    /* static means it is visible to every instance of this class,
    final means constant, it can't be changed. Combining both ensures
    no instance of this class can change it, whereas having private
    final would mean only that 1 instance of a class can't change it */
    static final String BASE_URL = "https://api.telegram.org/bot";
    private JsonParse JsonParsing = new JsonParse();
    private JsonSerialize JsonSerializing = new JsonSerialize();

    public String getToken(){return _token;}

    public TelegramClient(String token){
        _token = token;
    }

    /* ----- Start of Helper methods ----- */

    /**
     * Generates the URL part of the request to Telegram
     * @param toGet - The Telegram method to extract the URL from & build URL
     * @return {@code String} - The constructed URL part of request
     */
    public String GetBaseTelegramUrl(TMethod toGet){
        return MessageFormat.format("{0}{1}/{2}", BASE_URL, this._token, toGet.getUrl());
    }

    /**
     * Generates the URL part of the request to Telegram, for a pre-serialized object
     * @param toGet - The Telegram method name to use
     * @return {@code String} - The constructed URL part of request
     */
    public String GetBaseTelegramUrl(String toGet){
        return MessageFormat.format("{0}{1}/{2}", BASE_URL, this._token, toGet);
    }

    /**
     * Send a request to Telegram, and return the response
     * @param url - The URL part of the request, returned by the
     *  {@link #GetBaseTelegramUrl(TMethod)} method
     * @param data - The data part of the request, returned by the
     *  {@link #GenerateDataForUrl(HashMap)} method
     * @return {@code HashMap<String, String>} - The response from
     *  Telegram, split into "Ok", "Data" and if failed, "FailReason" sections
     */
    public HashMap<String, String> GetTelegramResponse(String url, String data){
        HashMap<String, String> toReturn = new HashMap<>();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(data))
        .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response;
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                toReturn.put("Ok", "True");
                toReturn.put("Data", response.body().toString());
            }
            else{
                toReturn.put("Ok", "False");
                toReturn.put("Data", "");
                toReturn.put("FailReason", "HTTP response wasn't 200 (OK), got: " + response.statusCode());
            }
        }
        catch(Exception e){
            toReturn.put("Ok", "False");
            toReturn.put("Data", "");
            toReturn.put("FailReason", "Failed to send/recieve request");
        }
        return toReturn;
    }

    /**
     * Generates the data part of the request to Telegram
     * @param data - The serialised data to format for Telegram,
     *  obtained from the {@link com.brandythewuff.JsonSerialize#JsonSerialize() JsonSerialize} method
     * @return {@code String} - The appropriately formatted data for the request
     */
    public String GenerateDataForUrl(HashMap<String,String> data){
        String UrlData = "?";
        // Loop through HashMap
        for(String key : data.keySet()){
            // For each key, append key and associated data to URL
            UrlData += key + "=" + data.get(key) + "&";
        }
        // Chop off the last '&' when returning the String
        return UrlData.substring(0, UrlData.length()-1);
    }

    /**
     * Handle the creation, sending, and receiving of a Telegram method request
     * @param <T> - The appropriate response object type for the method given
     * @param returnType - The class to use for handling the response for the method
     * @param method - The method instance to use for creating/sending request
     * @return - The Telegram response, in the object Type specified in returnType
     */
    private <T> T processRequest(Class <T> returnType, TMethod method){
        String url = GetBaseTelegramUrl(method);
        String data = method.getClass().getName() != "GetMe" ? JsonSerializing.serialize(method) : "";
        HashMap<String, String> response = GetTelegramResponse(url, data);
        T responseParsed = JsonParsing.parseResponse(response, returnType);
        return responseParsed;
    }

    /**
     * Handle the creation, sending, and receiving of a Telegram method request, with a pre-serialized object
     * @param <T> - The appropriate response object type for the method given
     * @param returnType - The class to use for handling the response for the method
     * @param method - The method instance to use for creating/sending request
     * @param serializedString - The serialized object to use, avoid using the provided serializer method
     * @return - The Telegram response, in the object Type specified in returnType
     */
    private <T> T processRequest(Class <T> returnType, String method, String serializedString){
        String url = GetBaseTelegramUrl(method);
        String data = method != "GetMe" ? serializedString : "";
        HashMap<String, String> response = GetTelegramResponse(url, data);
        T responseParsed = JsonParsing.parseResponse(response, returnType);
        return responseParsed;
    }

    /* ----- End of Helper methods ----- */

    /* ----- Start of Telegram methods ----- */

    /**
     * Simple method for testing a bot's auth token
     * @param me : {@code GetMe} - The 
     * {@link com.brandythewuff.tmethodtypes.GetMe GetMe} object to send
     * @return {@code GetMeResponse} - A 
     *  {@link com.brandythewuff.tresponsetypes.GetMeResponse GetMeResponse} 
     *  object, containing basic information about the bot
     */
    public GetMeResponse GetMe(GetMe me){
        return processRequest(GetMeResponse.class, me);
    }

    /**
     * Fetch updates from Telegram servers
     * @param update : {@code GetUpdates} - The 
     * {@link com.brandythewuff.tmethodtypes.GetUpdates GetUpdates} 
     *  object to send
     * @return {@code UpdateResponse} - An
     * {@link com.brandythewuff.tresponsetypes.UpdateResponse UpdateResponse}
     *  object, containing response data
     */
    public UpdateResponse GetUpdates(GetUpdates update){
        return processRequest(UpdateResponse.class, update);
    }

    public UpdateResponse GetUpdates(String update){
        return processRequest(UpdateResponse.class, "GetUpdates", update);
    }

    /**
     * Send a text message to Telegram
     * @param msg : {@code SendMessage} - The 
     * {@link com.brandythewuff.tmethodtypes.SendMessage SendMessage} 
     *  object to send
     * @return {@code MessageResponse} - A 
     *  {@link com.brandythewuff.tresponsetypes.MessageResponse MessageResponse}
     *  object, containing response data
     */
    public MessageResponse SendMessage(SendMessage msg){
        return processRequest(MessageResponse.class, msg);
    }

    public MessageResponse SendMessage(String msg){
        return processRequest(MessageResponse.class, "SendMessage", msg);
    }

    /**
     * Send a Dice (or other emoji with random selection) message
     * @param dice : {@code SendDice} - The
     *  {@link com.brandythewuff.tmethodtypes.SendDice SendDice}
     *  object to send
     * @return {@code MessageResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.MessageResponse MessageResponse} 
     *  object, containing response data
     */
    public MessageResponse SendDice(SendDice dice){
        return processRequest(MessageResponse.class, dice);
    }

    public MessageResponse SendDice(String msg){
        return processRequest(MessageResponse.class, "SendDice", msg);
    }

    /**
     * Forward a message to another chat
     * @param msg : {@code ForwardMessage} - The
     *  {@link com.brandythewuff.tmethodtypes.ForwardMessage ForwardMessage}
     *  object to send
     * @return {@code MessageResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.MessageResponse MessageResponse}
     *  object, containing response data
     */
    public MessageResponse ForwardMessage(ForwardMessage msg){
        return processRequest(MessageResponse.class, msg);
    }

    public MessageResponse ForwardMessage(String msg){
        return processRequest(MessageResponse.class, "ForwardMessage", msg);
    }

    /**
     * Ban chat member from a group
     * @param toKick : {@code KickChatMember} - The
     *  {@link com.brandythewuff.tmethodtypes.KickChatMember KickChatMember}
     *  object to send
     * @return {@code BooleanResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.BooleanResponse BooleanResponse}
     *  object, containing response data
     */
    public BooleanResponse KickChatMember(KickChatMember toKick){
        return processRequest(BooleanResponse.class, toKick);
    }

    public BooleanResponse KickChatMember(String toKick){
        return processRequest(BooleanResponse.class, "KickChatMember", toKick);
    }

    /**
     * Kick/unban chat member from a group
     * @param toUnban : {@code UnbanChatMember} - The
     *  {@link com.brandythewuff.tmethodtypes.UnbanChatMember UnbanChatMember}
     *  object to send
     * @return {@code BooleanResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.BooleanResponse BooleanResponse}
     *  object, containing response data
     */
    public BooleanResponse UnbanChatMember(UnbanChatMember toUnban){
        return processRequest(BooleanResponse.class, toUnban);
    }

    public BooleanResponse UnbanChatMember(String toUnban){
        return processRequest(BooleanResponse.class, "UnbanChatMember", toUnban);
    }

    /**
     * Restrict user in a group
     * @param toRestrict : {@code RestrictChatMember} - The
     *  {@link com.brandythewuff.tmethodtypes.RestrictChatMember RestrictChatMember}
     *  object to send
     * @return {@code BooleanResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.BooleanResponse BooleanResponse}
     *  object, containing response data
     */
    public BooleanResponse RestrictChatMember(RestrictChatMember toRestrict){
        return processRequest(BooleanResponse.class, toRestrict);
    }

    public BooleanResponse RestrictChatMember(String toRestrict){
        return processRequest(BooleanResponse.class, "RestrictChatMember", toRestrict);
    }

    /**
     * Get information about a chat
     * @param chat : {@code GetChat} - The
     *  {@link com.brandythewuff.tmethodtypes.GetChat GetChat}
     *  object to send
     * @return {@code ChatResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.ChatResponse ChatResponse}
     *  object, containing response data
     */
    public ChatResponse GetChat(GetChat chat){
        return processRequest(ChatResponse.class, chat);
    }

    public ChatResponse GetChat(String chat){
        return processRequest(ChatResponse.class, "GetChat", chat);
    }

    /**
     * Leave a chat
     * @param toLeave : {@code LeaveChat} - The
     *  {@link com.brandythewuff.tmethodtypes.LeaveChat LeaveChat}
     *  object to send
     * @return {@code BooleanResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.BooleanResponse BooleanResponse}
     *  object, containing response data
     */
    public BooleanResponse LeaveChat(LeaveChat toLeave){
        return processRequest(BooleanResponse.class, toLeave);
    }

    public BooleanResponse LeaveChat(String toLeave){
        return processRequest(BooleanResponse.class, "LeaveChat", toLeave);
    }

    /**
     * Get a list of chat admin information
     * @param toGet : {@code GetChatAdministrators} - The
     *  {@link com.brandythewuff.tmethodtypes.GetChatAdministrators GetChatAdministrators}
     *  object to send
     * @return {@code ChatMembersResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.ChatMembersResponse ChatMembersResponse}
     *  object, containing response data
     */
    public ChatMembersResponse GetChatAdministrators(GetChatAdministrators toGet){
        return processRequest(ChatMembersResponse.class, toGet);
    }

    public ChatMembersResponse GetChatAdministrators(String toGet){
        return processRequest(ChatMembersResponse.class, "GetChatAdministrators", toGet);
    }

    /**
     * Get number of members in a chat
     * @param toCount : {@code GetChatMembersCount} - The
     *  {@link com.brandythewuff.tmethodtypes.GetChatMembersCount GetChatMembersCount}
     *  object to send
     * @return {@code IntegerResponse} - An
     *  {@link com.brandythewuff.tresponsetypes.IntegerResponse IntegerResponse}
     *  object, containing response data
     */
    public IntegerResponse GetChatMembersCount(GetChatMembersCount toCount){
        return processRequest(IntegerResponse.class, toCount);
    }

    public IntegerResponse GetChatMembersCount(String toCount){
        return processRequest(IntegerResponse.class, "GetChatMembersCount", toCount);
    }

    /**
     * Send an invoice
     * @param toSend : {@code SendInvoice} - The
     *  {@link com.brandythewuff.tmethodtypes.SendInvoice SendInvoice}
     *  object to send
     * @return {@code MessageResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.MessageResponse MessageResponse}
     *  object, containing response data
     */
    public MessageResponse SendInvoice(SendInvoice toSend){
        return processRequest(MessageResponse.class, toSend);
    }

    public MessageResponse SendInvoice(String toSend){
        return processRequest(MessageResponse.class, "SendInvoice", toSend);
    }

    /**
     * Reply to payment shipping queries (if an invoice requesting a shipping
     *  address was sent, with the IsFlexible parameter specified)
     * @param toAnswer : {@code AnswerShippingQuery} - The
     *  {@link com.brandythewuff.tmethodtypes.AnswerShippingQuery AnswerShippingQuery}
     *  object to send
     * @return {@code BooleanResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.BooleanResponse BooleanResponse}
     *  object, containing response data
     */
    public BooleanResponse AnswerShippingQuery(AnswerShippingQuery toAnswer){
        return processRequest(BooleanResponse.class, toAnswer);
    }

    public BooleanResponse AnswerShippingQuery(String toAnswer){
        return processRequest(BooleanResponse.class, "AnswerShippingQuery", toAnswer);
    }

    /**
     * Respond to a pre-checkout query. This is the 'final confirmation' method
     *  for a purchase, once sent, the transaction handling/cancellation happens
     * @param toAnswer : {@code AnswerPreCheckoutQuery} - The
     *  {@link com.brandythewuff.tmethodtypes.AnswerPreCheckoutQuery AnswerPreCheckoutQuery}
     *  object to send
     * @return {@code BooleanResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.BooleanResponse BooleanResponse}
     *  object, containing response data
     */
    public BooleanResponse AnswerPreCheckoutQuery(AnswerPreCheckoutQuery toAnswer){
        return processRequest(BooleanResponse.class, toAnswer);
    }

    public BooleanResponse AnswerPreCheckoutQuery(String toAnswer){
        return processRequest(BooleanResponse.class, "AnswerPreCheckoutQuery", toAnswer);
    }

    /**
     * Respond to a callback query. Telegram clients will show a loading icon until
     * this is sent back
     * @param toAnswer : {@code AnswerCallbackQuery} - The
     *  {@link com.brandythewuff.tmethodtypes.AnswerCallbackQuery AnswerCallbackQuery}
     *  object to send
     * @return {@code BooleanResponse} - A
     *  {@link com.brandythewuff.tresponsetypes.BooleanResponse BooleanResponse}
     *  object, containing response data
     */
    public BooleanResponse AnswerCallbackQuery(AnswerCallbackQuery toAnswer){
        return processRequest(BooleanResponse.class, toAnswer);
    }

    public BooleanResponse AnswerCallbackQuery(String toAnswer){
        return processRequest(BooleanResponse.class, "AnswerCallbackQuery", toAnswer);
    }

    /* ----- End of Telegram methods ----- */

}
