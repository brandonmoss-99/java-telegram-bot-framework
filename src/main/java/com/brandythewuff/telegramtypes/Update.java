package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

@JsonDeserialize(builder = Update.Builder.class)
public class Update{
    // Final attributes. Once set, can't be changed
    private final Integer UpdateId; // update's unique identifier
    private final Message Message; // New incoming message of any kind
    private final Message EditedMessage; // New version of a message that is known to the bot and was edited
    private final Message ChannelPost; // New incoming channel post of any kind
    private final Message EditedChannelPost; // New version of a channel post that is known to the bot and was edited
    //private final InlineQuery InlineQuery; // New incoming inline query
    //private final ChosenInlineResult ChosenInlineResult; // result of an inline query that was chosen by a user and sent to their chat partner
    //private final CallbackQuery CallbackQuery; // New incoming callback query
    private final ShippingQuery ShippingQuery; // New incoming shipping query. Only for invoices with flexible price
    private final PreCheckoutQuery PreCheckoutQuery; // New incoming pre-checkout query. Contains full information about checkout
    private final Poll Poll; // New poll state. Bots receive only updates about stopped polls and polls
    private final PollAnswer PollAnswer; // A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
    //private final ChatMemberUpdated MyChatMember; //  bot's chat member status was updated in a chat. For private chats, this update is received only when the bot is blocked or unblocked by the user.
    //private final ChatMemberUpdated ChatMember; //  A chat member's status was updated in a chat. The bot must be an administrator in the chat and must explicitly specify “chat_member” in the list of allowed_updates to receive these updates.


    // Constructor. Set all attributes at once to those
    // Defined by the builder process. Object is always
    // fully built, never half built when getters called
    private Update(Builder builder){
        this.UpdateId = builder.UpdateId;
        this.Message = builder.Message;
        this.EditedMessage = builder.EditedMessage;
        this.ChannelPost = builder.ChannelPost;
        this.EditedChannelPost = builder.EditedChannelPost;
        //this.InlineQuery = builder.InlineQuery;
        //this.ChosenInlineResult = builder.ChosenInlineResult;
        //this.CallbackQuery = builder.CallbackQuery;
        this.ShippingQuery = builder.ShippingQuery;
        this.PreCheckoutQuery = builder.PreCheckoutQuery;
        this.Poll = builder.Poll;
        this.PollAnswer = builder.PollAnswer;
        //this.MyChatMember = builder.MyChatMember;
        //this.ChatMember = builder.ChatMember;
    }

    // Getter methods
    @JsonProperty("update_id")
    public Integer getUpdateId(){return UpdateId;}
    @JsonProperty("message")
    public Message getMessage(){return Message;}
    @JsonProperty("edited_message")
    public Message getEditedMessage(){return EditedMessage;}
    @JsonProperty("channel_post")
    public Message getChannelPost(){return ChannelPost;}
    @JsonProperty("edited_channel_post")
    public Message getEditedChannelPost(){return EditedChannelPost;}
    //@JsonProperty("inline_query")
    //public InlineQuery getInlineQuery(){return InlineQuery;}
    //@JsonProperty("chosen_inline_result")
    //public ChosenInlineResult getChosenInlineResult(){return ChosenInlineResult;}
    //@JsonProperty("callback_query")
    //public CallbackQuery getCallbackQuery(){return CallbackQuery;}
    @JsonProperty("shipping_query")
    public ShippingQuery getShippingQuery(){return ShippingQuery;}
    @JsonProperty("pre_checkout_query")
    public PreCheckoutQuery getPreCheckoutQuery(){return PreCheckoutQuery;}
    @JsonProperty("poll")
    public Poll getPoll(){return Poll;}
    @JsonProperty("poll_answer")
    public PollAnswer getPollAnswer(){return PollAnswer;}
    //@JsonProperty("my_chat_member")
    //public ChatMemberUpdated getMyChatMember(){return MyChatMember;}
    //@JsonProperty("chat_member")
    //public ChatMemberUpdated getChatMember(){return ChatMember;}

    // Builder class
    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer UpdateId;
        private Message Message;
        private Message EditedMessage;
        private Message ChannelPost;
        private Message EditedChannelPost;
        //private InlineQuery InlineQuery; // New incoming inline query
        //private ChosenInlineResult ChosenInlineResult; // result of an inline query that was chosen by a user and sent to their chat partner
        //private CallbackQuery CallbackQuery; // New incoming callback query
        private ShippingQuery ShippingQuery; // New incoming shipping query. Only for invoices with flexible price
        private PreCheckoutQuery PreCheckoutQuery; // New incoming pre-checkout query. Contains full information about checkout
        private Poll Poll; // New poll state. Bots receive only updates about stopped polls and polls
        private PollAnswer PollAnswer; // A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
        //private ChatMemberUpdated MyChatMember; //  bot's chat member status was updated in a chat. For private chats, this update is received only when the bot is blocked or unblocked by the user.
        //private ChatMemberUpdated ChatMember; //  A chat member's status was updated in a chat. The bot must be an administrator in the chat and must explicitly specify “chat_member” in the list of allowed_updates to receive these updates.

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        // Setter methods
        @JsonProperty("update_id")
        public Builder setUpdateId(Integer id){
            this.UpdateId = id;
            return this;
        }

        @JsonProperty("message")
        public Builder setMessage(Message msg){
            this.Message = msg;
            return this;
        }

        @JsonProperty("edited_message")
        public Builder setEditedMessage(Message msg){
            this.EditedMessage = msg;
            return this;
        }

        @JsonProperty("channel_post")
        public Builder setChannelPost(Message msg){
            this.ChannelPost = msg;
            return this;
        }

        @JsonProperty("edited_channel_post")
        public Builder setEditedChannelPost(Message msg){
            this.EditedChannelPost = msg;
            return this;
        }

        //@JsonProperty("inline_query")
        //public Builder setInlineQuery(InlineQuery inlineQ){this.InlineQuery = inlineQ;return this;}
        //@JsonProperty("chosen_inline_result")
        //public Builder setChosenInlineResult(ChosenInlineResult chosenIlResult){this.ChosenInlineResult = chosenIlResult;return this;}
        //@JsonProperty("callback_query")
        //public Builder setCallbackQuery(CallbackQuery cbQuery){this.CallbackQuery = cbQuery;return this;}
        @JsonProperty("shipping_query")
        public Builder setShippingQuery(ShippingQuery shQuery){this.ShippingQuery = shQuery;return this;}
        @JsonProperty("pre_checkout_query")
        public Builder setPreCheckoutQuery(PreCheckoutQuery pChQuery){this.PreCheckoutQuery = pChQuery;return this;}
        @JsonProperty("poll")
        public Builder setPoll(Poll p){this.Poll = p;return this;}
        @JsonProperty("poll_answer")
        public Builder setPollAnswer(PollAnswer pa){this.PollAnswer = pa;return this;}
        //@JsonProperty("my_chat_member")
        //public Builder setMyChatMember(ChatMemberUpdated myChatMem){this.MyChatMember = myChatMem;return this;}
        //@JsonProperty("chat_member")
        //public Builder setChatMember(ChatMemberUpdated chatMem){this.ChatMember = chatMem;return this;}

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Update build(){
            return new Update(this);
        }
    }
}