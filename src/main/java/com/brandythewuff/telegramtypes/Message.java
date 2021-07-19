package com.brandythewuff.telegramtypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.*;

import java.util.ArrayList;

@JsonDeserialize(builder = Message.Builder.class)
public class Message{
    private final Integer MessageId;
    private final User From;
    private final Chat SenderChat;
    private final Integer Date;                           // UNIX timestamp of when message was sent
    private final Chat Chat;                          // Conversation the message belongs to
    private final User ForwardFrom;                 // Sender of a forwarded message
    private final Chat ForwardFromChat;             // Chat info for forwarded message sent location
    private final Integer ForwardFromMessageId;         // ID of original message in a channel if forwarded
    private final String ForwardSignature;            // Signature of post author if present, for forwarded messages from channels
    private final String ForwardSenderName;           // Sender's name for messages forwarded from users who disallow linking to their account in forwarded messages
    private final Integer ForwardDate;
    private final Message ReplyToMessage;
    private final User ViaBot;
    private final Integer EditDate;
    private final String MediaGroupId;
    private final String AuthorSignature;
    private final String Text;
    private final ArrayList<MessageEntity> Entities;
    private final Animation Animation;
    private final Audio Audio;
    private final Document Document;
    private final ArrayList<PhotoSize> Photo;
    private final Sticker Sticker;
    private final Video Video;
    private final VideoNote VideoNote;
    private final Voice Voice;
    private final String Caption;
    private final ArrayList<MessageEntity> CaptionEntities;
    private final Contact Contact;
    private final Dice Dice;
    private final Game Game;
    private final Poll Poll;
    private final Venue Venue;
    private final Location Location;
    private final ArrayList<User> NewChatMembers;
    private final User LeftChatMember;
    private final String NewChatTitle;
    private final ArrayList<PhotoSize> NewChatPhoto;
    private final Boolean DeleteChatPhoto;
    private final Boolean GroupChatCreated;
    private final Boolean SupergroupChatCreated;
    private final Boolean ChannelChatCreated;
    private final MessageAutoDeleteTimerChanged MessageAutoDeleteTimerChanged;
    private final Long MigrateToChatId;
    private final Long MigrateFromChatId;
    private final Message PinnedMessage;
    private final Invoice Invoice;
    private final SuccessfulPayment SuccessfulPayment;
    private final String ConnectedWebsite;
    private final VoiceChatScheduled VoiceChatScheduled;
    private final VoiceChatEnded VoiceChatEnded;
    private final VoiceChatParticipantsInvited VoiceChatParticipantsInvited;
    //private final InlineKeyboardMarkup ReplyMarkup;*/

    private Message(Builder builder){
        this.MessageId = builder.MessageId;
        this.From = builder.From;
        this.SenderChat = builder.SenderChat;
        this.Date = builder.Date;
        this.Chat = builder.Chat;
        this.ForwardFrom = builder.ForwardFrom;
        this.ForwardFromChat = builder.ForwardFromChat;
        this.ForwardFromMessageId = builder.ForwardFromMessageId;
        this.ForwardSignature = builder.ForwardSignature;
        this.ForwardSenderName = builder.ForwardSenderName;
        this.ForwardDate = builder.ForwardDate;
        this.ReplyToMessage = builder.ReplyToMessage;
        this.ViaBot = builder.ViaBot;
        this.EditDate = builder.EditDate;
        this.MediaGroupId = builder.MediaGroupId;
        this.AuthorSignature = builder.AuthorSignature;
        this.Text = builder.Text;
        this.Entities = builder.Entities;
        this.Animation = builder.Animation;
        this.Audio = builder.Audio;
        this.Document = builder.Document;
        this.Photo = builder.Photo;
        this.Sticker = builder.Sticker;
        this.Video = builder.Video;
        this.VideoNote = builder.VideoNote;
        this.Voice = builder.Voice;
        this.Caption = builder.Caption;
        this.CaptionEntities = builder.CaptionEntities;
        this.Contact = builder.Contact;
        this.Dice = builder.Dice;
        this.Game = builder.Game;
        this.Poll = builder.Poll;
        this.Venue = builder.Venue;
        this.Location = builder.Location;
        this.NewChatMembers = builder.NewChatMembers;
        this.LeftChatMember = builder.LeftChatMember;
        this.NewChatTitle = builder.NewChatTitle;
        this.NewChatPhoto = builder.NewChatPhoto;
        this.DeleteChatPhoto = builder.DeleteChatPhoto;
        this.GroupChatCreated = builder.GroupChatCreated;
        this.SupergroupChatCreated = builder.SupergroupChatCreated;
        this.ChannelChatCreated = builder.ChannelChatCreated;
        this.MessageAutoDeleteTimerChanged = builder.MessageAutoDeleteTimerChanged;
        this.MigrateToChatId = builder.MigrateToChatId;
        this.MigrateFromChatId = builder.MigrateFromChatId;
        this.PinnedMessage = builder.PinnedMessage;
        this.Invoice = builder.Invoice;
        this.SuccessfulPayment = builder.SuccessfulPayment;
        this.ConnectedWebsite = builder.ConnectedWebsite;
        this.VoiceChatScheduled = builder.VoiceChatScheduled;
        this.VoiceChatEnded = builder.VoiceChatEnded;
        this.VoiceChatParticipantsInvited = builder.VoiceChatParticipantsInvited;
        //this.ReplyMarkup = builder.Markup;
    }

