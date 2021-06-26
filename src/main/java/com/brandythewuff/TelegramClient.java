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
public class TelegramClient implements ITelegramClient{
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
     * Generates the base URL (without any data) for sending requests to Telegram API
     */
    public String GetBaseTelegramUrl(MethodType messageType){
        return MessageFormat.format("{0}{1}/{2}", BASE_URL, this._token, messageType.name());
    }

    public HashMap<String, String> GetTelegramResponse(String url){
        return GetTelegramResponse(url, "");
    }

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

    /* ----- End of Helper methods ----- */

    /* ----- Start of Telegram methods ----- */

    /**
     * Simple method for testing a bot's auth token
     * @return Basic information about the bot in a GetMeResponse type
     */
    public GetMeResponse GetMe(){
        // Build URL
        String url = GetBaseTelegramUrl(MethodType.GetMe);
        // Get data from telegram
        HashMap<String, String> response = GetTelegramResponse(url);
        // Deserialize JSON response into object
        GetMeResponse jsonResponse = JsonParsing.parseResponse(response, GetMeResponse.class);
        return jsonResponse;
    }

    public UpdateResponse GetUpdates(){
        // Create updates object
        GetUpdates update = GetUpdates.Builder.newInstance().build();
        // Generate base and data parts of URL to send
        String url = GetBaseTelegramUrl(MethodType.GetUpdates);
        String data = JsonSerializing.serialize(update);
        // Send message to telegram and handle response
        HashMap<String, String> response = GetTelegramResponse(url, data);

        UpdateResponse responseParsed = JsonParsing.parseResponse(response, UpdateResponse.class);
        return responseParsed;
    }

    public UpdateResponse GetUpdates(GetUpdates update){
        String url = GetBaseTelegramUrl(MethodType.GetUpdates);
        String data = JsonSerializing.serialize(update);
        // Send message to telegram and handle response
        HashMap<String, String> response = GetTelegramResponse(url, data);

        UpdateResponse responseParsed = JsonParsing.parseResponse(response, UpdateResponse.class);
        return responseParsed;
    }

    /**
     * Send a message to Telegram servers
     * @param chatIdInt {@code Integer} - The chat ID to send the message to
     * @param text {@code String} - The text message data to send
     * @return {@code MessageResponse} object, containing response data
     */
    public MessageResponse SendMessage(Long chatIdInt, String text){
        // Create new object to populate with data to send
        SendMessage sendMessage = SendMessage.Builder.newInstance(chatIdInt, text).build();
        // Generate URL and data parts of message to send
        String url = GetBaseTelegramUrl(MethodType.SendMessage);
        String data = JsonSerializing.serialize(sendMessage);
        // Send message to telegram, get back response
        HashMap<String, String> response = GetTelegramResponse(url, data);
        // Parse response into appropriate response object type and return it
        MessageResponse responseParsed = JsonParsing.parseResponse(response, MessageResponse.class);
        return responseParsed; 
    }

    /**
     * Send a message to Telegram servers
     * @param chatIdInt {@code Integer} - The chat ID to send the message to
     * @param msg {@code SendMessage} - The SendMessage object to send
     * @return {@code MessageResponse} object, containing response data
     */
    public MessageResponse SendMessage(SendMessage msg){
        String url = GetBaseTelegramUrl(MethodType.SendMessage);
        String data = JsonSerializing.serialize(msg);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        MessageResponse responseParsed = JsonParsing.parseResponse(response, MessageResponse.class);
        return responseParsed;
    }

    /**
     * Send a Dice (or other emoji with random selection) message
     * @param msg : {@code SendDice} - The SendDice object to send
     * @return {@code MessageResponse} - The response data object
     */
    public MessageResponse SendDice(SendDice msg){
        String url = GetBaseTelegramUrl(MethodType.SendDice);
        String data = JsonSerializing.serialize(msg);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        MessageResponse responseParsed = JsonParsing.parseResponse(response, MessageResponse.class);
        return responseParsed;
    }

    /**
     * Forward a message to another chat
     * @param msg : {@code ForwardMessage} - The ForwardMessage object to send
     * @return {@code MessageResponse} - The response data object
     */
    public MessageResponse ForwardMessage(ForwardMessage msg){
        String url = GetBaseTelegramUrl(MethodType.ForwardMessage);
        String data = JsonSerializing.serialize(msg);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        MessageResponse responseParsed = JsonParsing.parseResponse(response, MessageResponse.class);
        return responseParsed;
    }

