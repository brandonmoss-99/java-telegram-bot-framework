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

    public String GetBaseTelegramUrl(TMethod toGet){
        return MessageFormat.format("{0}{1}/{2}", BASE_URL, this._token, toGet.getUrl());
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

    private <T> T processRequest(Class <T> returnType, TMethod method){
        String url = GetBaseTelegramUrl(method);
        String data = method.getClass().getName() != "GetMe" ? JsonSerializing.serialize(method) : "";
        HashMap<String, String> response = GetTelegramResponse(url, data);
        T responseParsed = JsonParsing.parseResponse(response, returnType);
        return responseParsed;
    }

    /* ----- End of Helper methods ----- */

    /* ----- Start of Telegram methods ----- */

    /**
     * Simple method for testing a bot's auth token
     * @return Basic information about the bot in a GetMeResponse type
     */
    public GetMeResponse GetMe(GetMe me){
        return processRequest(GetMeResponse.class, me);
    }

    public UpdateResponse GetUpdates(GetUpdates update){
        return processRequest(UpdateResponse.class, update);
    }

    /**
     * Send a message to Telegram servers
     * @param msg {@code SendMessage} - The SendMessage object to send
     * @return {@code MessageResponse} object, containing response data
     */
    public MessageResponse SendMessage(SendMessage msg){
        return processRequest(MessageResponse.class, msg);
    }


    /**
     * Send a Dice (or other emoji with random selection) message
     * @param msg : {@code SendDice} - The SendDice object to send
     * @return {@code MessageResponse} - The response data object
     */
    public MessageResponse SendDice(SendDice msg){
        return processRequest(MessageResponse.class, msg);
    }

    /**
     * Forward a message to another chat
     * @param msg : {@code ForwardMessage} - The ForwardMessage object to send
     * @return {@code MessageResponse} - The response data object
     */
    public MessageResponse ForwardMessage(ForwardMessage msg){
        return processRequest(MessageResponse.class, msg);
    }

    public BooleanResponse KickChatMember(KickChatMember toKick){
        return processRequest(BooleanResponse.class, toKick);
    }

    public BooleanResponse UnbanChatMember(UnbanChatMember toUnban){
        return processRequest(BooleanResponse.class, toUnban);
    }

    public BooleanResponse RestrictChatMember(RestrictChatMember toRestrict){
        return processRequest(BooleanResponse.class, toRestrict);
    }

    public ChatResponse GetChat(GetChat chat){
        return processRequest(ChatResponse.class, chat);
    }

    public BooleanResponse LeaveChat(LeaveChat toLeave){
        return processRequest(BooleanResponse.class, toLeave);
    }

    public ChatMembersResponse GetChatAdministrators(GetChatAdministrators toGet){
        return processRequest(ChatMembersResponse.class, toGet);
    }

    public IntegerResponse GetChatMembersCount(GetChatMembersCount toCount){
        return processRequest(IntegerResponse.class, toCount);
    }

    public MessageResponse SendInvoice(SendInvoice toSend){
        return processRequest(MessageResponse.class, toSend);
    }

    public BooleanResponse AnswerShippingQuery(AnswerShippingQuery toAnswer){
        return processRequest(BooleanResponse.class, toAnswer);
    }

    public BooleanResponse AnswerPreCheckoutQuery(AnswerPreCheckoutQuery toAnswer){
        return processRequest(BooleanResponse.class, toAnswer);
    }

    /* ----- End of Telegram methods ----- */

}