    // Getter methods
    @JsonProperty("message_id")
    public Integer getMessageId(){return MessageId;}
    @JsonProperty("date")
    public Integer getDate(){return Date;}
    @JsonProperty("text")
    public String getText(){return Text;}
    @JsonProperty("sender_chat")
    public Chat getSenderChat(){return SenderChat;}
    @JsonProperty("chat")
    public Chat getChat(){return Chat;}
    @JsonProperty("from")
    public User getFrom(){return From;}
    @JsonProperty("forward_from")
    public User getForwardFrom(){return ForwardFrom;}
    @JsonProperty("forward_from_chat")
    public Chat getForwardFromChat(){return ForwardFromChat;}
    @JsonProperty("forward_from_message_id")
    public Integer getForwardFromMessageId(){return ForwardFromMessageId;}
    @JsonProperty("forward_signature")
    public String getForwardSignature(){return ForwardSignature;}
    @JsonProperty("forward_sender_name")
    public String getForwardSenderName(){return ForwardSenderName;}
    @JsonProperty("forward_date")
    public Integer getForwardDate(){return ForwardDate;}
    @JsonProperty("reply_to_message")
    public Message getReplyToMessage(){return ReplyToMessage;}
    @JsonProperty("via_bot")
    public User getViaBot(){return ViaBot;}
    @JsonProperty("edit_date")
    public Integer getEditDate(){return EditDate;}
    @JsonProperty("media_group_id")
    public String getMediaGroupId(){return MediaGroupId;}
    @JsonProperty("author_signature")
    public String getAuthorSignature(){return AuthorSignature;}
    @JsonProperty("entities")
    public ArrayList<MessageEntity> getEntities(){return Entities;}
    @JsonProperty("animation")
    public Animation getAnimation(){return Animation;}
    @JsonProperty("audio")
    public Audio getAudio(){return Audio;}
    @JsonProperty("document")
    public Document getDocument(){return Document;}
    @JsonProperty("photo")
    public ArrayList<PhotoSize> getPhoto(){return Photo;}
    @JsonProperty("sticker")
    public Sticker getSticker(){return Sticker;}
    @JsonProperty("video")
    public Video getVideo(){return Video;}
    @JsonProperty("video_note")
    public VideoNote getVideoNote(){return VideoNote;}
    @JsonProperty("voice")
    public Voice getVoice(){return Voice;}
    @JsonProperty("caption")
    public String getCaption(){return Caption;}
    @JsonProperty("caption_entities")
    public ArrayList<MessageEntity> getCaptionEntities(){return CaptionEntities;}
    @JsonProperty("contact")
    public Contact getContact(){return Contact;}
    @JsonProperty("dice")
    public Dice getDice(){return Dice;}
    @JsonProperty("game")
    public Game getGame(){return Game;}
    @JsonProperty("poll")
    public Poll getPoll(){return Poll;}
    @JsonProperty("venue")
    public Venue getVenue(){return Venue;}
    @JsonProperty("location")
    public Location getLocation(){return Location;}
    @JsonProperty("new_chat_members")
    public ArrayList<User> getNewChatMembers(){return NewChatMembers;}
    @JsonProperty("left_chat_member")
    public User getLeftChatMember(){return LeftChatMember;}
    @JsonProperty("new_chat_title")
    public String getNewChatTitle(){return NewChatTitle;}
    @JsonProperty("new_chat_photo")
    public ArrayList<PhotoSize> getNewChatPhoto(){return NewChatPhoto;}
    @JsonProperty("delete_chat_photo")
    public Boolean getDeleteChatPhoto(){return DeleteChatPhoto;}
    @JsonProperty("group_chat_created")
    public Boolean getGroupChatCreated(){return GroupChatCreated;}
    @JsonProperty("supergroup_chat_created")
    public Boolean getSupergroupChatCreated(){return SupergroupChatCreated;}
    @JsonProperty("channel_chat_created")
    public Boolean getChannelChatCreated(){return ChannelChatCreated;}
    @JsonProperty("message_auto_delete_timer_changed")
    public MessageAutoDeleteTimerChanged getMessageAutoDeleteTimerChanged(){return MessageAutoDeleteTimerChanged;}
    @JsonProperty("migrate_to_chat_id")
    public Long getMigrateToChatId(){return MigrateToChatId;}
    @JsonProperty("migrate_from_chat_id")
    public Long getMigrateFromChatId(){return MigrateFromChatId;}
    @JsonProperty("pinned_message")
    public Message getPinnedMessage(){return PinnedMessage;}
    @JsonProperty("invoice")
    public Invoice getInvoice(){return Invoice;}
    @JsonProperty("successful_payment")
    public SuccessfulPayment getSuccessfulPayment(){return SuccessfulPayment;}
    @JsonProperty("connected_website")
    public String getConnectedWebsite(){return ConnectedWebsite;}
    @JsonProperty("voice_chat_scheduled")
    public VoiceChatScheduled getVoiceChatScheduled(){return VoiceChatScheduled;}
    @JsonProperty("voice_chat_ended")
    public VoiceChatEnded getVoiceChatEnded(){return VoiceChatEnded;}
    @JsonProperty("voice_chat_participants_invited")
    public VoiceChatParticipantsInvited getVoiceChatParticipantsInvited(){return VoiceChatParticipantsInvited;}
    //@JsonProperty("reply_markup")
    //public InlineKeyboardMarkup getInlineKeyboardMarkup(){return InlineKeyboardMarkup;}

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Integer MessageId;
        private User From;
        private Chat SenderChat;
        private Integer Date;                           // UNIX timestamp of when message was sent
        private Chat Chat;                          // Conversation the message belongs to
        private User ForwardFrom;                 // Sender of a forwarded message
        private Chat ForwardFromChat;             // Chat info for forwarded message sent location
        private Integer ForwardFromMessageId;         // ID of original message in a channel if forwarded
        private String ForwardSignature;            // Signature of post author if present, for forwarded messages from channels
        private String ForwardSenderName;           // Sender's name for messages forwarded from users who disallow linking to their account in forwarded messages
        private Integer ForwardDate;
        private Message ReplyToMessage;
        private User ViaBot;
        private Integer EditDate;
        private String MediaGroupId;
        private String AuthorSignature;
        private String Text;
        private ArrayList<MessageEntity> Entities;
        private Animation Animation;
        private Audio Audio;
        private Document Document;
        private ArrayList<PhotoSize> Photo;
        private Sticker Sticker;
        private Video Video;
        private VideoNote VideoNote;
        private Voice Voice;
        private String Caption;
        private ArrayList<MessageEntity> CaptionEntities;
        private Contact Contact;
        private Dice Dice;
        private Game Game;
        private Poll Poll;
        private Venue Venue;
        private Location Location;
        private ArrayList<User> NewChatMembers;
        private User LeftChatMember;
        private String NewChatTitle;
        private ArrayList<PhotoSize> NewChatPhoto;
        private Boolean DeleteChatPhoto;
        private Boolean GroupChatCreated;
        private Boolean SupergroupChatCreated;
        private Boolean ChannelChatCreated;
        private MessageAutoDeleteTimerChanged MessageAutoDeleteTimerChanged;
        private Long MigrateToChatId;
        private Long MigrateFromChatId;
        private Message PinnedMessage;
        private Invoice Invoice;
        private SuccessfulPayment SuccessfulPayment;
        private String ConnectedWebsite;
        private VoiceChatScheduled VoiceChatScheduled;
        private VoiceChatEnded VoiceChatEnded;
        private VoiceChatParticipantsInvited VoiceChatParticipantsInvited;
        //private InlineKeyboardMarkup ReplyMarkup;*/

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){}

        // Setter methods
        @JsonProperty("message_id")
        public Builder setMessageId(Integer msgId){
            this.MessageId = msgId;
            return this;
        }

        @JsonProperty("from")
        public Builder setFrom(User from){
            this.From = from;
            return this;
        }

        @JsonProperty("sender_chat")
        public Builder setSenderChat(Chat senderChat){
            this.SenderChat = senderChat;
            return this;
        }

        @JsonProperty("date")
        public Builder setDate(Integer d){
            this.Date = d;
            return this;
        }

        @JsonProperty("chat")
        public Builder setChat(Chat c){
            this.Chat = c;
            return this;
        }

        @JsonProperty("forward_from")
        public Builder setForwardFrom(User forwardFrom){
            this.ForwardFrom = forwardFrom;
            return this;
        }

        @JsonProperty("forward_from_chat")
        public Builder setForwadFromChat(Chat fwdChat){
            this.ForwardFromChat = fwdChat;
            return this;
        }

        @JsonProperty("forward_from_message_id")
        public Builder setForwardFromMessageId(Integer fwdMsgId){
            this.ForwardFromMessageId = fwdMsgId;
            return this;
        }

        @JsonProperty("forward_signature")
        public Builder setForwardSignature(String fwdSignature){
            this.ForwardSignature = fwdSignature;
            return this;
        }

        @JsonProperty("forward_sender_name")
        public Builder setForwardSenderName(String fwdSendName){
            this.ForwardSenderName = fwdSendName;
            return this;
        }

        @JsonProperty("forward_date")
        public Builder setForwardDate(Integer fwdDate){
            this.ForwardDate = fwdDate;
            return this;
        }

        @JsonProperty("reply_to_message")
        public Builder setReplyToMessage(Message replyToMsg){
            this.ReplyToMessage = replyToMsg;
            return this;
        }

        @JsonProperty("via_bot")
        public Builder setViaBot(User viaBot){
            this.ViaBot = viaBot;
            return this;
        }
        @JsonProperty("edit_date")
        public Builder setEditDate(Integer editDate){
            this.EditDate = editDate;
            return this;
        }

        @JsonProperty("media_group_id")
        public Builder setMediaGroupId(String mediaGroupId){
            this.MediaGroupId = mediaGroupId;
            return this;
        }

        @JsonProperty("author_signature")
        public Builder setAuthorSignature(String authSig){
            this.AuthorSignature = authSig;
            return this;
        }

        @JsonProperty("text")
        public Builder setText(String txt){
            this.Text = txt;
            return this;
        }

        @JsonProperty("entities")
        public Builder setEntities(ArrayList<MessageEntity> entities){
            this.Entities = entities;
            return this;
        }

        @JsonProperty("animation")
        public Builder setAnimation(Animation anim){
            this.Animation = anim;
            return this;
        }

        @JsonProperty("audio")
        public Builder setAudio(Audio audio){
            this.Audio = audio;
            return this;
        }

        @JsonProperty("document")
        public Builder setDocument(Document doc){
            this.Document = doc;
            return this;
        }

        @JsonProperty("photo")
        public Builder setPhoto(ArrayList<PhotoSize> photo){
            this.Photo = photo;
            return this;
        }

        @JsonProperty("sticker")
        public Builder setSticker(Sticker sticker){
            this.Sticker = sticker;
            return this;
        }

        @JsonProperty("video")
        public Builder setVideo(Video vid){
            this.Video = vid;
            return this;
        }

        @JsonProperty("video_note")
        public Builder setVideoNote(VideoNote vn){
            this.VideoNote = vn;
            return this;
        }

        @JsonProperty("voice")
        public Builder setVoice(Voice voice){
            this.Voice = voice;
            return this;
        }

        @JsonProperty("caption")
        public Builder setCaption(String cap){
            this.Caption = cap;
            return this;
        }

        @JsonProperty("caption_entities")
        public Builder setCaptionEntities(ArrayList<MessageEntity> capEnt){
            this.CaptionEntities = capEnt;
            return this;
        }

        @JsonProperty("contact")
        public Builder setContact(Contact cont){
            this.Contact = cont;
            return this;
        }

        @JsonProperty("dice")
        public Builder setDice(Dice d){
            this.Dice = d;
            return this;
        }

        @JsonProperty("game")
        public Builder setGame(Game game){
            this.Game = game;
            return this;
        }

        @JsonProperty("poll")
        public Builder setPoll(Poll p){
            this.Poll = p;
            return this;
        }

        @JsonProperty("venue")
        public Builder setVenue(Venue ven){
            this.Venue = ven;
            return this;
        }

        @JsonProperty("location")
        public Builder setLocation(Location loc){
            this.Location = loc;
            return this;
        }

        @JsonProperty("new_chat_members")
        public Builder setNewChatMembers(ArrayList<User> usrs){
            this.NewChatMembers = usrs;
            return this;
        }

        @JsonProperty("left_chat_member")
        public Builder setLeftChatMember(User lusr){
            this.LeftChatMember = lusr;
            return this;
        }

        @JsonProperty("new_chat_title")
        public Builder setNewChatTitle(String newTitle){
            this.NewChatTitle = newTitle;
            return this;
        }

        @JsonProperty("new_chat_photo")
        public Builder setNewChatPhoto(ArrayList<PhotoSize> newCPhoto){
            this.NewChatPhoto = newCPhoto;
            return this;
        }

        @JsonProperty("delete_chat_photo")
        public Builder setDeleteChatPhoto(Boolean delCPhoto){
            this.DeleteChatPhoto = delCPhoto;
            return this;
        }

        @JsonProperty("group_chat_created")
        public Builder setGroupChatCreated(Boolean groupCCreated){
            this.GroupChatCreated = groupCCreated;
            return this;
        }

        @JsonProperty("supergroup_chat_created")
        public Builder setSupergroupChatCreated(Boolean superCCreated){
            this.SupergroupChatCreated = superCCreated;
            return this;
        }

        @JsonProperty("channel_chat_created")
        public Builder setChannelChatCreated(Boolean chanCCreated){
            this.ChannelChatCreated = chanCCreated;
            return this;
        }

        @JsonProperty("message_auto_delete_timer_changed")
        public Builder setMessageAutoDeleteTimerChanged(MessageAutoDeleteTimerChanged autc){
            this.MessageAutoDeleteTimerChanged = autc;
            return this;
        }

        @JsonProperty("migrate_to_chat_id")
        public Builder setMigrateToChatId(Long mtId){
            this.MigrateToChatId = mtId;
            return this;
        }

        @JsonProperty("migrate_from_chat_id")
        public Builder setMigrateFromChatId(Long mfId){
            this.MigrateFromChatId = mfId;
            return this;
        }

        @JsonProperty("pinned_message")
        public Builder setPinnedMessage(Message pmsg){
            this.PinnedMessage = pmsg;
            return this;
        }

        @JsonProperty("invoice")
        public Builder setInvoice(Invoice invoice){
            this.Invoice = invoice;
            return this;
        }

        @JsonProperty("successful_payment")
        public Builder setSuccessfulPayment(SuccessfulPayment sucPay){
            this.SuccessfulPayment = sucPay;
            return this;
        }

        @JsonProperty("connected_website")
        public Builder setConnectedWebsite(String conWeb){
            this.ConnectedWebsite = conWeb;
            return this;
        }

        @JsonProperty("voice_chat_scheduled")
        public Builder setVoiceChatScheduled(VoiceChatScheduled vcsh){
            this.VoiceChatScheduled = vcsh;
            return this;
        }

        @JsonProperty("voice_chat_ended")
        public Builder setVoiceChatEnded(VoiceChatEnded vcend){
            this.VoiceChatEnded = vcend;
            return this;
        }

        @JsonProperty("voice_chat_participants_invited")
        public Builder setVoiceChatParticipantsInvited(VoiceChatParticipantsInvited vcpi){
            this.VoiceChatParticipantsInvited = vcpi;
            return this;
        }

        //@JsonProperty("reply_markup")
        /*public Builder setInlineKeyboardMarkup(InlineKeyboardMarkup ikmarkup){
            this.InlineKeyboardMarkup = ikmarkup;
            return this;
        }*/

        // Build method to deal with outer class, return an instance
        // Of the outer class, with all the parameters set in the
        // builder returned with it
        public Message build(){
            return new Message(this);
        }
    }
}