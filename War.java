
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    { 
        // Initializations here...
        Deck cardDeck = new Deck();
        cardDeck.initializeNewDeck();
        cardDeck.shuffle();
        
        Deck[] deck = cardDeck.dealDeck();
        Deck halves1 = deck[0];
        Deck halves2 = deck[1];
        
        Card dealtCard = cardDeck.dealCardFromDeck();
        Card cardtoAdd = dealtCard;
        cardDeck.addCardToDeck(cardtoAdd); 
        // ...then run the event loop
        this.runEventLoop(cardDeck);
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck cardDeck) {
        //do we have to initialize halves1 & 2 here also?
        cardDeck.shuffle();
        cardDeck.dealDeck();
        while (halves1.length < 52 && halves2.length < 52) {
            dealCardFromDeck(halves1);
        }
        //need to somehow get halves to work & make Card topCard from dealCardFromDeck come here
        
        
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
