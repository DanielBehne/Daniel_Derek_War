
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
        cardDeck.dealDeck();
        Deck[] halves1 = halves[0];
        Deck halves2 = halves[1];
        Deck[] half = cardDeck.getHalves(); //have to get halves from Deck class somehow
        while (halves1.length > 0) {
            
        }
        cardDeck.dealCardFromDeck();
        cardDeck.addCardToDeck(cardToAdd); //need to initialize Card
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
