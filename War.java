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

        this.runEventLoop();
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        Deck cardDeck = new Deck();
        cardDeck.initializeNewDeck();
        cardDeck.shuffle();

        Deck dealtDeck[] = cardDeck.dealDeck();
        Deck deckHalf1 = dealtDeck[0];
        Deck deckHalf2 = dealtDeck[1];
        int halfLength1 = deckHalf1.getDeckSize();
        int halfLength2 = deckHalf2.getDeckSize();

        boolean winner = false;
        ArrayList<Card> list1 = new ArrayList<Card>();
        ArrayList<Card> list2 = new ArrayList<Card>();
        int warLoop = 1;

        int iterations = 0;

        while (deckHalf1.getDeckSize() > 0 && deckHalf2.getDeckSize() > 0)  {
            int list1Size = list1.size();
            int list2Size = list2.size();
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
                iterations++;
                if (iterations == 300) {
                    System.out.println("The game has ended.");
                    break;
                }
            } else if (cardRank2 > cardRank) {
                System.out.println("Player two has won the round");
                list2.add(dealtCard2);
                list2.add(dealtCard);
                iterations++;
                if (iterations == 300) {
                    System.out.println("The game has ended.");
                    break;
                }
            } else {
                System.out.println("    ");
                System.out.println("A war has happened!");
                System.out.println("    ");
                ArrayList<Card> constantWar = new ArrayList<Card>();
                constantWar.add(dealtCard);
                constantWar.add(dealtCard2);
                war(deckHalf1, deckHalf2, list1, list2, cardRank, cardRank2, constantWar);
                iterations++;
                if (iterations == 300) {
                    System.out.println("The game has ended.");
                    break;
                }
            }
            if (deckHalf1.getDeckSize() == 0 ) {
                for (Card card : list1) {
                    deckHalf1.addCardToDeck(card);
                }
                list1.clear();
            }
            if (deckHalf2.getDeckSize() == 0) {
                for (Card card : list2) {
                    deckHalf2.addCardToDeck(card);                
                }
                list2.clear();
            }
            System.out.println("Round number: " + iterations);
            System.out.println("player 1 deck: " + deckHalf1.getDeckSize());
            System.out.println("player 1 pile: " + list1.size());
            System.out.println("player 2 deck: " + deckHalf2.getDeckSize());
            System.out.println("player 2 pile: " + list2.size());
        } 
        if (deckHalf1.getDeckSize() == 0) {
            System.out.println("Player Two Has Won!");
        }
        if (deckHalf2.getDeckSize() == 0){
            System.out.println("Player One Has Won!");
        }
    }

    //loses cards during war
    public static void war(Deck deckHalf1, Deck deckHalf2, ArrayList<Card> list1, ArrayList<Card> list2, int cardRank, int cardRank2, ArrayList<Card> constantWar) {
        if (deckHalf1.getDeckSize() < 5 ) {
            for (Card card : list1) {
                deckHalf1.addCardToDeck(card);
            }
            list1.clear();
        }
        if (deckHalf2.getDeckSize() < 5) {
            for (Card card : list2) {
                deckHalf2.addCardToDeck(card);                
            }
            list2.clear();
        }
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
        deckHalf1.addCardToDeck(playCard);
        Card playCard2 = deckHalf2.dealCardFromDeck();
        deckHalf2.addCardToDeck(playCard2);
        int playCardRank = playCard.getRank();
        int playCardRank2 = playCard2.getRank();
        for (Card element : constantWar) {
            System.out.println("Card " + element.getFace() + " of " + element.getSuit() + " has been put down as a war card");
        }
        System.out.println("");
        System.out.println("Card " + playCard.getFace() + " of " + playCard.getSuit() +  " has been put down as the card to compare for player1");
        System.out.println("Card " + playCard2.getFace() + " of " + playCard2.getSuit() +  " has been put down as the card to compare for player2");
        if (playCardRank > playCardRank2) {
            System.out.println("    ");
            System.out.println("Player one has won the war.");
            for (Card card : constantWar) {
                list1.add(card);                
            }
            constantWar.clear();
        } else if (playCardRank2 > playCardRank) {
            System.out.println("    ");
            System.out.println("Player two has won the war.");
            for (Card card : constantWar) {
                list2.add(card);                
            }
            constantWar.clear();
        } else if (playCardRank == playCardRank2) {
            System.out.println("    ");
            System.out.println("Another war has happened!");
            System.out.println("    ");
            war(deckHalf1, deckHalf2, list1, list2, cardRank, cardRank2, constantWar);
        }
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }
}

