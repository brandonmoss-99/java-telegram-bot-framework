# Telegram Bot Framework
A Telegram bot framework written in Java, for making the development of Telegram bots easier.

## Notice
This is still a work in progress (Dev branch). There will be missing features, bugs, untested & undocumented code. The original end goal was always to help me learn new coding techniques.

### Usage & bot examples
This framework relies heavily on builder patterns, so bots using this will have plenty of `.build()` method calls. Below is a very basic Telegram bot code example that utilise the framework to function:

#### Reply to a message with the user's first name & a random item from a list


```Java
public class Program {
    public static void main(String[] args){
        /* Create a new Telegram client, passing in your bot's API token
        and run the main bot code */
        TelegramClient client = new TelegramClient(args[0]);
        randomPokemonSelector(client);
    }

    public static void randomPokemonSelector(TelegramClient client){
        // Create list of Pokemon to use
        String[] pokemon = {"BULBASAUR", "IVYSAUR", "CHARMANDER", 
            "CHARMELEON", "CHARIZARD", "SQUIRTLE"};
        // Create random number generator
        Random random = new Random();
        // Set initial offset for Telegram, to fetch all new messages
        int offset = 0;

        // Run the bot update/process loop until terminated
        while(true){
            // Fetch updates from Telegram servers
            UpdateResponse update = client.GetUpdates(GetUpdates.Builder.newInstance()
                .setOffset(offset)
                .setTimeout(20)
                .build());

            // For each update in the list of updates, get the message contents
            for (Update msg : update.getResult()){
                Message cMsg = msg.getMessage();

                /* Create the reply message, using the message sender's
                first name and a random Pokemon from the list */
                Message toReply = Message.Builder.newInstance()
                    .setText(cMsg.getFrom().getFirstName() + ", your pokemon is " + 
                    pokemon[random.nextInt(pokemon.length)]).build();

                /* Send the reply message to the update user's ID, with the text
                we just created as its content */
                client.SendMessage(SendMessage.Builder.newInstance(cMsg.getChat().getId(), 
                    toReply.getText()).build());

                /* Set the offset used to fetch updates to 1 more than the update ID
                of the message we just dealt with, which marks to telegram on the
                next update that its been dealt with and to forget about it */
                offset = msg.getUpdateId() + 1;
            }
        }
    }
}
```