    public BooleanResponse KickChatMember(KickChatMember toKick){
        String url = GetBaseTelegramUrl(MethodType.KickChatMember);
        String data = JsonSerializing.serialize(toKick);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        BooleanResponse responseParsed = JsonParsing.parseResponse(response, BooleanResponse.class);
        return responseParsed;
    }

    public BooleanResponse UnbanChatMember(UnbanChatMember toUnban){
        String url = GetBaseTelegramUrl(MethodType.UnbanChatMember);
        String data = JsonSerializing.serialize(toUnban);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        BooleanResponse responseParsed = JsonParsing.parseResponse(response, BooleanResponse.class);
        return responseParsed;
    }

    public BooleanResponse RestrictChatMember(RestrictChatMember toRestrict){
        String url = GetBaseTelegramUrl(MethodType.RestrictChatMember);
        String data = JsonSerializing.serialize(toRestrict);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        BooleanResponse responseParsed = JsonParsing.parseResponse(response, BooleanResponse.class);
        return responseParsed;
    }

    public ChatResponse GetChat(GetChat chat){
        String url = GetBaseTelegramUrl(MethodType.RestrictChatMember);
        String data = JsonSerializing.serialize(chat);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        ChatResponse responseParsed = JsonParsing.parseResponse(response, ChatResponse.class);
        return responseParsed;
    }

    public BooleanResponse LeaveChat(Integer chatId){
        String url = GetBaseTelegramUrl(MethodType.RestrictChatMember);
        String data = JsonSerializing.serialize(chatId);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        BooleanResponse responseParsed = JsonParsing.parseResponse(response, BooleanResponse.class);
        return responseParsed;
    }

    public ChatMembersResponse GetChatAdministrators(GetChatAdministrators toGet){
        String url = GetBaseTelegramUrl(MethodType.GetChatAdministrators);
        String data = JsonSerializing.serialize(toGet);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        ChatMembersResponse responseParsed = JsonParsing.parseResponse(response, ChatMembersResponse.class);
        return responseParsed;
    }

    public IntegerResponse GetChatMembersCount(GetChatMembersCount toCount){
        String url = GetBaseTelegramUrl(MethodType.GetChatAdministrators);
        String data = JsonSerializing.serialize(toCount);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        IntegerResponse responseParsed = JsonParsing.parseResponse(response, IntegerResponse.class);
        return responseParsed;
    }

    public MessageResponse SendInvoice(SendInvoice toSend){
        String url = GetBaseTelegramUrl(MethodType.SendInvoice);
        String data = JsonSerializing.serialize(toSend);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        MessageResponse responseParsed = JsonParsing.parseResponse(response, MessageResponse.class);
        return responseParsed;
    }

    public BooleanResponse AnswerShippingQuery(AnswerShippingQuery toAnswer){
        String url = GetBaseTelegramUrl(MethodType.AnswerShippingQuery);
        String data = JsonSerializing.serialize(toAnswer);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        BooleanResponse responseParsed = JsonParsing.parseResponse(response, BooleanResponse.class);
        return responseParsed;
    }

    public BooleanResponse AnswerPreCheckoutQuery(AnswerPreCheckoutQuery toAnswer){
        String url = GetBaseTelegramUrl(MethodType.AnswerPreCheckoutQuery);
        String data = JsonSerializing.serialize(toAnswer);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        BooleanResponse responseParsed = JsonParsing.parseResponse(response, BooleanResponse.class);
        return responseParsed;
    }

    /* ----- End of Telegram methods ----- */

    /*private <T> T processRequest(Class <T> returnType, Class <T> method, Object toSerialize){
        String url = GetTelegramUrl(method);
        String data = JsonSerializing.serialize(toSerialize);
        HashMap<String, String> response = GetTelegramResponse(url, data);
        System.out.println(response);
        T responseParsed = JsonParsing.parseResponse(response, returnType);
        return responseParsed;
    }*/

    

    private enum MethodType{
        None,
        GetMe,
        GetUpdates,
        SendMessage,
        SendDice,
        ForwardMessage,
        KickChatMember,
        UnbanChatMember,
        RestrictChatMember,
        LeaveChat,
        GetChat,
        GetChatAdministrators,
        GetChatMembersCount,
        GetChatMember,
        SendInvoice,
        AnswerShippingQuery,
        AnswerPreCheckoutQuery;

        /* Variables and methods must be static, enum is a special 
        type which doesn't allow instances of, must make static to
        work correctly */
    }
}