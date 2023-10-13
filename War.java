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
        while (deckHalf1.getDeckSize() > 0 && deckHalf2.getDeckSize() > 0)  {
            System.out.println("    ");
            Card dealtCard = deckHalf1.dealCardFromDeck();
            System.out.println("Card " + dealtCard.getFace() + " of " + dealtCard.getSuit() + " has been dealt.");
            Card dealtCard2 = deckHalf2.dealCardFromDeck();
            System.out.println("Card " + dealtCard2.getFace() + " of " + dealtCard2.getSuit() + " has been dealt.");
            int cardRank = dealtCard.getRank();
            int cardRank2 = dealtCard2.getRank();
            if (cardRank > cardRank2) {
                System.out.println("Player one has won the round");
                list1.add(dealtCard);
                list1.add(dealtCard2);
            } else if (cardRank2 > cardRank) {
                System.out.println("Player two has won the round");
                list2.add(dealtCard2);
                list2.add(dealtCard);
            } else {
                System.out.println("    ");
                System.out.println("A war has happened!");
                war(deckHalf1, deckHalf2, list1, list2, cardRank, cardRank2, constantWar, warLoop);
            }
            if (deckHalf1.getDeckSize() == 0) {
                for (Card card : list1) {
                    deckHalf1.addCardToDeck(card);
                }
            }
            if (deckHalf1.getDeckSize() == 0) {
                for (Card card : list2) {
                    deckHalf2.addCardToDeck(card);
                }
            }
        } 
        if (list1.size() == 0) {
            System.out.println("Player Two Has Won!");
        } else {
            System.out.println("Player One Has Won!");
        }
    }


    public static void war(Deck deckHalf1, Deck deckHalf2, ArrayList<Card> list1, ArrayList<Card> list2, int cardRank, int cardRank2, ArrayList<Card> constantWar, int warLoop ) {
        if (cardRank == cardRank2) {
            Card v1 = deckHalf1.dealCardFromDeck();
            Card v2 = deckHalf1.dealCardFromDeck();
            Card v3 = deckHalf1.dealCardFromDeck();
            Card v4 = deckHalf2.dealCardFromDeck();
            Card v5 = deckHalf2.dealCardFromDeck();;
            Card v6 = deckHalf2.dealCardFromDeck();
            constantWar.add(v1);
            constantWar.add(v2);
            constantWar.add(v3);
            constantWar.add(v4);
            constantWar.add(v5);
            constantWar.add(v6);
            Card playCard = deckHalf1.dealCardFromDeck();
            constantWar.add(playCard);
            Card playCard2 = deckHalf2.dealCardFromDeck();
            constantWar.add(playCard2);
            int playCardRank = playCard.getRank();
            int playCardRank2 = playCard2.getRank();
            for (Card element : constantWar) {
                System.out.println("Card " + element.getFace() + " of " + element.getSuit() + " has been put down as a war card");
            }
            if (playCardRank > playCardRank2) {
                System.out.println("Player one has won the war.");
            } else if (playCardRank2 > playCardRank) {
                System.out.println("Player two has won the war.");
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





