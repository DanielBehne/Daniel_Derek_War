/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
import java.util.ArrayList;

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
        Deck dealtDeck[] = cardDeck.dealDeck();
        Deck deckHalf1 = dealtDeck[0];
        Deck deckHalf2 = dealtDeck[1];
        int halfLength1 = deckHalf1.getDeckSize();
        int halfLength2 = deckHalf2.getDeckSize();
        this.runEventLoop(cardDeck, deckHalf1, deckHalf2, halfLength1, halfLength2);
    }


    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck cardDeck, Deck deckHalf1, Deck deckHalf2, int halfLength1,int halfLength2) {
        boolean winner = false;
        ArrayList<Card> list1 = new ArrayList<Card>();
        ArrayList<Card> list2 = new ArrayList<Card>();
        int warLoop = 1;
        ArrayList<Card> constantWar = new ArrayList<Card>();
        int list1Size = list1.size();
        int list2Size = list2.size();
        while (winner == false) {
            Card dealtCard = deckHalf1.dealCardFromDeck();
            Card dealtCard2 = deckHalf2.dealCardFromDeck();
            int cardRank = dealtCard.getRank();
            int cardRank2 = dealtCard2.getRank();
            if (cardRank > cardRank2) {
                list1.add(dealtCard);
                list1.add(dealtCard2);
            } else if (cardRank2 > cardRank) {
                list2.add(dealtCard2);
                list2.add(dealtCard);
            } else {
                System.out.println("A war has happened!");
                war(deckHalf1, deckHalf2, list1, list2, cardRank, cardRank2, constantWar, warLoop);
            }
            if (list1Size == 0) {
                for (Card card : list1) {
                    deckHalf1.addCardToDeck(card);
                }
            } else if (list2Size == 0) {
                for (Card card : list2) {
                    deckHalf2.addCardToDeck(card);
                }
            }
        }
    }


    public static void war(Deck deckHalf1, Deck deckHalf2, ArrayList<Card> list1, ArrayList<Card> list2, int cardRank, int cardRank2, ArrayList<Card> constantWar, int warLoop ) {
        if (cardRank == cardRank2) {
            Card v1 = deckHalf1.dealCardFromDeck();
            constantWar.add(v1);
            Card v2 = deckHalf1.dealCardFromDeck();
            constantWar.add(v2);
            Card v3 = deckHalf1.dealCardFromDeck();
            constantWar.add(v3);
            Card v4 = deckHalf2.dealCardFromDeck();
            constantWar.add(v4);
            Card v5 = deckHalf2.dealCardFromDeck();
            constantWar.add(v5);
            Card v6 = deckHalf2.dealCardFromDeck();
            constantWar.add(v6);
            Card playCard = deckHalf1.dealCardFromDeck();
            constantWar.add(playCard);
            Card playCard2 = deckHalf2.dealCardFromDeck();
            constantWar.add(playCard2);
            int playCardRank = playCard.getRank();
            int playCardRank2 = playCard2.getRank();
            if (playCardRank > playCardRank2) {
                for (Card element : constantWar) {
                    list1.add(element);
                    int i = warLoop * 4;
                    warLoop = 1;
                    System.out.println("Player one has won gaining " + i + " cards");
                }
            } else if (playCardRank2 > playCardRank) {
                for (Card element : constantWar) {
                    list2.add(element);
                    int i = warLoop * 4;
                    warLoop = 1;
                    System.out.println("Player two has won gaining " + i + " cards");
                }
            } else {
                System.out.println("Another war has happened!");
                warLoop++;
                war(deckHalf1, deckHalf2, list1, list2, cardRank, cardRank2, constantWar, warLoop);
            }
        }
    }


    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }
}





